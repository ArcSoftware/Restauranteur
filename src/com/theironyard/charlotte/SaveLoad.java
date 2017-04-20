package com.theironyard.charlotte;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

/**
 * Created by Jake on 4/19/17.
 */
public class SaveLoad {
//    public static Gson gson = new Gson();
//
//    public static MenuRepo loadMenuRepository() throws NoSuchFileException, FileNotFoundException {
//        //Read from Json
//        File f = new File("menu.json");
//        MenuRepo repo = new MenuRepo();
//
//        if (f.exists()) {
//            Scanner s = new Scanner(f);
//            s.useDelimiter("\\Z");
//
//            if (s.hasNext()) {
//                String contents = s.next();
//                repo = gson.fromJson(contents, MenuRepo.class);
//            }
//        }
//
//        return repo;
//    }
//    public static void saveMenuRepository(MenuRepo repo) throws IOException {
//        //Write to Json
//        String json = gson.toJson(repo);
//        File f = new File("menu.json");
//        FileWriter fw = new FileWriter(f);
//        fw.write(json);
//        fw.close();
//    }

}
