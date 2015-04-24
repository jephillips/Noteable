package com.example.josh.noteable.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josh.noteable.R;
import com.example.josh.noteable.activities.NoteHomeActivity;
import com.example.josh.noteable.domain.Item;
import com.example.josh.noteable.interfaces.EnterNoteListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by josh on 4/21/15.
 */
public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.MyViewHolder> {

    LayoutInflater inflater;
    Item currentItem;
    List<Item> itemList = Collections.emptyList();
    Context context;

    public NoteRecyclerAdapter(Context context, Item currentItem) {
        inflater = LayoutInflater.from(context);
        this.itemList = currentItem.getItemArrayList();
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
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text_view);
            description = (TextView) itemView.findViewById(R.id.description_text_view);

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
}