package com.example.josh.noteable;

/**
 * Created by josh on 4/21/15.
 */
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josh.noteable.MyAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class HomeNoteFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_note_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_note) {

            return (true);
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_home_note, container, false);
        ButterKnife.inject(this, layout);

        recyclerView = (RecyclerView) layout.findViewById(R.id.note_recycler_view);
        Item item = MockDataManager.makeMockItem(MockDataManager.makeMockItemList());
        parentTitle.setText(item.getTitle());
        parentDescription.setText(item.getDescription());

        adapter = new MyAdapter(getActivity(), item);
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
