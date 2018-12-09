package ar.edu.unlp.info.cedica.razasypelajescedica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Context;

import ar.edu.unlp.info.cedica.razasypelajescedica.game.InteractionModeC;
import ar.edu.unlp.info.cedica.razasypelajescedica.game.InteractionModeB;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private ArrayList<Class<? extends AppCompatActivity>> interactionModes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interactionModes =
                new ArrayList<Class<? extends  AppCompatActivity>>();

        interactionModes.add(InteractionModeB.class);
        interactionModes.add(InteractionModeB.class);
        interactionModes.add(InteractionModeC.class);

        setContentView(R.layout.activity_main);
    }

    public void onPlayButtonClick() {
        SharedPreferences preferences = getSharedPreferences("config_preferences", Context.MODE_PRIVATE);
        Intent intent = new Intent(this, interactionModes.get(0));

        Integer selectedInteractionMode = preferences.getInt("interactionMode", R.id.InteractionModeB);

        startActivity(intent);
    }

    protected void toConfig(View view) {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

}
