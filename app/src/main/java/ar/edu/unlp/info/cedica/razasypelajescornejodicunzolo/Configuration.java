package ar.edu.unlp.info.cedica.razasypelajescornejodicunzolo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.view.View;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Configuration extends AppCompatActivity
{

    private Switch levelSwitch;
    private Switch sexSwitch;
    private RadioGroup minigameRadio;
    private RadioGroup interactionModeRadio;
    private RadioGroup viewModeRadio;
    private HashMap<String, CheckBox> gameModeCheckBoxMap;
    private  SharedPreferences preferences;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize variables
        gameModeCheckBoxMap = new HashMap<>();

        preferences = getSharedPreferences("config_preferences", Context.MODE_PRIVATE);

         setContentView(R.layout.activity_configuration);

        // Initialize configurations
        initConfig();
     }

     public void onAccept(View view) {
         HashSet<String> selectedGameModes = new HashSet<>();

         SharedPreferences.Editor editor = preferences.edit();

         editor.putBoolean("level", levelSwitch.isChecked());
         editor.putBoolean("sex", sexSwitch.isChecked());

         editor.putInt("miniGame", minigameRadio.getCheckedRadioButtonId());
         editor.putInt("viewMode", viewModeRadio.getCheckedRadioButtonId());
         editor.putInt("interactionMode", interactionModeRadio.getCheckedRadioButtonId());

         for (Map.Entry<String, CheckBox> entry : gameModeCheckBoxMap.entrySet()) {
             if (entry.getValue().isChecked()) {
                 selectedGameModes.add(entry.getKey());
             }

         }

         editor.putStringSet("gameModes", selectedGameModes);
         editor.apply();
         finish();
     }

     private void initConfig() {
         levelSwitch = findViewById(R.id.Level);
         sexSwitch = findViewById(R.id.Sex);
         minigameRadio = findViewById(R.id.Minigame);
         interactionModeRadio = findViewById(R.id.InteractionMode);
         viewModeRadio = findViewById(R.id.ViewMode);

         gameModeCheckBoxMap.put("Races", (CheckBox) findViewById(R.id.RacesCheckbox));
         gameModeCheckBoxMap.put("Coats", (CheckBox) findViewById(R.id.CoatsCheckbox));
         gameModeCheckBoxMap.put("Crosses", (CheckBox) findViewById(R.id.CrossesCheckbox));

         levelSwitch.setChecked(preferences.getBoolean("level", true));
         sexSwitch.setChecked(preferences.getBoolean("sex", false));
         minigameRadio.check(preferences.getInt("miniGame", R.id.MinigameRacesCoats));
         viewModeRadio.check(preferences.getInt("viewMode", R.id.RecognizeModeList));
         interactionModeRadio.check(preferences.getInt("interactionMode", R.id.InteractionModeB));

         for (CheckBox checkBox : gameModeCheckBoxMap.values()) {
             checkBox.setChecked(false);
         }

         Set<String> gameModes = preferences.getStringSet("gameModes", new HashSet<String>());

        if (gameModes == null) {
            return;
        }

        for (String checkBoxKey : gameModes) {
            CheckBox checkBox = gameModeCheckBoxMap.get(checkBoxKey);
            if (checkBox != null) {
                checkBox.setChecked(true);
            }
        }

        findViewById(R.id.InteractionModeA).setEnabled(false);
     }
}
