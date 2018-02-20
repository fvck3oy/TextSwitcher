/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.textswitcher;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;


import java.util.Random;

public class MainActivity extends Activity {
    private TextSwitcher mSwitcher;
    private int mCounter = 0,nCounter = 0;
    private TextView tv2;
    ImageView imageView,imageView2;

    Integer[] images = {
            R.drawable.list1,
            R.drawable.list2,
            R.drawable.list3,
            R.drawable.list4,
            R.drawable.list5,
            R.drawable.list6,
            R.drawable.list7,
            R.drawable.list8
    };

    Integer[] images2 = {
            R.drawable.aong,
            R.drawable.arm,
            R.drawable.ball,
            R.drawable.benz,
            R.drawable.dump,
            R.drawable.man,
            R.drawable.tan,
            R.drawable.sket

    };
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        mSwitcher = findViewById(R.id.switcher);
        mSwitcher.setFactory(mFactory);

        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        // END_INCLUDE(setup)

        imageView = (ImageView)findViewById (R.id.imageView);
        imageView2 = (ImageView)findViewById (R.id.imageView2);
        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imageView.setImageResource (images[r.nextInt(images.length)]);
                imageView2.setImageResource (images2[r.nextInt(images2.length)]);
                //Random r = new Random();

//close
//                int randomNumber = r.nextInt(10);
//                //reference the textview widget
//                TextView tv = (TextView) findViewById(R.id.tv);
//
//                //display the random number to textview
//                if (randomNumber == 1){
//                    tv.setText(String.valueOf(randomNumber+"ไอบอย"));
//                }
//
//                else if (randomNumber == 2){
//                    tv.setText(String.valueOf(randomNumber+"ไอบอย2"));
//                }
//                else {
//                    tv.setText (String.valueOf (randomNumber)); }

                mCounter++;
                mSwitcher.setText("รอบที่ "+String.valueOf(mCounter));

            }
        });

        // Set the initial text without an animation
        mSwitcher.setCurrentText(String.valueOf(mCounter));


    }

    private ViewFactory mFactory = new ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
//    public void random(View view) {
//
//        Random r = new Random();
//        int randomNumber = r.nextInt(10);
//
//        //reference the textview widget
//        TextView tv = (TextView) findViewById(R.id.tv);
//
//        //display the random number to textview
//        if (randomNumber == 1){
//            tv.setText(String.valueOf(randomNumber+"ไอบอย"));
//        }
//
//        else if (randomNumber == 2){
//            tv.setText(String.valueOf(randomNumber+"ไอบอย2"));
//        }
//        else {
//            tv.setText (String.valueOf (randomNumber)); }
//    }

}
