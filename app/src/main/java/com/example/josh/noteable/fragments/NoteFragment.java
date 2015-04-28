package com.example.josh.noteable.fragments;

/**
 * Created by josh on 4/21/15.
 */
import android.app.Activity;
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

public class NoteFragment extends Fragment {

    private AddNoteListener addNoteDialogListener;
    private RecyclerView recyclerView;
    private NoteRecyclerAdapter adapter;
    private Item currentItem;


    @InjectView(R.id.parent_note_title)
    TextView headerTitle;
    @InjectView(R.id.parent_note_description)
    TextView headerDescription;

    public static NoteFragment newInstance(Bundle bundledArgs) {

        NoteFragment newFragment = new NoteFragment();
        Item newItem = (Item) bundledArgs.getSerializable("EnteredItem");
        newFragment.setCurrentItem(newItem);
        return newFragment;
    }

    public NoteFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home_note, container, false);
        ButterKnife.inject(this, layout);

        if (currentItem == null) {
            currentItem = MockDataManager.makeMockItem();
        }

        headerTitle.setText(currentItem.getTitle());
        headerDescription.setText(currentItem.getDescription());

        adapter = new NoteRecyclerAdapter(getActivity(), currentItem);
        recyclerView = (RecyclerView) layout.findViewById(R.id.note_recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            addNoteDialogListener = (AddNoteListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement AddNoteListener");
        }
    }

    public void addNote(Item newItem){
        newItem.setParent(currentItem);
        currentItem.addItem(newItem);

    }

//    public void enterNote(Item enteredItem) {
//        currentItem = enteredItem;
//        adapter = new NoteRecyclerAdapter(getActivity(), enteredItem);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        headerTitle.setText(enteredItem.getTitle());
//        headerDescription.setText(enteredItem.getDescription());
//    }
//
//    public void backToParent() {
//        Item grandParent = currentItem.getParent().getParent();
//        Item parent = currentItem.getParent();
//        parent.setParent(grandParent);
//        adapter = new NoteRecyclerAdapter(getActivity(), parent);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        headerTitle.setText(parent.getTitle());
//        headerDescription.setText(parent.getDescription());
//    }

    public void setCurrentItem(Item newItem) {
        currentItem = newItem;
    }




}
