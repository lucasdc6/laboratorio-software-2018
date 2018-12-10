package ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo.game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.Collections;

import ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo.Main;
import ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo.R;
import ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo.internal.Horse;

public class Crosses extends AppCompatActivity {
    private List<Horse> horses = Arrays.asList(
        new Horse(R.drawable.horse, "raza"),
        new Horse(R.drawable.horse1, "raza1"),
        new Horse(R.drawable.horse2, "raza2"),
        new Horse(R.drawable.horse3, "raza3"),
        new Horse(R.drawable.horse4, "raza4"),
        new Horse(R.drawable.horse5, "raza5")
    );

    private ArrayList<ImageView> horsesView;
    private Map<String, MediaPlayer> sounds;
    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random rand;
        int answer;

        setContentView(R.layout.activity_interaction_mode_c);

        sounds = new HashMap<>();
        horsesView = new ArrayList<>();

        sounds.put("horse", MediaPlayer.create(this, R.raw.horse_sound));
        sounds.put("error", MediaPlayer.create(this, R.raw.error_sound));
        sounds.put("success", MediaPlayer.create(this, R.raw.success_sound));

        horsesView.add((ImageView) findViewById(R.id.horse1));
        horsesView.add((ImageView) findViewById(R.id.horse2));
        horsesView.add((ImageView) findViewById(R.id.horse3));
        horsesView.add((ImageView) findViewById(R.id.horse4));

        horsesView.add((ImageView) findViewById(R.id.mainHorse1));
        horsesView.add((ImageView) findViewById(R.id.mainHorse2));

        Collections.shuffle(horses);

        for (Integer i = 0; i < horses.size(); i++) {
            horsesView.get(i).setImageResource(horses.get(i).getImgeId());
            horses.get(i).setId(horsesView.get(i).getId());
        }

        rand = new Random();
        answer = rand.nextInt(horsesView.size()-2);

        correctAnswer = horsesView.get(answer).getId();
    }

    private void playSound(String str) {
        MediaPlayer sound = sounds.get(str);

        if (sound != null) {
            sound.start();
        }
    }

    private void stopAndReleaseSound(String str) {
        MediaPlayer sound = sounds.get(str);

        if (sound != null) {
            sound.stop();
            sound.release();
        }
    }

    public long getSoundDuration(String str) {
        MediaPlayer sound = sounds.get(str);

        if (sound == null) {
            return 0;
        }

        return sound.getDuration();
    }

    public void playHorse(View view) {
        playSound("horse");
    }

    public void playError() {
        stopAndReleaseSound("error");

        sounds.put("error", MediaPlayer.create(this, R.raw.error_sound));

        playSound("error");
    }

    public void playSuccess() {
        playSound("success");
    }

    public void onAnswerClick(View view) {
        Handler handler = new Handler();

        if (view.getId() == correctAnswer) {
            view.setBackgroundColor(Color.GREEN);
            playSuccess();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    navigateTo(Win.class);
                }
            }, getSoundDuration("success"));
            return;
        }

        view.setBackgroundColor(Color.RED);
        playError();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateTo(Lose.class);
            }
        }, getSoundDuration("error"));
    }

    public void goBack(View view) {
        navigateTo(Main.class);
    }

    public void navigateTo(Class<? extends AppCompatActivity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}