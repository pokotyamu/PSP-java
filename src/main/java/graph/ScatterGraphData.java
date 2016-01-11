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
        if (matrixs.size() > 0) {
            str.append(",\"yAxis\" : { \"title\" : \"");
            str.append(yAsixTtile);
            str.append("\" , \"series\": [");
            str.append(appendMatrix());
/*            
            for(int i = 0; i < series.size(); i += 2){
                DataSet ds = series.get(i);
                DataSet ds1 = series.get(i+1);
                if(i > 0){
                    str.append(",");
                }
                str.append("{ \"name\" : \"");
                str.append(ds.getDataName());
                str.append("\", \"data\" : ");
                str.append(ds.getData());
                str.append("}");
            }
*/
            str.append("]}");
        }
        return str.toString();
    }

    private String appendMatrix() {
        StringBuilder str = new StringBuilder();
        for (Matrix matrix : matrixs) {
            str.append("{\"name\" : \"");
            str.append(matrix.getName());
            str.append("\" , \"data\" : [");
            System.out.println();
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
            }
            str.append("]}");
        }
        return str.toString();
    }
    
}