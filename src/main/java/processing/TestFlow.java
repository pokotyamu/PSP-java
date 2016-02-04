/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import Function.MatrixFunction;
import data.Matrix;
import data.UserData;
import graph.GraphData;
import graph.LineGraphData;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.Size2DSyntax;
import org.codehaus.plexus.configuration.PlexusConfigurationMerger;

/**
 *
 * @author pokotyamu
 */
public class TestFlow {

    public static List<GraphData> processReport(UserData ud) {
        List<GraphData> list = new ArrayList<>();
/*
        //生産性
        Matrix m1 = ud.getMatrix("ProgramSize");
        Matrix m2 = ud.getMatrix("Projects");
        m1.mergeMatrix(m2);
        MatrixFunction.div(m1,"AT", 60);
        MatrixFunction.div(m1,"ActualT","DIV_AT.60");
        m1.setName("DIV_ActualT.DIV_AT.60","productivity");
        LineGraphData gd1 = new LineGraphData();
        gd1.setMatrix(m1);
        gd1.setTitle("title");
        gd1.setCategory("ProjectID");
        gd1.addSeries("productivity");
        gd1.setxAsixTtile("ProjectID");
        gd1.setyAsixTtile("LOC/h");
        list.add(gd1);
*/       
        //
        
        return list;
    }
}
