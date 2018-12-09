package ar.edu.unlp.info.cedica.razasypelajescedica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Context;

import ar.edu.unlp.info.cedica.razasypelajescedica.recognize.RacesCoatsRecognition;
import ar.edu.unlp.info.cedica.razasypelajescedica.recognize.RacesAndCoatsRecognition;
import ar.edu.unlp.info.cedica.razasypelajescedica.recognize.CrossesRecognition;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlayButtonClick() {
        SharedPreferences preferences = getSharedPreferences("config_preferences", Context.MODE_PRIVATE);
        Intent intent;

        ArrayList<Class<? extends AppCompatActivity>> recognitionModes =
            new ArrayList<Class<? extends  AppCompatActivity>>();

        recognitionModes.add(RacesCoatsRecognition.class);
        recognitionModes.add(RacesAndCoatsRecognition.class);
        recognitionModes.add(CrossesRecognition.class);
    }

    protected void toConfig(View view) {
        Intent intent = new Intent(this, Configuration.class);
        startActivity(intent);
    }

}
