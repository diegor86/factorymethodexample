package com.despegar.factorymethodexample.factory;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.despegar.factorymethodexample.R;

/**
 * Created by diego on 05/08/14.
 */
public class AnimatedButtonFactory {

    public Button buildAnimatedButton(Context context)
    {
        return buildBoringButton(context);
    }

    private Button buildBoringButton(final Context context) {
            Button button = new Button(context);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, context.getString(R.string.nothing), Toast.LENGTH_LONG).show();
                }
            });

            return button;
    }

}
