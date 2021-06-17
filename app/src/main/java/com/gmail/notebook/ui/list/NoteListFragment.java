package com.gmail.notebook.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import com.gmail.notebook.R;
import com.gmail.notebook.damain.Note;
import com.gmail.notebook.damain.NoteRepository;
import com.gmail.notebook.damain.NoteRepositoryImpl;

import java.util.List;

public class NoteListFragment extends Fragment {

    public interface OnNoteClicked{
        void onNoteClicked (Note note);
    }
    private NoteRepository noteRepository;
    private OnNoteClicked onNoteClicked;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNoteClicked){
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onNoteClicked = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteRepository = new NoteRepositoryImpl();
    }
    // предоставляем фрагменту вьюху


    @Nullable
        // создание View  (тут все верно)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
        // создание View  (тут все верно)
    }
    // вызов View
    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout noteList = view.findViewById(R.id.note_list_container);

        List<Note> notes = noteRepository.getNotes();

        // а как добавить description и date?

        for (Note note :notes) {
            View itemViewName = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList, false);
            TextView noteName = itemViewName.findViewById(R.id.note_name);
             noteName.setText(note.getName());

             itemViewName.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    if (onNoteClicked != null){
                        onNoteClicked.onNoteClicked(note);
                    }
                 }
             });

//            View itemViewDescription = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList, false);
//            TextView noteDescription = itemViewDescription.findViewById(R.id.note_name);
//            noteDescription.setText(note.getDescription());
//
//            View itemViewDate = LayoutInflater.from(requireContext()).inflate(R.layout.item_note, noteList, false);
//            TextView noteDate = itemViewDate.findViewById(R.id.note_name);
//            noteDate.setText(note.getDescription());

            noteList.addView(itemViewName);
            // а как добавить description и date?



        }





    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
