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
public class ParetoGraphData extends GraphData{
    
    public DataSet column;
    public DataSet line;

    public ParetoGraphData() {
        this.type = "pareto";
    }
        
    public void setColumn(String dataName){
        column = this.matrix.getDataSet(dataName);
    }
    
    public void setline(String dataName){
        line = this.matrix.getDataSet(dataName);
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
        str.append(",\"yAxis\" : { \"title\" : \"");
        str.append(yAsixTtile);
        str.append("\" , \"series\": [");
        str.append("{ \"name\" : \"");
        str.append(column.getDataName());
        str.append("\", \"data\" : ");
        str.append(column.getData());
        str.append(",\"type\" : \"column\" ");
        str.append("}");

        str.append(",{ \"name\" : \"");
        str.append(line.getDataName());
        str.append("\", \"data\" : ");
        str.append(line.getData());
        str.append(",\"type\" : \"spline\" ");
        str.append("}");

        str.append("]}");
        return str.toString();
    }
}
