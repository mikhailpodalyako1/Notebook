package com.gmail.notebook.ui.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.notebook.R;
import com.gmail.notebook.damain.Note;


public class NoteDetailsFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);

        fragment.setArguments(bundle);
        return fragment;
    }
    public NoteDetailsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView noteName= view.findViewById(R.id.note_name);
        TextView noteDescription= view.findViewById(R.id.note_description);
        TextView noteDate= view.findViewById(R.id.note_date);



        Note note = getArguments().getParcelable(ARG_NOTE);
        noteName.setText(note.getName());
        noteName.setText(note.getDescription());
        noteName.setText(note.getDate());



    }
}