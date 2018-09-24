package com.clrzr.googlealc.musicapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PlayerActivity extends AppCompatActivity {

    private Integer repeatChecker = 2;
    private Integer shuffleChecker = 2;
    private Integer playChecker = 2;
    private int repeatIconChanger = 0;
    private int shuffleIconChanger = 0;
    private int playIconChanger = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    private void changeIcon(Drawable img, View statusID) {
        ImageView iconChanger = (ImageView) statusID;
        iconChanger.setImageDrawable(img);
    }
    public void repeat (View view){
        repeatChecker++;
        if (repeatChecker < 4)
            repeatIconChanger = R.drawable.ic_repeat_on;
                if (repeatChecker > 3)
                    repeatIconChanger = R.drawable.ic_repeat_one;
        changeIcon(getDrawable(repeatIconChanger), findViewById(R.id.repeat_button));
        }

    public void shuffle (View view){
        shuffleChecker++;
        if (shuffleChecker < 4)
            shuffleIconChanger = R.drawable.ic_shuffle_on;
                if (shuffleIconChanger > 3)
                    shuffleChecker = 2;
                    shuffleIconChanger = R.drawable.ic_shuffle;
        changeIcon(getDrawable(shuffleIconChanger), findViewById(R.id.shuffle_button));
    }

    public void changePlayButton (View view){
        playChecker++;
        if (playChecker < 4)
            playIconChanger = R.drawable.ic_pause;
            if (playChecker > 3)
                playChecker = 2;
                playIconChanger = R.drawable.ic_play;
        changeIcon(getDrawable(playIconChanger), findViewById(R.id.play_button));
    }
}