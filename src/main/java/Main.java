import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import graph.GraphData;
import data.MatrixFactory;
import data.UserData;
import data.TestGraphData;
import java.io.File;
import java.util.List;
import parser.JsonMDBParser;
import processing.Result;
import processing.TestFlow;
import spark.Request;
import spark.Response;

public class Main {

    public static void main(String[] args) {
        Result results = new Result();
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        post("/mdb/:id", (req,res) -> {
            String uri = "https://psp-analysis.herokuapp.com/mdbs/"+req.params("id")+"/download";
            File file  = JsonMDBParser.create(uri);
            System.out.println(file.getName());
            try {
                Database db = DatabaseBuilder.open(file);
                System.out.println(db.getTableNames());
                UserData ud = new UserData(MatrixFactory.create(db));
                System.out.println(ud.getMatrix("ProgramSize"));
            }
            catch(Exception e){
                System.out.println(e);
            }
            res.redirect("https://psp-analysis.herokuapp.com/charts/create/",307);
            return "";
        });
        
        get("/result","application/json", (req, res) -> {
            String uri = "https://psp-analysis.herokuapp.com/mdbs/2/download";
            File file  = JsonMDBParser.create(uri);
            String jsonString ="";
            try {
                Database db = DatabaseBuilder.open(file);
                UserData ud = new UserData(MatrixFactory.create(db));
                results.setGraphData(TestFlow.procesReport(ud));
                jsonString = results.toJson();
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            return jsonString;
        });
    }
}
