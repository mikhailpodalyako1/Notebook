package com.gmail.notebook.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.gmail.notebook.R;
import com.gmail.notebook.damain.Note;
import com.gmail.notebook.ui.details.NoteDetailsActivity;
import com.gmail.notebook.ui.list.NoteListFragment;

public class MainActivity extends AppCompatActivity implements NoteListFragment.OnNoteClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteClicked(Note note) {
        Intent intent = new Intent(this, NoteDetailsActivity.class);
        intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
        startActivity(intent);
    }
    //реализация фрагмента

}