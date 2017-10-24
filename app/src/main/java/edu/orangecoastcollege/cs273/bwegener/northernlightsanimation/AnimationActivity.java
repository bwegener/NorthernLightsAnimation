package edu.orangecoastcollege.cs273.bwegener.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * The <code>AnimationActivity</code> displays the image
 * and buttons that change the image.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 10/23/2017
 */
public class AnimationActivity extends AppCompatActivity {

    // AnimationDrawable = used for frame animations
    private AnimationDrawable frameAnim;

    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;


    /**
     * This starts the app and opens the layout
     * as well as displays the image.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * This starts a frame animation, that works
     * similarly to a gif.
     * @param view
     */
    public void toggleFrameAnim(View view) {
        // hasn't been initialized yet
        if (frameAnim == null) {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // if frameAnim is running, stop it
        if (frameAnim.isRunning())
            frameAnim.stop();
            // else, start it
        else
            frameAnim.start();

    }

    /**
     * This rotates the animation by spinning it clockwise.
     * @param view
     */
    public void toggleRotateAnim(View view) {
        if (rotateAnim == null) {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

            // Connect it to the image view
            lightsImageView.startAnimation(rotateAnim);
        } else if (rotateAnim.hasStarted())
            lightsImageView.clearAnimation();

        rotateAnim = null;
    }

    /**
     * This shakes the image left to right.
     * @param view
     */
    public void toggleShakeAnim(View view) {

        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);

    }

    /**
     * Toggles my custom animation which smushes the image (scale)
     * and then makes it opaque (alpha)
     * @param view
     */
    public void toggleCustomAnim(View view) {
        if(customAnim == null)customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        if(!customAnim.hasStarted() || customAnim.hasEnded())
            lightsImageView.startAnimation(customAnim);
        else
            lightsImageView.clearAnimation();
    }


}
