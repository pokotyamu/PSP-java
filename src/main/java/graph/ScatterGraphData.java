/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import data.DataSet;
import data.Matrix;

/**
 *
 * @author pokotyamu
 */
public class ScatterGraphData extends GraphData{

    public ScatterGraphData() {
        super();
        this.type = "scatter";
    }

    public ScatterGraphData(Matrix matrix) {
        super(matrix);
        this.type = "scatter";
    }
    
    @Override
    public String appendCategory() {
        StringBuilder str = new StringBuilder();
        if(xAsixTtile.length() > 0){
            str.append(",\"xAxis\" : { \"title\" : \"");
            str.append(xAsixTtile);
            str.append("\"}");
        }
        return str.toString();
    }

    @Override
    public String appendSeries() {
        StringBuilder str = new StringBuilder();
        if (matrix.size() > 0) {
            str.append(",\"yAxis\" : { \"title\" : \"");
            str.append(yAsixTtile);
            str.append("\" , \"series\": [");
            str.append(appendMatrix());
            str.append("]}");
        }
        return str.toString();
    }

    private String appendMatrix() {
        StringBuilder str = new StringBuilder();
        str.append("{\"name\" : \"");
        str.append(matrix.getName());
        str.append("\" , \"data\" : [");
        for(int i = 0;i < matrix.getCols().size(); i += 2){
            DataSet ds1 = matrix.getCols().get(i);
            DataSet ds2 = matrix.getCols().get(i + 1);
            for (int j = 0; j < ds1.size(); j++) {
                if(j > 0){
                    str.append(",");
                }
                str.append("[");
                str.append(ds1.getCell(j));
                str.append(",");
                str.append(ds2.getCell(j));
                str.append("]");                    
            }
            str.append("]}");
        }
        return str.toString();
    }
    
}
