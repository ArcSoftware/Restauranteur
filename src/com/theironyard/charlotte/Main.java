package com.theironyard.charlotte;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static Gson gsonOut = new Gson();
    public static ArrayList<Menu> orderMenu = new ArrayList<>();
    public static HashMap<String, Table> tables = new HashMap<>();


    public static void main(String[] args) throws Exception{
        Spark.init();

        orderMenu.add(new Menu(1, "Number 1", "Pizza with a side of fries, and a drink.",
                6.99, true));
        orderMenu.add(new Menu(2,"Number 2", "Hamburger with fries and a drink.",
                6.99, true));
        orderMenu.add(new Menu(3, "Number 3", "Foot-long Hot Dog with fries and a drink.",
                5.99, true));
        orderMenu.add(new Menu(4, "Number 4", "Baked Ziti and a drink.",
                7.99, true));
        orderMenu.add(new Menu(5, "Number 5", "Raw meat lathered with gravy.",
                2.99, true));

        System.out.println("Loading Menu Repository.");
        // MenuRepo repo = SaveLoad.loadMenuRepository();
        // tables = repo.activeTables;


        Spark.get("/menu", (req, res) -> {
            System.out.println(orderMenu.size());
            System.out.println(gsonOut.toJson(orderMenu));

            for(Menu m : orderMenu) {
                System.out.println(m.toString());
            }
            return gsonOut.toJson(orderMenu);
        });


        Spark.post("/order/:id", (req, res) -> {
            String order = req.queryParams("id");
            String body = req.body();
            Table t = gsonOut.fromJson(body, Table.class);

            for (int i = 0; i < orderMenu.size(); i++) {
                Menu orderID = orderMenu.get(i);

                if (orderID.id == Integer.valueOf(order)) {
                    t.items.add(orderID);
                }
            }

            if (tables.keySet().contains(t.tableID)) {
                tables.get(t.tableID).items.addAll(t.items);
            } else {
                tables.put(t.tableID, t);
            }

            // SaveLoad.saveMenuRepository(new MenuRepo(tables));
            return "";
        });


        Spark.get("/bill/:tableID", (req, res) -> {
            String table = req.queryParams("tableID");
            return gsonOut.toJson(tables.get(table));
        });


    }
}
