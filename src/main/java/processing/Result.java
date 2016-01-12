/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import graph.GraphData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class Result {
    
    private List<GraphData> gdlist;

    public Result() {
        this.gdlist = new ArrayList<>();
    }
    
    
    
    public String toJson() {
        StringBuilder str = new StringBuilder("{");
        for(int i = 0; i < gdlist.size(); i++){
            if(i > 0){
                str.append(",");
            }
            str.append("\"graph");
            str.append(i);
            str.append("\" : ");
            str.append(gdlist.get(i).toJson());
        }
        str.append("}");
        return str.toString();
    }

    public void setGraphData(List<GraphData> gdlist) {
        this.gdlist = gdlist;
    }
    
}
