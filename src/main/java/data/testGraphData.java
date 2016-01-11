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
        gd.xAsixTtile = "ProjectID";

        DataSet ds = new DataSet("ActMinTotal");
        DataSet ds1 = new DataSet("sample");
        for(int i = 400; i < 408; i++){
            ds.addCell(new Cell(Math.random()));
            ds1.addCell(new Cell(Math.random()));
        }
        gd.series.add(ds);
        gd.series.add(ds1);
        gd.yAsixTtile = "type";
        return gd;
    }
    
}
