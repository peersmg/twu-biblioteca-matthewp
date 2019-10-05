package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemStorage {
    private HashMap<Integer, Item> availableItems = new HashMap<Integer, Item>();
    private HashMap<Integer, Item> checkedOutItems = new HashMap<Integer, Item>();

    public ItemStorage() {
    }

    public void addItem(Item newItem){
        if(newItem.getCheckedOut())
        {
            checkedOutItems.put(newItem.getId(), newItem);
        }
        else{
            availableItems.put(newItem.getId(), newItem);
        }

    }

    public List<Item> getAvailableItems() {
        return new ArrayList<Item>(availableItems.values());
    }

    public List<Item> getCheckedOutItems() {
        return new ArrayList<Item>(checkedOutItems.values());
    }

    public List<String> printAvailableItems()
    {
        List<String> itemList = new ArrayList<String>();
        for (Item item: availableItems.values()){
            itemList.add(item.getDetails());
        }
        return itemList;
    }

    public String printCheckedOutItems()
    {
        String itemList = "";
        for (Item item: checkedOutItems.values()){
            itemList += item.getDetails() + "\n";
        }
        return itemList;
    }


    public boolean checkoutItem(int id)
    {
        if(availableItems.containsKey(id)){
            checkedOutItems.put(id, availableItems.get(id));
            availableItems.remove(id);
            checkedOutItems.get(id).checkOut();
            return true;
        }
        return false;
    }

    public boolean returnItem(int id){
        if(checkedOutItems.containsKey(id)){
            availableItems.put(id, checkedOutItems.get(id));
            checkedOutItems.remove(id);
            availableItems.get(id).checkIn();
            return true;
        }
        return false;
    }
}
