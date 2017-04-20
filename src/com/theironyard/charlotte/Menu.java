package com.theironyard.charlotte;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jake on 4/19/17.
 */
public class Menu {
    public  int id;
    public  String name;
    public  String description;
    public  double price;
    public  boolean available;

    public Menu(int id, String name, String description, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString(){
        return "[id: "+id+", name: "+name+"]";
    }


}
