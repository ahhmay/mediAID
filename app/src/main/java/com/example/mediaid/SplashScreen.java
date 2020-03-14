package com.example.mediaid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME=3850;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

       //lottieAnimationView=(LottieAnimationView)findViewById(R.id.lottieAnimationView);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent i=new Intent(SplashScreen.this,navigation_drawer.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME);
    }

//    private void startCheckAnimation(){
//        ValueAnimator animator=ValueAnimator.ofFloat(0f,1f).setDuration(800);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                lottieAnimationView.setProgress((Float)animation.getAnimatedValue());
//            }
//        });
//        animator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//        });
//        if(lottieAnimationView.getProgress()==0f){
//            animator.setStartDelay(1500);
//            animator.setDuration(3500);
//            animator.start();
//        } else{
//            lottieAnimationView.setProgress(0f);
//        }
//    }
}