/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author pokotyamu
 */
public class GraphDataFactory {
 
    
    public static GraphData createGraphData(String type){
        switch(type){
            case "line" :
                return new LineGraphData();
            case "column":
                return new ColumnGraphData();
            case "pie" :
                return new PieGraphData();
        }
        return null;
    }
}
