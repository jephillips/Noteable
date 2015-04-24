package com.example.josh.noteable.interfaces;

import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.fragments.CreateNoteDialogFragment;

/**
 * Created by josh on 4/23/15.
 */
public interface AddNoteListener {

    public void onNoteAdded(Item newItem);
}
