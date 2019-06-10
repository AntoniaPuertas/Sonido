package com.example.sonido;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGanar;
    Button btnPerder;
    Button btnError;


    //creo un objeto de la clase mediaPlayer para cada sonido
    MediaPlayer mediaPlayerError;
    MediaPlayer mediaPlayerGanar;
    MediaPlayer mediaPlayerPerder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnError = findViewById(R.id.btnError);
        btnGanar = findViewById(R.id.btnGanar);
        btnPerder = findViewById(R.id.btnPerder);


        //preparo el sonido
        if (mediaPlayerError != null) {
            mediaPlayerError.release();
        }
        mediaPlayerError = MediaPlayer.create(this, R.raw.error);

        if (mediaPlayerGanar != null) {
            mediaPlayerGanar.release();
        }
        mediaPlayerGanar = MediaPlayer.create(this, R.raw.ganar);

        if (mediaPlayerPerder != null) {
            mediaPlayerPerder.release();
        }
        mediaPlayerPerder = MediaPlayer.create(this, R.raw.perder);

        btnPerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerPerder.seekTo(0);
                mediaPlayerPerder.start();
            }
        });

        btnGanar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerGanar.seekTo(0);
                mediaPlayerGanar.start();
            }
        });

        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerError.seekTo(0);
                mediaPlayerError.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayerError != null) {
            mediaPlayerError.release();
        }

        if (mediaPlayerGanar != null) {
            mediaPlayerGanar.release();
        }

        if (mediaPlayerPerder != null) {
            mediaPlayerPerder.release();
        }
    }
}
