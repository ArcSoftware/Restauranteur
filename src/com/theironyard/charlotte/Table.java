package com.theironyard.charlotte;

import java.util.ArrayList;

/**
 * Created by Jake on 4/19/17.
 */
public class Table {
    String tableID;
    ArrayList<Menu> items = new ArrayList<>();

    public Table(String tableID, ArrayList<Menu> items) {
        this.tableID = tableID;
        this.items = items;
    }
}
