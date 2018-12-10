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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onPlayButtonClick(View view) {
        SharedPreferences preferences = getSharedPreferences("config_preferences", Context.MODE_PRIVATE);
        Intent intent;

        Integer selectedInteractionMode = preferences.getInt("miniGame", R.id.MinigameRacesCoats);

        switch (selectedInteractionMode) {
            case R.id.MinigameRacesCoats:
            case R.id.MinigameRacesAndCoats:
                intent = new Intent(this, RacesCoats.class);
                break;
            case R.id.MinigameCrosses:
                intent = new Intent(this, Crosses.class);
                break;
            default:
                intent = new Intent(this, Crosses.class);
                break;
        }

        startActivity(intent);
    }

    public void toConfig(View view) {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

    public void toHelp(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}
