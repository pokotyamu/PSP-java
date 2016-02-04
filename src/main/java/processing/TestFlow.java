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
import graph.ParetoGraphData;
import graph.PieGraphData;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pokotyamu
 */
public class TestFlow {

    public static List<GraphData> processReport(UserData ud) {
        List<GraphData> list = new ArrayList<>();

        //生産性
        Matrix m1 = ud.getMatrix("ProgramSize");
        Matrix m2 = ud.getMatrix("Projects");
        m1.mergeMatrix(m2);
        MatrixFunction.div(m1,"AT", 60);
        MatrixFunction.add(m1, "ActualA", "ActualM");
        m1.setName("ADD_ActualA.ActualM","ActualA&M");
        MatrixFunction.div(m1,"ActualA&M","DIV_AT.60");        
        m1.setName("DIV_ActualA&M.DIV_AT.60","productivity");
        LineGraphData gd1 = new LineGraphData();
        gd1.setMatrix(m1);
        gd1.setTitle("生産性の推移");
        gd1.setCategory("ProjectID");
        gd1.addSeries("productivity");
        gd1.setxAsixTtile("ProjectID");
        gd1.setyAsixTtile("LOC/h");
        list.add(gd1);

        //フェーズ時間割合
        List<String> namelist = new ArrayList<>();
        namelist.add("ActMinPlan");
        namelist.add("ActMinDsgn");
        namelist.add("ActMinDLDR");
        namelist.add("ActMinCode");
        namelist.add("ActMinCR");
        namelist.add("ActMinCompile");
        namelist.add("ActMinTest");
        namelist.add("ActMinPM");
        Matrix time = ud.getMatrix("PSPAssgtData").selectDataSet(namelist);
        Matrix sum = MatrixFunction.apply(time,"sum",false);
        PieGraphData phase = new PieGraphData(sum);
        for (String name : namelist) {
            sum.setName("SUM_"+name, name);
            phase.addSeries(sum.getDataSet(name));
        }
        phase.setTitle("フェーズの時間割合");
        phase.setSeriesName("時間(%)");
        list.add(phase);
/*        
        //欠陥種別のパレート図
        Matrix defect = ud.getMatrix("LOGDDetail");
        defect.filter("PhaseInjectedID","==",2);
        System.out.println(defect.getDataSet("PhaseInjectedID"));
        Matrix count_Phase = MatrixFunction.byCount(defect,"PhaseInjectedID","DefectTypeID");
        count_Phase.sort(0,"COUNT_PhaseInjectedID");
        MatrixFunction.parcentage(count_Phase,"COUNT_PhaseInjectedID");
        MatrixFunction.stackParcentage(count_Phase,"COUNT_PhaseInjectedID");
        System.out.println(count_Phase);
        
        
        ParetoGraphData defect_pareto = new ParetoGraphData();
        */
        return list;
    }
}
