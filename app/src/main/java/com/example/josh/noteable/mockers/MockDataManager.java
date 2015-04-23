package com.example.josh.noteable.mockers;

import com.example.josh.noteable.domain.Item;

import java.util.ArrayList;

/**
 * Created by josh on 4/21/15.
 */
public class MockDataManager {

    public static ArrayList<Item> makeMockItemList() {

        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        arrayList.add(new Item("Eat chicken", "I should eat chicken"));
        arrayList.add(new Item("Go to work", "Don't want to get fired"));
        return arrayList;
    }

    public static Item makeMockItem(ArrayList<Item> itemArrayList) {

        Item item = new Item("Mock item", "This item contains items");

        for (Item currentItem : itemArrayList) {
            item.addItem(currentItem);
        }

        return item;
    }

}

