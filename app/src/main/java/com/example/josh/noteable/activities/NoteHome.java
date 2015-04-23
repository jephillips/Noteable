package com.example.josh.noteable.activities;

import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.fragments.HomeNoteFragment;
import com.example.josh.noteable.fragments.CreateNoteDialogFragment;

import java.util.ArrayList;


public class NoteHome extends AppCompatActivity implements HomeNoteFragment.OnFragmentInteractionListener,
    CreateNoteDialogFragment.NoticeDialogListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Item> itemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_home);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_home, menu);
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        } else if (id == R.id.add_note) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onNoteAdded(CreateNoteDialogFragment dialog, Item newItem) {

    }


    public void showNoticeDialog(View view) {
        FragmentManager manager = getFragmentManager();
        CreateNoteDialogFragment dialog = new CreateNoteDialogFragment();
        dialog.show(getSupportFragmentManager(), "CreateNoteDialogFragment");
    }
}
