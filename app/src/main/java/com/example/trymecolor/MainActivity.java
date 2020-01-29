package com.example.trymecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View windowView;
    private Button tryMeButton;
    private int []colors;

    //Added sound to on click.

    private SoundPool sp;
    private int sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1 = sp.load(getApplicationContext(),R.raw.sound1,1);

        colors = new int[] {Color.CYAN, Color.BLACK, Color.BLUE, Color.WHITE, Color.DKGRAY, Color.LTGRAY};

        windowView = findViewById(R.id.windowViewId);


        tryMeButton = findViewById(R.id.button);
        tryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.d("Test", "Tap");

                int colorArrayLength = colors.length;
                Random random = new Random ();
                int randomNum = random.nextInt(colorArrayLength);

                windowView.setBackgroundColor(colors[randomNum]);
            }
        });

    }
}
