package com.gmail.notebook.damain;

import com.gmail.notebook.R;

import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryImpl implements NoteRepository{
    // возвращаем список всех заметок
    @Override
    public List<Note> getNotes(){
        ArrayList<Note> result = new ArrayList<>();

        result.add(new Note(R.string.name, R.string.description, R.string.date));

        return result;
    }
}
