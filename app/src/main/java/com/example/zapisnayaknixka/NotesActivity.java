package com.example.zapisnayaknixka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NotesActivity extends AppCompatActivity {

    private Button mBtnSaveNote;
    private static String NOTE_TEXT = "note_text";
    private EditText mInputNote;
    private SharedPreferences myNoteSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.attr.layout.activity_notes);
        initViews();
        getDateFromSharedPref();
    }

    @SuppressLint("CutPasteId")
    private <NotesActivity1> void initViews() {
        mInputNote = findViewById(android.R.attr.id.inputNote);
        Button mBtnSaveNote;
        mBtnSaveNote = findViewById(android.R.attr.id.btnSaveNote);

        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(NotesActivity.this, getString(R.txtToastSave), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getDateFromSharedPref() {
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }
}