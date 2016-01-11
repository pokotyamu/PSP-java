/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import data.DataSet;

/**
 *
 * @author pokotyamu
 */
public class LineGraphData extends GraphData{

    public LineGraphData() {
        super();
        this.type = "line";
    }

    @Override
    public String appendCategory() {
        StringBuilder str = new StringBuilder();
        if(category.isExist()){
            str.append(",\"xAxis\" : { \"title\" : \"");
            str.append(xAsixTtile);
            str.append("\", \"categories\" : ");
            str.append(category.getData());
            str.append("}");
        }
        return str.toString();
    }

    @Override
    public String appendSeries() {
        StringBuilder str = new StringBuilder();
        if (category.size() > 0) {
            str.append(",\"yAxis\" : {");
            str.append("\"series\": [");
            for(int i = 0; i < series.size(); i++){
                DataSet ds = series.get(i);
                if(i > 1){
                    str.append(",");
                }
                str.append("{ \"name\" : \"");
                str.append(ds.getDataName());
                str.append("\", \"data\" : ");
                str.append(ds.getData());
                str.append("}");
            }
            str.append("]}");
        }
        return str.toString();
    }
    
}
