package com.example.josh.noteable.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.josh.noteable.R;
import com.example.josh.noteable.activities.NoteHomeActivity;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.interfaces.DeleteNoteListener;
import com.example.josh.noteable.interfaces.EnterNoteListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by josh on 4/21/15.
 */
public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.MyViewHolder> {

    LayoutInflater inflater;
    Item parentItem;
    Item currentItem;
    List<Item> itemList = Collections.emptyList();
    Context context;

    public NoteRecyclerAdapter(Context context, Item parentItem) {
        inflater = LayoutInflater.from(context);
        this.parentItem = parentItem;
        this.itemList = parentItem.getItemArrayList();
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.my_card_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NoteRecyclerAdapter.MyViewHolder holder, int position) {
        currentItem = itemList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.itemView.setOnClickListener(new EnterNoteClickListener(position));
        holder.deleteButton.setOnClickListener(new DeleteNoteClickListener(position));

    }

    @Override
    public int getItemCount() {
        return parentItem.getItemArrayList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        ImageButton deleteButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text_view);
            description = (TextView) itemView.findViewById(R.id.description_text_view);
            deleteButton = (ImageButton) itemView.findViewById(R.id.card_delete_button);

        }
    }

    class EnterNoteClickListener implements View.OnClickListener {
        private int position;
        private EnterNoteListener enterNoteListener;

        public EnterNoteClickListener(int position) {
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            currentItem = itemList.get(position);
            enterNoteListener = (EnterNoteListener) context;
            enterNoteListener.onEnterNote(currentItem);
        }
    }

    class DeleteNoteClickListener implements View.OnClickListener {
        private int position;
        private DeleteNoteListener deleteNoteListener;

        public DeleteNoteClickListener(int position) { this.position = position; }
        @Override
        public void onClick(View v) {
            deleteNoteListener = (DeleteNoteListener) context;
            deleteNoteListener.onDeleteNote(position);
        }
    }
}