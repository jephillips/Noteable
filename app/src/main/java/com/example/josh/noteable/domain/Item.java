package com.example.josh.noteable.domain;

/**
 * Created by josh on 4/21/15.
 */
import java.util.ArrayList;

/**
 * Created by josh on 4/21/15.
 */
public class Item {


    private String title;
    private String description;
    private ArrayList<Item> itemArrayList;

    public Item(String title, String description){
        this.title = title;
        this.description = description;
        itemArrayList = new ArrayList<>();
    }

    public void editDescription(String description) {
        this.description = description;
    }

    public void editTitle(String title) {
        this.title = title;
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void addItem(Item item) {
        itemArrayList.add(item);
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
