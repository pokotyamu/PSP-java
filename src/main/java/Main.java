import com.google.gson.Gson;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import data.GraphData;
import data.Matrix;
import data.MatrixFactory;
import data.UserData;
import data.testGraphData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.JsonMDBParser;
import spark.Request;
import spark.Response;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");
    
    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

    post("/mdb/:id", (req,res) -> {
        String uri = "https://psp-analysis.herokuapp.com/mdbs/"+req.params("id")+"/download";
        File file  = JsonMDBParser.create(uri);
        System.out.println(file.getName());
        try {
            Database db = DatabaseBuilder.open(file);
            System.out.println(db.getTableNames());
            UserData ud = new UserData(MatrixFactory.create(db));
            System.out.println(ud.getMatrix("LOGDDetail"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "";
    });
    
    get("/test/hoge", (req, res) -> {
        Gson gson = new Gson();
        GraphData gs = GraphData.initData();
        String msg = gson.toJson(gs);
        return "{" + new testGraphData() + "}";
    });
  }
}
