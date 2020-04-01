package com.example.onlineshop;

import java.util.ArrayList;
import java.util.Arrays;

public class Items {
    private ArrayList<String> listInfo;
    private ArrayList<String> listItems;

    public Items(){
        listInfo = new ArrayList<String>(Arrays.asList("Info Item1", "Info Item2",
                "Info Item3", "Info Item4", "Info Item5", "Info Item6" ));
        listItems = new ArrayList<String>(Arrays.asList("Item1", "Item2", "Item3", "Item4", "Item5", "Item6"));
    }

    public ArrayList<String> getListItems(){
        return listItems;
    }

    public ArrayList<String> getItemsInfo(){
        return listInfo;
    }

    public String getListItem(int index){
        return listItems.get(index);
    }

    public String getItemInfo(int index){
        return listInfo.get(index);
    }

    public Integer getSize(){
        return listInfo.size();
    }

}
