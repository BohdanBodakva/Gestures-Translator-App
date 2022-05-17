package com.example.gesturestranslator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class SettingsActivity extends AppCompatActivity {
    public Button aboutUsButton;
    public Button customizeTextButton;

    public Button toCameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Integer[] fontSizes = new Integer[]{
                10, 12, 14, 16, 18, 24, 30
        };
        Spinner fontSizeSpinner = (Spinner) findViewById(R.id.fontSizeSpinner);
        ArrayAdapter<Integer> fontSizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, fontSizes);
        fontSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(fontSizeAdapter);






        TextView textFontSize = findViewById(R.id.fontSize);

        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1: textFontSize.setTextSize(10); break;
                    case 2: textFontSize.setTextSize(12); break;
                    case 3: textFontSize.setTextSize(14); break;
                    case 4: textFontSize.setTextSize(18); break;
                    case 5: textFontSize.setTextSize(22); break;
                    case 6: textFontSize.setTextSize(28); break;
                    case 7: textFontSize.setTextSize(30); break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



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
                startActivity(new Intent(SettingsActivity.this, AboutUsActivity.class));
            }
        });


        toCameraButton = (Button)findViewById(R.id.to_camera_button);
        toCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, CameraActivity.class));
            }
        });


    }


}
