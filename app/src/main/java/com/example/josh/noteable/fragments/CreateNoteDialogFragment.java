package com.example.josh.noteable.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class CreateNoteDialogFragment extends DialogFragment implements View.OnClickListener {

    @InjectView(R.id.create_note_title)
    EditText titleEditText;
    @InjectView(R.id.create_note_description)
    EditText descriptionEditText;

    NoticeDialogListener mListener;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.create_note_button) {

            Item newItem = new Item(titleEditText.getText().toString()
                    , descriptionEditText.getText().toString());

            mListener.onNoteAdded(this, newItem);
        }
    }


    public interface NoticeDialogListener {
        public void onNoteAdded(CreateNoteDialogFragment dialog, Item newItem);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);

    }

    public static CreateNoteDialogFragment newInstance(int title) {

        return null;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement NoticeDialogListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        setCancelable(false);
        View view= inflater.inflate(R.layout.add_note_fragment, null);
        ButterKnife.inject(this, view);
        return view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        AlertDialog alertDialog = dialogBuilder.create();

        return alertDialog;

    }


}