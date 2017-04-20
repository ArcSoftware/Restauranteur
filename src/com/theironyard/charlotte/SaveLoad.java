package com.theironyard.charlotte;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Jake on 4/19/17.
 */
public class SaveLoad {
    public static Gson gson = new Gson();

    public static MenuRepo loadMenuRepository() throws FileNotFoundException {
        //Read from Json
        File f = new File("menu.json");

        if (f.exists()) {
            Scanner s = new Scanner(f);
            s.useDelimiter("\\Z");
            String contents = s.next();
//            JsonParser p = new JsonParser();

            MenuRepo repo = gson.fromJson(contents, MenuRepo.class);
            return repo;
        } else {
            return null;
        }
    }
    public static void saveMenuRepository(MenuRepo repo) throws IOException {
        //Write to Json
        String json = gson.toJson(repo);
        File f = new File("menu.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

}
