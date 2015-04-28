package com.example.josh.noteable.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.interfaces.AddNoteListener;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class CreateNoteDialogFragment extends DialogFragment{

    @InjectView(R.id.create_note_title)
    EditText titleEditText;
    @InjectView(R.id.create_note_description)
    EditText descriptionEditText;
    @InjectView(R.id.create_note_button)
    Button createButton;
    @InjectView(R.id.cancel_button)
    Button cancelButton;

    AddNoteListener addNoteListener;


    @Override
    public void onStart()
    {
        Log.i("CreateNoteDialogFrag", "onStart called");
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            Log.i("CreateNoteDialogFrag", "w:" + width + "|h:" + height);
            dialog.getWindow().setLayout(width, height);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static CreateNoteDialogFragment newInstance(int title) {

        return null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            addNoteListener = (AddNoteListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement AddNoteListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view= inflater.inflate(R.layout.add_note_fragment, container, false);
        ButterKnife.inject(this, view);
        titleEditText.setText("Test Note");
        descriptionEditText.setText("I'm tired of typing");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item newItem = new Item(titleEditText.getText().toString(),
                        descriptionEditText.getText().toString());
                addNoteListener.onNoteAdded(newItem);

                dismiss();
            }
        });
    }

    @OnClick(R.id.cancel_button)
    public void cancelDialog(){
        dismiss();
    }

}