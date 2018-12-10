package ar.edu.unlp.info.cedica.razasypelajescedica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Context;

import ar.edu.unlp.info.cedica.razasypelajescedica.game.Crosses;
import ar.edu.unlp.info.cedica.razasypelajescedica.game.RacesCoats;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private ArrayList<Class<? extends AppCompatActivity>> gameModes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameModes =
                new ArrayList<Class<? extends  AppCompatActivity>>();

        gameModes.add(RacesCoats.class);
        gameModes.add(RacesCoats.class);
        gameModes.add(Crosses.class);

        setContentView(R.layout.activity_main);
    }

    public void onPlayButtonClick(View view) {
        SharedPreferences preferences = getSharedPreferences("config_preferences", Context.MODE_PRIVATE);
        Intent intent = new Intent(this, gameModes.get(2));

        Integer selectedInteractionMode = preferences.getInt("gameModes", R.id.CrossesCheckbox);

        if (selectedInteractionMode != null) {
            intent = new Intent(this, gameModes.get(selectedInteractionMode - 1));
        }

        startActivity(intent);
    }

    protected void toConfig(View view) {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

    protected void toHelp(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}
