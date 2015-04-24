package com.example.josh.noteable.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.fragments.HomeNoteFragment;
import com.example.josh.noteable.fragments.CreateNoteDialogFragment;

import com.example.josh.noteable.interfaces.AddNoteListener;
import com.example.josh.noteable.interfaces.EnterNoteListener;

import java.util.ArrayList;


public class NoteHomeActivity extends AppCompatActivity implements HomeNoteFragment.OnFragmentInteractionListener,
        AddNoteListener, EnterNoteListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Item> itemArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_home);

//        Fragment homeNoteFragment = new HomeNoteFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.note_activity_layout, homeNoteFragment, "HomeNoteFragment").commit();

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
            showNoticeDialog(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void showNoticeDialog(MenuItem menuItem) {
        CreateNoteDialogFragment dialog = new CreateNoteDialogFragment();
        dialog.show(getSupportFragmentManager(), "CreateNoteDialogFragment");
    }

    @Override
    public void onNoteAdded(Item newItem) {
        HomeNoteFragment noteFragment = (HomeNoteFragment)getSupportFragmentManager()
                .findFragmentById(R.id.home_note_fragment);
        noteFragment.addNote(newItem);
    }

    public void onEnterNote(Item enteredItem) {
        HomeNoteFragment noteFragment = (HomeNoteFragment)getSupportFragmentManager()
                .findFragmentById(R.id.home_note_fragment);
        noteFragment.enterNote(enteredItem);
    }
}
