/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import graph.GraphData;
import graph.GraphDataFactory;

/**
 *
 * @author pokotyamu
 */
public class testGraphData {

    public static GraphData init() {
        GraphData gd = GraphDataFactory.createGraphData("line");
        gd.category = new DataSet("ProjectID");
        for(int i = 400; i < 408; i++){
            gd.category.addCell(new Cell(i));
        }
        
        DataSet ds = new DataSet("ActMinTotal");
        for(int i = 400; i < 408; i++){
            ds.addCell(new Cell(i));
        }
        gd.series.add(ds);
        
        return gd;
    }

    @Override
    public String toString() {
        
        String json = "    \"graph\" : {" +
                "        \"title\" : \"Title sample\"," +
                "        \"type\" : \"line\"," +
                "        \"xAxis\" : {" +
                "            \"title\" : {" +
                "                \"text\" : \"xTitle\"," +
                "                \"margin\" : 20" +
                "            }," +
                "            \"categories\" : [400,401,402,403,404,405,406,407,408]" +
                "        }," +
                "        \"yAxis\" : {" +
                "            \"title\" : {" +
                "                \"text\" : \"yTitle\"," +
                "                \"margin\" : 20" +
                "            }" +
                "        }," +
                "        \"series\" : {" +
                "            \"name\" : \"ActMinTotal\"," +
                "            \"data\" : [500,600,550,630,800,920,1100,300]" +
                "        }" +
                "    }";
        
        return json; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
