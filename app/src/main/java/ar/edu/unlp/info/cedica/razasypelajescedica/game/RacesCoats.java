package ar.edu.unlp.info.cedica.razasypelajescedica.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ar.edu.unlp.info.cedica.razasypelajescedica.Main;
import ar.edu.unlp.info.cedica.razasypelajescedica.R;


public class RacesCoats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_interaction_mode_c);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    public void playSound(View view) {

    }

    public void onAnswerClick(View view) {

    }
}