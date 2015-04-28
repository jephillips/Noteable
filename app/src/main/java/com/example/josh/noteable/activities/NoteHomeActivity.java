package com.example.josh.noteable.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.josh.noteable.R;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.fragments.NoteFragment;
import com.example.josh.noteable.fragments.CreateNoteDialogFragment;

import com.example.josh.noteable.interfaces.AddNoteListener;
import com.example.josh.noteable.interfaces.EnterNoteListener;
import com.example.josh.noteable.mockers.MockDataManager;
import com.example.josh.noteable.mockers.MockServerFetchEvent;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;


public class NoteHomeActivity extends AppCompatActivity implements
        AddNoteListener, EnterNoteListener {


    @InjectView(R.id.app_bar)
    Toolbar toolbar;

    private FragmentManager manager;
    private Integer backstackCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_home);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        NoteFragment fragment = new NoteFragment();
        transaction.add
                (R.id.note_activity_fragment_container, fragment, "NoteFragment" + backstackCounter)
                .addToBackStack("NoteFragment" + backstackCounter).commit();
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_home, menu);
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "No Settings Yet, SORRY!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.add_note) {
            showNoticeDialog(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showNoticeDialog(MenuItem menuItem) {
        CreateNoteDialogFragment dialog = new CreateNoteDialogFragment();
        dialog.show(getSupportFragmentManager(), "CreateNoteDialogFragment");
    }

    @Override
    public void onNoteAdded(Item newItem) {
        NoteFragment noteFragment = (NoteFragment)getSupportFragmentManager()
                .findFragmentByTag("NoteFragment"+ backstackCounter);
        noteFragment.addNote(newItem);
        Toast.makeText(this, "Note Added!", Toast.LENGTH_SHORT).show();

    }

    public void onEnterNote(Item enteredItem) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("EnteredItem", enteredItem);
        NoteFragment newNoteFrag = NoteFragment.newInstance(bundle);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.note_activity_fragment_container, newNoteFrag, "NoteFragment" + backstackCounter)
            .addToBackStack("NoteFragment" + backstackCounter).commit();
    }



}
