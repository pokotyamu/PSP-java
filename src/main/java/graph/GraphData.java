/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import data.DataSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pokotyamu
 */
public abstract class GraphData {
    public String title = "";
    public String type = "";
    public DataSet category;
    public List<DataSet> series;

    public GraphData() {
        this.title = "sample title";
        this.category = new DataSet();
        this.series = new ArrayList<>();
    }
    
    public void addSeries(DataSet ds){
        this.series.add(ds);
    }
    
    public String toJson(){
        StringBuilder str = new StringBuilder("{");
        str.append(this.appendInitData());
        str.append(this.appendCategory());
        str.append(this.appendSeries());
        str.append("}");
        return str.toString();
    }
    
    
    protected String chackExist(String target, String jsonString) {
        if(target.length() > 0){
                return ", \""+jsonString + "\" : \"" + target + "\"";
        }else{
            return "";
        }
    }

    public String appendInitData() {
        StringBuilder str = new StringBuilder();
        str.append("\"title\" : \"");
        str.append(title);
        str.append("\" ");
        str.append(this.chackExist(type,"type"));
        return str.toString();
    }

    public abstract String appendCategory();

    public abstract String appendSeries();
}