/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import data.Matrix;
/**
 *
 * @author pokotyamu
 */
public class GraphDataFactory {
 
    
    public static GraphData createGraphData(String type, Matrix matrix){
        switch(type){
            case "line" :
                return new LineGraphData(matrix);
            case "column":
                return new ColumnGraphData(matrix);
            case "pie" :
                return new PieGraphData(matrix);
            case "scatter":
                return new ScatterGraphData(matrix);

        }
        return null;
    }
}
