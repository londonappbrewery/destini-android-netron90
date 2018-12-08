package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO: Constant declaration
    final String INDEX_STORY_STATE = "mIndexStrory";
    final String STORY_TEXT_VIEW = "story";
    final String TOP_BUTTON = "topButton";
    final String BOTTOM_BUTTON = "bottomButton";
    // TODO: Steps 4 & 8 - Declare member variables here:

    private TextView storyTextView;
    private Button buttonTop, buttonBottom;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop     = (Button) findViewById(R.id.buttonTop);
        buttonBottom  = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null)
        {
            if(savedInstanceState.getBoolean("Button_State") == true)
            {
                mStoryIndex = savedInstanceState.getInt(INDEX_STORY_STATE);
                storyTextView.setText(savedInstanceState.getString(STORY_TEXT_VIEW));
                buttonTop.setText(savedInstanceState.getString(TOP_BUTTON));
                buttonBottom.setText(savedInstanceState.getString(BOTTOM_BUTTON));
            }
            else
            {
                mStoryIndex = 1;
                storyTextView.setText(R.string.T1_Story);
                buttonTop.setText(R.string.T1_Ans1);
                buttonBottom.setText(R.string.T1_Ans2);
            }

        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyPathsTop(mStoryIndex);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                storyPathsBottom(mStoryIndex);
            }
        });

    }

    public void storyPathsBottom(int mStoryIndexx)
    {
        if(mStoryIndexx == 1)
        {
            storyTextView.setText(R.string.T2_Story);
            buttonBottom.setText(R.string.T2_Ans2);
            buttonTop.setText(R.string.T2_Ans1);
            mStoryIndex = 2;
        }
        else if(mStoryIndexx == 2)
        {
            storyTextView.setText(R.string.T4_End);
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }
//--- not necessary ----

//        else if(mStoryIndexx == 3)
//        {
//            storyTextView.setText(R.string.T5_End);
//            buttonTop.setVisibility(View.GONE);
//            buttonBottom.setVisibility(View.GONE);
//        }


// --- not necessary ----

        else
        {
            storyTextView.setText(R.string.T5_End);
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }

    }

    public void storyPathsTop(int mStoryIndexx)
    {
        if(mStoryIndexx == 1 || mStoryIndexx == 2)
        {
            storyTextView.setText(R.string.T3_Story);
            buttonTop.setText(R.string.T3_Ans1);
            buttonBottom.setText(R.string.T3_Ans2);
            mStoryIndex = 3;
        }
//        else if(mStoryIndexx == 2)
//        {
//            storyTextView.setText(R.string.T3_Story);
//            buttonTop.setText(R.string.T3_Ans1);
//            buttonBottom.setText(R.string.T3_Ans2);
//            mStoryIndex = 4;
//        }
        else if(mStoryIndexx >= 3)
        {
            storyTextView.setText(R.string.T6_End);
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }
//        else
//        {
//            storyTextView.setText(R.string.T6_End);
//            buttonTop.setVisibility(View.GONE);
//            buttonBottom.setVisibility(View.GONE);
//        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(buttonTop.getVisibility() != View.GONE && buttonBottom.getVisibility() != View.GONE)
        {
            Log.d("Alway", "Alway visible");

            outState.putInt   (INDEX_STORY_STATE, mStoryIndex);
            outState.putString(STORY_TEXT_VIEW, storyTextView.getText().toString());
            outState.putString(TOP_BUTTON, buttonTop.getText().toString());
            outState.putString(BOTTOM_BUTTON, buttonBottom.getText().toString());
            outState.putBoolean("Button_State", true);
        }
        else
        {
            outState.putBoolean("Button_State", false);
        }
    }
}
