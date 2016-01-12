/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import data.Matrix;
import data.TestGraphData;
import data.UserData;
import graph.GraphData;
import graph.LineGraphData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class TestFlow {

    public static List<GraphData> procesReport(UserData ud) {
        List<GraphData> list = new ArrayList<>();
        Matrix m = ud.getMatrix("ProgramSize");
        LineGraphData gd1 = new LineGraphData();
        gd1.setMatrix(m);
        gd1.title = "title";
        gd1.setCategory("ProjectID");
        gd1.addSeries("ActualT");
        gd1.addSeries("ActualA");
        gd1.setxAsixTtile("ProjectID");
        gd1.setyAsixTtile("LOC");
        list.add(gd1);
        return list;
    }
}
