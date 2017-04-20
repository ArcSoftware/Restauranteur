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

        System.out.println("Loading Menu Repository.");
        MenuRepo repo = SaveLoad.loadMenuRepository();
        tables = repo.activeTables;



        Spark.get("/menu", (req, res) -> {
            System.out.println(orderMenu.size());
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
            SaveLoad.saveMenuRepository(new MenuRepo(tables));
            return "";
        });


        Spark.get("/bill/:tableID", (req, res) -> {
                    String table = req.queryParams("tableID");
                    if (tables.keySet().contains(table)) {
                        return gsonOut.toJson(tables.keySet().equals(table));
                    } else {
                        return "";
                    }
                });


//        Spark.post("/menu", (req, res) -> {
//            Menu menuAdd = gsonOut.fromJson(req.body(), Menu.class);
////            Message message = new JsonParser().parse(req.body(), Message.class); <- to complex
//            orderMenu.put()
//
//            return "";
//        });





//        Spark.get(
//                "/",
//                ((request, response) -> {
//                    HashMap m = new HashMap();
//                    Session session = request.session();
//
//                    String userName = session.attribute("userName");
//                    User user = users.get(userName);
//
//                    if (user == null) {
//                        return new ModelAndView(m, "index.html");
//                    } else {
//                        m.put("name", user.name);
//                        m.put("messages", messages);
//                        return new ModelAndView(m, "messages.html");
//                    }
//                }),
//                new MustacheTemplateEngine()
//        );
    }
}
