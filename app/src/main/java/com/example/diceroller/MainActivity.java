package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random random = new Random();
    ImageView image_dice_1;
    ImageView image_dice_2;
    Button button_Roll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_dice_1 = findViewById(R.id.dice_1);
        image_dice_2 = findViewById(R.id.dice_2);
        button_Roll = findViewById(R.id.button2);
        button_Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anim1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                final Animation anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int value = randomDiceValue();
                        int res = getResources().getIdentifier("dice_" + value, "drawable", "com.example.diceroller");

                        if (animation == anim1) {
                            image_dice_1.setImageResource(res);
                        } else if (animation == anim2) {
                            image_dice_2.setImageResource(res);
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };

                anim1.setAnimationListener(animationListener);
                anim2.setAnimationListener(animationListener);

                image_dice_1.startAnimation(anim1);
                image_dice_2.startAnimation(anim2);
            }
        });
    }

    public static int randomDiceValue() {
        return random.nextInt(6) + 1;
    }


}