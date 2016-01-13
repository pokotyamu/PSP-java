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
public class PieGraphData extends GraphData{
    
    public String seriesName = "";

    public PieGraphData() {
        super();
        this.type = "pie";
    }

    public PieGraphData(Matrix matrix) {
        super(matrix);
        this.type = "pie";
    }
    
            
    @Override
    public String appendCategory() {
        return "";
    }

    @Override
    public String appendSeries() {
        StringBuilder str = new StringBuilder();
        if (series.size() > 0) {
            str.append(", \"series\": [{ \"name\" : \"");
            str.append(seriesName);
            str.append("\" , \"data\" : [");
            for(int i = 0; i < series.size(); i++){
                DataSet ds = series.get(i);
                if(i > 0){
                    str.append(",");
                }
                str.append("{ \"name\" : \"");
                str.append(ds.getDataName());
                str.append("\", \"y\" : ");
                str.append(ds.getData());
                str.append("}");
            }
            str.append("]}]");
        }
        return str.toString();
    }
    
}
