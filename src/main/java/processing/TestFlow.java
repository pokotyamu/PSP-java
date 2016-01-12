/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import data.TestGraphData;
import data.UserData;
import graph.GraphData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class TestFlow {

    public static List<GraphData> procesReport(UserData ud) {
        List<GraphData> list = new ArrayList<>();
        list.add(TestGraphData.lineGraphData());
        list.add(TestGraphData.lineGraphData());
        list.add(TestGraphData.columnGraphData());
        list.add(TestGraphData.pieGraphData());
        list.add(TestGraphData.scatterGraphData());
        return list;
    }
}
