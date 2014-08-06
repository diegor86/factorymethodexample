package com.despegar.factorymethodexample.factory;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.despegar.factorymethodexample.R;

/**
 * Created by diego on 05/08/14.
 */
public class RotateButtonButtonFactory extends AnimatedButtonFactory {

    @Override
    public Button buildAnimatedButton(final Context context) {
        Button button = new Button(context);
        button.setText(context.getString(R.string.pressMe));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
                view.startAnimation(animation);
            }
        });

        return button;
    }

}
