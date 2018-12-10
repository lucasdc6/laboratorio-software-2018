package ar.edu.unlp.info.cedica.razasypelajescedica.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ar.edu.unlp.info.cedica.razasypelajescedica.Main;
import ar.edu.unlp.info.cedica.razasypelajescedica.R;
import ar.edu.unlp.info.cedica.razasypelajescedica.internal.Horse;


public class RacesCoats extends AppCompatActivity {
    private List<Horse> horses = Arrays.asList(
            new Horse(R.drawable.horse1, "raza1", "pelaje1"),
            new Horse(R.drawable.horse2, "raza2", "pelaje2"),
            new Horse(R.drawable.horse3, "raza3", "pelaje3"),
            new Horse(R.drawable.horse4, "raza4", "pelaje4")
    );

    private Map<String, MediaPlayer> sounds;
    private ArrayList<ImageView> horsesView;
    private TextView questionComponent;
    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int answer;
        Random rand;

        setContentView(R.layout.activity_interaction_mode_b);

        sounds = new HashMap<>();
        horsesView = new ArrayList<>();

        sounds.put("horse", MediaPlayer.create(this, R.raw.horse_sound));
        sounds.put("error", MediaPlayer.create(this, R.raw.error_sound));
        sounds.put("success", MediaPlayer.create(this, R.raw.success_sound));

        horsesView.add((ImageView) findViewById(R.id.Horse1));
        horsesView.add((ImageView) findViewById(R.id.Horse2));
        horsesView.add((ImageView) findViewById(R.id.Horse3));
        horsesView.add((ImageView) findViewById(R.id.Horse4));

        questionComponent = findViewById(R.id.RaceText);

        Collections.shuffle(horses);

        for (int i = 0; i < horsesView.size(); i++) {
            horsesView.get(i).setImageResource(horses.get(i).getImgeId());
        }

        rand = new Random();
        answer = rand.nextInt(horsesView.size());

        Horse horse = horses.get(answer);

        questionComponent.setText(horse.getRace() + "/" + horse.getCoats());
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
        if (view.getId() == correctAnswer) {
            playSuccess();
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goSuccess();
                }
            }, getSoundDuration("success"));
            return;
        }

        playError();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void goSuccess() {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}