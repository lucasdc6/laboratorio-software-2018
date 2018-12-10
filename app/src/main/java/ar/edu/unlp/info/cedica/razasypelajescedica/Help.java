package ar.edu.unlp.info.cedica.razasypelajescedica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_help);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
}
