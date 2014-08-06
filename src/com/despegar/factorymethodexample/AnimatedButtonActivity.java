package com.despegar.factorymethodexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.despegar.factorymethodexample.factory.AnimatedButtonFactory;
import com.despegar.factorymethodexample.factory.FadeOutButtonFactory;
import com.despegar.factorymethodexample.factory.RotateButtonButtonFactory;

public class AnimatedButtonActivity extends Activity {

    public static final String BUTTON_ANIMATION_EXTRA = "buttonAnimation";

    public static final int ROTATE_BUTTON = 0;
    public static final int FADE_OUT_BUTTON = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_button);
        if (savedInstanceState == null) {
        	Fragment fragment = new PlaceholderFragment();
        	fragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static AnimatedButtonFactory getCrazyButtonFactory(int factoryTheme) {
        switch (factoryTheme) {
            case ROTATE_BUTTON:
                return new RotateButtonButtonFactory();
            case FADE_OUT_BUTTON:
                return new FadeOutButtonFactory();
            default:
                return new AnimatedButtonFactory();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_animated_button, container, false);

            AnimatedButtonFactory buttonFactory = getCrazyButtonFactory(getArguments().getInt(BUTTON_ANIMATION_EXTRA));
            Button button = buttonFactory.buildAnimatedButton(getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            rootView.addView(button,layoutParams);

            return rootView;
        }
    }
}