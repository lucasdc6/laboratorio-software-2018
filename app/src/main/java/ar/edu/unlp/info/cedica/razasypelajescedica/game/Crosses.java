package ar.edu.unlp.info.cedica.razasypelajescedica.game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Collections;

import ar.edu.unlp.info.cedica.razasypelajescedica.Main;
import ar.edu.unlp.info.cedica.razasypelajescedica.R;
import ar.edu.unlp.info.cedica.razasypelajescedica.internal.Crosse;
import ar.edu.unlp.info.cedica.razasypelajescedica.internal.Horse;

public class Crosses extends AppCompatActivity {
    private ArrayList<ImageView> horsesViews;
    private List<Horse> horses = Arrays.asList(
        new Horse(R.drawable.horse, "raza"),
        new Horse(R.drawable.horse1, "raza1"),
        new Horse(R.drawable.horse2, "raza2"),
        new Horse(R.drawable.horse3, "raza3"),
        new Horse(R.drawable.horse4, "raza4"),
        new Horse(R.drawable.horse5, "raza5")
    );

    private int correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        horsesViews = new ArrayList<>();
        setContentView(R.layout.activity_interaction_mode_c);

        horsesViews.add((ImageView) findViewById(R.id.horse1));
        horsesViews.add((ImageView) findViewById(R.id.horse2));
        horsesViews.add((ImageView) findViewById(R.id.horse3));
        horsesViews.add((ImageView) findViewById(R.id.horse4));

        horsesViews.add((ImageView) findViewById(R.id.mainHorse1));
        horsesViews.add((ImageView) findViewById(R.id.mainHorse2));

        Collections.shuffle(horses);

        for (Integer i = 0; i < horses.size(); i++) {
            horsesViews.get(i).setImageResource(horses.get(i).getImgeId());
            horses.get(i).setId(horsesViews.get(i).getId());
        }

        Random random = new Random();
        int answer = random.nextInt(horsesViews.size()-2);

        correctAnswer = horsesViews.get(answer).getId();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void goSuccess() {
        Intent intent = new Intent(this, Win.class);
        startActivity(intent);
    }

    public void goFailure() {
        Intent intent = new Intent(this, Lose.class);
        startActivity(intent);
    }

    public void onAnswerClick(View view) {
        view.setEnabled(false);
        if (view.getId() == correctAnswer) {
            view.setBackgroundColor(Color.GREEN);
            goSuccess();
        } else {
            view.setBackgroundColor(Color.RED);
            goFailure();
        }
    }
}