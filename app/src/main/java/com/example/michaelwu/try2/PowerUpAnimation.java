package com.example.michaelwu.try2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.ArrayList;

public class PowerUpAnimation extends AppCompatActivity {
    ImageView[] imageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_up_animation);
        wireWidgets();
        setInvisible();
        for(View myView: imageViews){
            runAnimation(myView);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 1000);   //5 seconds
    }

    private void runAnimation(final View myView) {
        // previously invisible view
        myView.post(new Runnable() {
            @Override
            public void run() {
                // Check if the runtime version is at least Lollipop
                if (Build.VERSION.SDK_INT >= 21) {
                    // get the center for the clipping circle
                    int cx = myView.getWidth() / 2;
                    int cy = myView.getHeight() / 2;

                    // get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

                    // create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

                    // make the view visible and start the animation
                    anim.setDuration(1000);
                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                } else {
                    // set the view to visible without a circular reveal animation below Lollipop
                    myView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setInvisible() {
        for(View view: imageViews){
            view.setVisibility(View.INVISIBLE);
        }
    }

    private void wireWidgets() {
        int[] IDs = {
                R.id.checkmark_icon,
                R.id.google_drive_icon,
                R.id.microsoft_office_icon,
                R.id.whats_app_icon,
                R.id.gmail_icon,
                R.id.facebook_icon,
                R.id.instagram_icon,
                R.id.dropbox_icon,
                R.id.onedrive_icon,
                R.id.wechat_icon
        };
        imageViews = new ImageView[IDs.length];
        for(int i = 0; i < IDs.length; i ++){
            imageViews[i] = findViewById(IDs[i]);
        }
    }
}
