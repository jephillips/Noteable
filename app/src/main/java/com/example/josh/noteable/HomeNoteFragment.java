package com.example.josh.noteable;

/**
 * Created by josh on 4/21/15.
 */
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josh.noteable.MyAdapter;

public class HomeNoteFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

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

        recyclerView = (RecyclerView) layout.findViewById(R.id.note_recycler_view);


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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
