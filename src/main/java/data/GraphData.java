/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pokotyamu
 */
public class GraphData {
    public String title ="";
    public String xAsix ="";
    
    public static GraphData initData() {
        GraphData gd = new GraphData();
        gd.title = "sample title";
        return gd;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        if(title.length() > 0){
            str.append("title :\n");
            str.append(title);
        }
        if(xAsix.length() > 0){
            str.append("xAsix :\n");
            str.append(xAsix);
        }
        str.append("}");
        return str.toString();
    }
    
}
