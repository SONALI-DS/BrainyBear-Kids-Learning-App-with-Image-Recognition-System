package com.example.brainybearapp.paint;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.example.brainybearapp.R;

import java.io.File;


public class ActivityPaint extends AppCompatActivity implements View.OnClickListener
{
    private CanvasExporter canvasExporter;
    private CanvasView canvasView;
    private ScaleGestureDetector scaleGestureDetector;

//    handle setting up the UIs and scale gestures,

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // set the view of the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        hideUINavigation();

        canvasExporter = new CanvasExporter();
        canvasView = findViewById(R.id.canvasView);

        ScaleHandler scaleHandler = createScaleHandler();
        scaleGestureDetector = new ScaleGestureDetector(ActivityPaint.this, scaleHandler);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        canvasView.initialise(displayMetrics.widthPixels, displayMetrics.heightPixels);
        canvasView.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                // pass the touch event
                scaleGestureDetector.onTouchEvent(event);
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:

                        handleUIElements(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:

                        handleUIElements(View.VISIBLE);
                        break;
                }

                if (event.getPointerCount() == 1 && !scaleGestureDetector.isInProgress())
                {
                    if (canvasView.getPreviousStrokeWidth() == canvasView.getStrokeWidth())
                    {
                        canvasView.handleTouches(event.getX(), event.getY(), event.getAction());
                    } else
                    {
                        canvasView.undo();
                    }

                    canvasView.setPreviousStrokeWidth(canvasView.getStrokeWidth());
                }
                return true;
            }
        });

        ImageButton clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(this);

        ImageButton undoButton = findViewById(R.id.undoButton);
        undoButton.setOnClickListener(this);

        ImageButton redoButton = findViewById(R.id.redoButton);
        redoButton.setOnClickListener(this);

        ImageButton styleButton = findViewById(R.id.colours_btn);
        styleButton.setOnClickListener(this);

        ImageButton saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

        ImageButton shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(this);
    }


    private void hideUINavigation()
    {
        // retrieve the View
        final View view = getWindow().getDecorView();
        final int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        // set the flags
        view.setSystemUiVisibility(flags);
        view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {

            @Override
            public void onSystemUiVisibilityChange(int visibility)
            {
                // if the application is no longer full-screen, make it so
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                    view.setSystemUiVisibility(flags);
            }
        });
    }


    private ScaleHandler createScaleHandler()
    {
        // retrieve the UI pen icon which is used to represent changes in pen size
        ImageView penIcon = findViewById(R.id.penSizeIcon);
        // create a new ScaleHandler object and attach a scale changed listener
        ScaleHandler scaleHandler = new ScaleHandler();
        scaleHandler.setOnScaleChangedListener(new ScaleHandler.ScaleChangedListener()
        {

            @Override
            public GradientDrawable onScaleIconRequired()
            {
                // retrieve the pen icon as a GradientDrawable object
                GradientDrawable gradientDrawable = (GradientDrawable) penIcon.getBackground();
                gradientDrawable.setColor(canvasView.getColour());

                return gradientDrawable;
            }


            @Override
            public Context getContext()
            {
                return ActivityPaint.this;
            }


            @Override
            public Resources getContextResources()
            {
                return getResources();
            }


            @Override
            public void onScaleStarted()
            {
                // display the pen icon
                penIcon.setVisibility(View.VISIBLE);
            }


            @Override
            public void onScaleChanged(float scaleFactor)
            {
                // if the user has scaled to the minimum or maximum size, adjust the size to be one less to ensure
                // that the previous stroke width is different from the current to prevent erroneous drawing
                if (scaleFactor == ScaleHandler.MIN_WIDTH || scaleFactor == ScaleHandler.MAX_WIDTH)
                    canvasView.setPreviousStrokeWidth(Math.round(scaleFactor) - 1);
                canvasView.setStrokeWidth(Math.round(scaleFactor));
                // get the width/height values of the pen icon as a LayoutParams object
                ViewGroup.LayoutParams params = penIcon.getLayoutParams();
                params.width = (int) scaleFactor;
                params.height = (int) scaleFactor;
                // set the scale factor as the size of the pen and pen icon
                penIcon.setLayoutParams(params);
            }


            @Override
            public void onScaleEnded()
            {
                // hide the pen icon
                penIcon.setVisibility(View.GONE);
            }
        });
        return scaleHandler;
    }

    private void handleUIElements (int showType)
    {
        // get the view elements as a ViewGroup
        ViewGroup viewGroup = findViewById(R.id.container);
        // loop through each element
        for (int i = 0; i < viewGroup.getChildCount(); i++)
        {
            View view = viewGroup.getChildAt(i);
            // if the view is not the canvas or the pen size icon, hide/show it
            if (view.getId() != R.id.canvasView && view.getId() != R.id.penSizeIcon)
                view.setVisibility(showType);
        }
    }


    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        if (viewID == R.id.clearButton)
        {
            // clear the canvas
            canvasView.clear();
        } else if (viewID == R.id.undoButton)
        {
            // undo the most recent drawing action
            canvasView.undo();
        } else if (viewID == R.id.redoButton)
        {
            // redraw the most recently undone action
            canvasView.redo();
        } else if (viewID == R.id.colours_btn)
        {
            // generate a new ColourPickerDialog to allow the user to change colour
            ColourPicker dialog = new ColourPicker(ActivityPaint.this, canvasView.getColour());
            dialog.setOnDialogOptionSelectedListener(new ColourPicker.ColourPickerOptionSelectedListener()
            {

                @Override
                public void onColourPickerOptionSelected(int colour)
                {
                    // set the colour of the pen to the chosen colour via a callback
                    canvasView.setColour(colour);
                }
            });
            dialog.show();
        } else if (viewID == R.id.saveButton)
        {
            // set the export type to save and then check for permission
            canvasExporter.setExportType(CanvasExporter.FLAG_SAVE);
            checkForPermissions();
        } else if (viewID == R.id.shareButton)
        {
            // set the export type to share and then check for permission
            canvasExporter.setExportType(CanvasExporter.FLAG_SHARE);
            checkForPermissions();
        }
    }


    private void requestStoragePermission ()
    {
        String permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        // request the permission to write to storage
        ActivityCompat.requestPermissions(this, new String[]{permission},
                CanvasExporter.PERMISSION_WRITE_EXTERNAL_STORAGE);
    }


    private void checkForPermissions()
    {
        int permission = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission == PackageManager.PERMISSION_DENIED)
        {
            // if the user has not granted permission
            boolean shouldShowRationale = ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (shouldShowRationale)
            {
                // display a rationale for saving (why the permission is needed)
                StorageRationale dialog = new StorageRationale(ActivityPaint.this);
                dialog.setOnStorageRationaleOptionSelectedListener(new StorageRationale.StorageRationaleOptionSelectedListener()
                {

                    @Override
                    public void onStorageRationaleOptionSelected(boolean allow)
                    {
                        // if the user accepts the storage permission in the dialog, request it officially
                        if (allow)
                            requestStoragePermission();
                    }
                });
                dialog.show();
            } else
            {
                // request the permission to write to storage
                requestStoragePermission();
            }
        } else
        {
            // save/share the image as permission already granted
            exportImage();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // if the permission is for writing to storage
        if (requestCode == CanvasExporter.PERMISSION_WRITE_EXTERNAL_STORAGE)
        {
            // if the results are not empty and have been granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                // save/share the drawing as an image
                exportImage();
            } else
            {
                // disable the buttons and save/share functionality
                findViewById(R.id.saveButton).setEnabled(false);
                findViewById(R.id.saveButton).setAlpha(0.5f);
                findViewById(R.id.shareButton).setEnabled(false);
                findViewById(R.id.shareButton).setAlpha(0.5f);
            }
        }
    }


    private void exportImage ()
    {
        if (canvasExporter.getExportType() == CanvasExporter.FLAG_SAVE)
        {
            // if the user is wanting to save, attempt and return its filename
            String fileName = canvasExporter.saveImage(canvasView.getBitmap());

            if (fileName != null)
            {
                // refresh the gallery to show the new image if it exists
                MediaScannerConnection.scanFile(
                        ActivityPaint.this, new String[]{fileName}, null, null);
                Toast.makeText(ActivityPaint.this, "The image was saved successfully.", Toast.LENGTH_SHORT).show();
            } else
            {
                Toast.makeText(ActivityPaint.this, "There was an error saving the image.", Toast.LENGTH_SHORT).show();
            }
        } else if (canvasExporter.getExportType() == CanvasExporter.FLAG_SHARE)
        {
            // handle the sharing
            shareImage();
        }
    }


    private void shareImage()
    {
        // create a new intent to a sharing activity.
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // get the image as a file
        File image = canvasExporter.getImage(canvasView.getBitmap());

        if (image != null)
        {
            // retrieve the uri of the created file
            Uri uri = FileProvider.getUriForFile(
                    ActivityPaint.this,
                    ActivityPaint.this.getApplicationContext().getPackageName() +
                            ".provider", canvasExporter.getImage(canvasView.getBitmap()));
            // pass the uri to the intent, to allow for sharing
            intent.putExtra(Intent.EXTRA_STREAM, uri).setType("image/png");
            // start the intent
            startActivity(Intent.createChooser(intent, "Share image via"));
        } else
        {
            Toast.makeText(ActivityPaint.this, "There was an error sharing the image.", Toast.LENGTH_SHORT).show();
        }
    }
}