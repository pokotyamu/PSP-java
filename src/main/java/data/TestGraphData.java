/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import graph.ColumnGraphData;
import graph.GraphData;
import graph.GraphDataFactory;
import graph.PieGraphData;
import graph.ScatterGraphData;

/**
 *
 * @author pokotyamu
 */
public class TestGraphData {

    public static GraphData lineGraphData() {
        GraphData gd = GraphDataFactory.createGraphData("line");

        gd.category = new DataSet("ProjectID");
        for(int i = 400; i < 408; i++){
            gd.category.addCell(new Cell(i));
        }
        gd.xAsixTtile = "ProjectID";

        DataSet ds = new DataSet("ActMinTotal");
        DataSet ds1 = new DataSet("sample");
        for(int i = 400; i < 408; i++){
            ds.addCell(new Cell((int) (100 * Math.random())));
            ds1.addCell(new Cell((int) (100 * Math.random())));
        }
        gd.series.add(ds);
        gd.series.add(ds1);
        gd.yAsixTtile = "type";
        return gd;
    }

    public static GraphData columnGraphData() {
        ColumnGraphData gd = (ColumnGraphData) GraphDataFactory.createGraphData("column");
        gd.category = new DataSet("ProjectID");
        for(int i = 400; i < 408; i++){
            gd.category.addCell(new Cell(i));
        }
        gd.xAsixTtile = "ProjectID";
        DataSet ds = new DataSet("ActMinTotal");
        DataSet ds1 = new DataSet("sample");
        for(int i = 400; i < 408; i++){
            ds.addCell(new Cell((int) (100 * Math.random())));
            ds1.addCell(new Cell((int) (100 * Math.random())));
        }
        gd.series.add(ds);
        gd.series.add(ds1);
        gd.yAsixTtile = "type";
        return gd;
    }

    public static GraphData pieGraphData(){
        PieGraphData gd = (PieGraphData) GraphDataFactory.createGraphData("pie");
        for (int i = 0; i < 5; i++) {
            DataSet ds = new DataSet("sample"+i);
            ds.addCell(new Cell((int) (10 * Math.random())));
            gd.series.add(ds);
        }
        gd.seriesName = "時間";
        return gd;
    }
    
    public static GraphData scatterGraphData(){
        ScatterGraphData gd = (ScatterGraphData) GraphDataFactory.createGraphData("scatter");
        DataSet ds = new DataSet("xdata");
        DataSet ds1 = new DataSet("ydata");
        for(int i = 0; i < 120; i++){
            ds.addCell(new Cell((int) (1000 * Math.random())));
            ds1.addCell(new Cell((int) (100 * Math.random())));
        }
        Matrix  m = new Matrix("titlename");
        m.addCol(ds);
        m.addCol(ds1);
        gd.addMatrixs(m);
        return gd;
    }
}
