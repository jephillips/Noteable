package com.example.josh.noteable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by josh on 4/21/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    LayoutInflater inflater;
    List<Item> itemList = Collections.emptyList();
    Context context;

    public MyAdapter(Context context, Item currentItem) {
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
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        Item currentItem = itemList.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
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
}