package com.example.brainybearapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.brainybearapp.ActivityTest;
import com.example.brainybearapp.Common.Common;

import java.util.List;


public class GridViewSuggestAdapter extends BaseAdapter {

    private List<String> suggestSource;
    private Context context;
    private ActivityTest activityTest;

    public GridViewSuggestAdapter(List<String> suggestSource, Context context, ActivityTest activityTest) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.activityTest = activityTest;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null)
        {
            if(suggestSource.get(position).equals("null"))
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.YELLOW);
            }
            else
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.BLUE);
                button.setTextColor(Color.YELLOW);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //If correct answer contains character user selected
                        if(String.valueOf(activityTest.answer).contains(suggestSource.get(position)))
                        {
                            char compare = suggestSource.get(position).charAt(0); // Get char

                            for(int i =0;i<activityTest.answer.length;i++)
                            {
                                if(compare == activityTest.answer[i])
                                    Common.user_submit_answer[i] = compare;
                            }

                            //Update UI
                            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(Common.user_submit_answer,context);
                            activityTest.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            //Remove from suggest source
                            activityTest.suggestSource.set(position,"null");
                            activityTest.suggestAdapter = new GridViewSuggestAdapter(activityTest.suggestSource,context,activityTest);
                            activityTest.gridViewSuggest.setAdapter(activityTest.suggestAdapter);
                            activityTest.suggestAdapter.notifyDataSetChanged();
                        }
                        else // else
                        {
                            //Remove from suggest source
                            activityTest.suggestSource.set(position,"null");
                            activityTest.suggestAdapter = new GridViewSuggestAdapter(activityTest.suggestSource,context,activityTest);
                            activityTest.gridViewSuggest.setAdapter(activityTest.suggestAdapter);
                            activityTest.suggestAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
        else
            button = (Button)convertView;
        return button;

    }
}