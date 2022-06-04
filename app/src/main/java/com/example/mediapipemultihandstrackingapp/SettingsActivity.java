package com.example.mediapipemultihandstrackingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    TextView textViewFontSize;
    public Button aboutUsButton;
    public Button customizeTextButton;
    public Button saveSettings;
    String fontSizeString;

    SharedPreferences sp;

    public static final String EXTRA_TEXT = "com.example.mediapipemultihandstrackingapp.EXTRA_TEXT";
    public static final String EXTRA_NUMBER_FONT_SIZE = "com.example.mediapipemultihandstrackingapp.EXTRA_NUMBER_FONT_SIZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        textViewFontSize = findViewById(R.id.textExample);

        String[] fontSizes = new String[] {
                "16", "18", "20", "24", "30", "36", "42"
        };
        Spinner fontSizeSpinner = (Spinner) findViewById(R.id.fontSizeSpinner);
        ArrayAdapter<String> fontSizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, fontSizes);
        fontSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fontSizeSpinner.setAdapter(fontSizeAdapter);


//        fontSizeSpinner.setSelection(fontSizeAdapter.getPosition("300"));
        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("MyUserPref2",Context.MODE_PRIVATE);
        String fontSizeSp = sp2.getString("fontSizeDef","");

        fontSizeSpinner.setSelection(fontSizeAdapter.getPosition(fontSizeSp));
//
//        textViewFontSize.setText(fontSizeSp);
//        fontSizeSpinner.setSelection(fontSizeAdapter.getPosition(fontSizeSp));

//        Integer defaultFontSize = 16;
//        try {
//            defaultFontSize = Integer.parseInt(fontSizeSpinner.getSelectedItem().toString());
//            fontSizeSpinner.setSelection(defaultFontSize);
//        }catch(Exception e){
//
//        }


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



//                Intent intentTextSize = new Intent(SettingsActivity.this, MainActivity.class);
//                String fontSizeString = fontSizeSpinner.getSelectedItem().toString();
//                textViewFontSize.setText(fontSizeString);
//                intentTextSize.putExtra(EXTRA_NUMBER_FONT_SIZE,fontSizeString);

        fontSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Intent intentTextSize = new Intent(SettingsActivity.this, MainActivity.class);
//                String fontSizeString = fontSizeSpinner.getSelectedItem().toString();
//                textViewFontSize.setTextSize(Integer.valueOf(fontSizeString));
//                intentTextSize.putExtra(EXTRA_NUMBER_FONT_SIZE,fontSizeString);
                fontSizeString = fontSizeSpinner.getSelectedItem().toString();
                textViewFontSize.setTextSize(Integer.parseInt(fontSizeString));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                textViewFontSize.setTextSize(20);

            }
        });

        fontFamilySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fontStyle = fontFamilySpinner.getSelectedItem().toString();
                textViewFontSize.setFontFeatureSettings(fontStyle);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp = getSharedPreferences("MyUserPref", Context.MODE_PRIVATE);
        saveSettings = findViewById(R.id.save_settings);
//        sends to main
        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("fontSize",fontSizeString);


                editor.commit();
                editor.apply();

                Toast.makeText(SettingsActivity.this,"Settings were saved",Toast.LENGTH_SHORT).show();
            }
        });




//        gets from main
//        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPref",Context.MODE_PRIVATE);
//        String fontSizeSp = sp.getString("fontSize","");
        // showing the back button in action bar


//        textBarSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


        aboutUsButton = (Button) findViewById(R.id.aboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, AboutUsActivity.class);
//                intent.putExtra(EXTRA_NUMBER_FONT_SIZE,);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);

        textViewFontSize.setTextSize(Integer.parseInt(fontSizeString));
        intent.putExtra(EXTRA_NUMBER_FONT_SIZE,fontSizeString);
        startActivity(intent);
    }
}