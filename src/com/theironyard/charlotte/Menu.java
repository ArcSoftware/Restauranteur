package com.theironyard.charlotte;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jake on 4/19/17.
 */
public class Menu {
    public static int id;
    public static String name;
    public static String description;
    public static double price;
    public static boolean available;

    public Menu(int id, String name, String description, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }


}
