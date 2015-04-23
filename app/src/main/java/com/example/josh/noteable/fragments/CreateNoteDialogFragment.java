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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class CreateNoteDialogFragment extends DialogFragment implements View.OnClickListener {

    @InjectView(R.id.create_note_title)
    EditText titleEditText;
    @InjectView(R.id.create_note_description)
    EditText descriptionEditText;
    @InjectView(R.id.create_note_button)
    Button createButton;



    NoticeDialogListener mListener;

    @Override
    public void onClick(View view) {
        if (view.getId() == createButton.getId()) {

            Item newItem = new Item(titleEditText.getText().toString()
                    , descriptionEditText.getText().toString());
            System.out.print("Click click");
            mListener.onNoteAdded(this, newItem);

        }
    }

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


    public interface NoticeDialogListener {
        public void onNoteAdded(CreateNoteDialogFragment dialog, Item newItem);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //getActivity().requestWindowFeature(Window.FEATURE_ACTION_BAR);
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


    /*
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        AlertDialog alertDialog = dialogBuilder.create();

        return alertDialog;

    }
*/

}