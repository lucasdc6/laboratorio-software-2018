package ar.edu.unlp.info.cedica.razasypelajescedica.game;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import ar.edu.unlp.info.cedica.razasypelajescedica.Main;
import ar.edu.unlp.info.cedica.razasypelajescedica.R;
import ar.edu.unlp.info.cedica.razasypelajescedica.internal.Horse;

public class Crosses extends AppCompatActivity {
    private ArrayList<ImageView> horsesViews;
    int answer;
    private List<Horse> horses = Arrays.asList(
            new Horse(R.drawable.horse, "raza", "pelaje"),
            new Horse(R.drawable.horse1, "raza1", "pelaje1"),
            new Horse(R.drawable.horse2, "raza2", "pelaje2"),
            new Horse(R.drawable.horse3, "raza3", "pelaje3"),
            new Horse(R.drawable.horse4, "raza4", "pelaje4")
    );

    private void initGame() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        horsesViews = new ArrayList<>();
        setContentView(R.layout.activity_interaction_mode_c);

        horsesViews.add((ImageView) findViewById(R.id.mainHorse));
        horsesViews.add((ImageView) findViewById(R.id.horse1));
        horsesViews.add((ImageView) findViewById(R.id.horse2));
        horsesViews.add((ImageView) findViewById(R.id.horse3));
        horsesViews.add((ImageView) findViewById(R.id.horse4));

        Collections.shuffle(horses);

        for (int i = 0; i < 5; i++) {
            horsesViews.get(i).setImageResource(horses.get(i).getImgeId());
        }

        initGame();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void onAnswerClick(View view) {
        view.setEnabled(false);
        view.setBackgroundColor(Color.RED);
    }
}