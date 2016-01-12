/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import graph.ColumnGraphData;
import graph.GraphData;
import graph.GraphDataFactory;
import graph.LineGraphData;
import graph.PieGraphData;
import graph.ScatterGraphData;

/**
 *
 * @author pokotyamu
 */
public class TestGraphData {

    private static Matrix createTestData(){
    Matrix m = new Matrix();
        DataSet category = new DataSet("ProjectID");
        for(int i = 400; i < 408; i++){
            category.addCell(new Cell(i));
        }
        DataSet ds = new DataSet("ActT");
        DataSet ds1 = new DataSet("ActA");
        for(int i = 400; i < 408; i++){
            ds.addCell(new Cell((int) (100 * Math.random())));
            ds1.addCell(new Cell((int) (60 * Math.random())));
        }
        m.addCol(category);
        m.addCol(ds);
        m.addCol(ds1);
        return m;
    }
    
    public static GraphData lineGraphData() {
        LineGraphData gd = (LineGraphData) GraphDataFactory.createGraphData("line");
        Matrix m = createTestData();
        gd.setMatrix(m);
        gd.setCategory("ProjectID");
        gd.addSeries("ActT");
        gd.addSeries("ActA");
        gd.setxAsixTtile("ProjectID");
        gd.setyAsixTtile("LOC");
        return gd;
    }

    public static GraphData columnGraphData() {
        ColumnGraphData gd = (ColumnGraphData) GraphDataFactory.createGraphData("column");
        Matrix m = createTestData();
        gd.setMatrix(m);
        gd.setCategory("ProjectID");
        gd.addSeries("ActT");
        gd.addSeries("ActA");
        gd.setxAsixTtile("ProjectID");
        gd.setyAsixTtile("LOC");
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
        gd.matrix = m;
        return gd;
    }
}
