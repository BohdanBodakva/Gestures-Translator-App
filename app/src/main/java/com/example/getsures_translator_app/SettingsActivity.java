package com.example.getsures_translator_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    public Button aboutUsButton;
    public Button customizeTextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        String[] fontSizes = new String[] {
                "10", "12", "14", "16", "18", "24", "30"
        };
        Spinner fontSizeSpinner = (Spinner) findViewById(R.id.fontSizeSpinner);
        ArrayAdapter<String> fontSizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, fontSizes);
        fontSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(fontSizeAdapter);

        String[] textBarSizes = new String[]{
                "Big", "Medium", "Small"
        };
        Spinner textBarSizeSpinner = (Spinner) findViewById(R.id.textBarSizeSpinner);
        ArrayAdapter<String>textBarSizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,textBarSizes);
        textBarSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        textBarSizeSpinner.setAdapter(textBarSizeAdapter);

        String[] memorySizes = new String[]{
                "Big", "Medium", "Small"
        };
        Spinner memorySizeSpinner = (Spinner) findViewById(R.id.memorySizeSpinner);
        ArrayAdapter<String>memorySizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,memorySizes);
        memorySizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        memorySizeSpinner.setAdapter(memorySizeAdapter);

        String[] fontFamilies = new String[] {
                "Serif", "Sans-serif", "monospace", "cursive", "fantasy"
        };
        Spinner fontFamilySpinner = (Spinner) findViewById(R.id.fontFamilySpinner);
        ArrayAdapter<String> fontFamilyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, fontFamilies);
        fontFamilyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontFamilySpinner.setAdapter(fontFamilyAdapter);




        aboutUsButton = (Button) findViewById(R.id.aboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });






    }


}