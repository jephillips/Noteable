package com.example.josh.noteable.fragments;

/**
 * Created by josh on 4/21/15.
 */
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.adapters.NoteRecyclerAdapter;
import com.example.josh.noteable.R;
import com.example.josh.noteable.interfaces.AddNoteListener;
import com.example.josh.noteable.mockers.MockDataManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeNoteFragment extends Fragment {

    private AddNoteListener addNoteDialogListener;
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private NoteRecyclerAdapter adapter;
    private Item currentItem;


    @InjectView(R.id.parent_note_title)
    TextView parentTitle;
    @InjectView(R.id.parent_note_description)
    TextView parentDescription;

    // TODO: Rename and change types and number of parameters
    public static HomeNoteFragment newInstance(Bundle savedInstanceState) {

        return new HomeNoteFragment();
    }

    public HomeNoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home_note, container, false);
        ButterKnife.inject(this, layout);

        recyclerView = (RecyclerView) layout.findViewById(R.id.note_recycler_view);
        currentItem = MockDataManager.makeMockItem();
        parentTitle.setText(currentItem.getTitle());
        parentDescription.setText(currentItem.getDescription());

        adapter = new NoteRecyclerAdapter(getActivity(), currentItem);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        addNoteDialogListener = (AddNoteListener) activity;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void addNote(Item newItem){
        currentItem.addItem(newItem);

    }

    public void enterNote(Item enteredItem) {
        enteredItem.addItem(new Item("Test", "This is a test"));
        adapter = new NoteRecyclerAdapter(getActivity(), enteredItem);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        parentTitle.setText(enteredItem.getTitle());
        parentDescription.setText(enteredItem.getDescription());
    }




}
