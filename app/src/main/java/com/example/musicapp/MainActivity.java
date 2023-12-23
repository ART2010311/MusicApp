package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_AUDIO_REQUEST_CODE=1;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private TextView tvSongName;
    private Uri selectedAudioUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView btnPlay= findViewById(R.id.play);
        ImageView btnPause= findViewById(R.id.pause);
        ImageView btnstop= findViewById(R.id.stop);
        Button btnChooseFile= findViewById(R.id.openfile);
        seekBar=findViewById(R.id.seekBar);
        tvSongName=findViewById(R.id.songname);
        mediaPlayer=new MediaPlayer();
        btnChooseFile.setOnClickListener(v -> chooseAudioLauncher.launch("audio/*"));
        btnPlay.setOnClickListener(v->{
            if(selectedAudioUri !=null){
                try{
                    mediaPlayer.setDataSource(getApplicationContext(),selectedAudioUri);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this,"playing audio",Toast.LENGTH_LONG).show();

                } catch (IOException e) {
                    e.printStackTrace();

                    Toast.makeText(MainActivity.this,"Error in  playing audio",Toast.LENGTH_LONG).show();

                }
            }else{
                Toast.makeText(MainActivity.this,"please chooose an audio file",Toast.LENGTH_LONG).show();
            }

        });
    }
}