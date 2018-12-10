package ar.edu.unlp.info.cedica.razasypelajescedica.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ar.edu.unlp.info.cedica.razasypelajescedica.Main;
import ar.edu.unlp.info.cedica.razasypelajescedica.R;

public class Win extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
