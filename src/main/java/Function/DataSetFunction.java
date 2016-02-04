/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import data.Cell;
import data.DataSet;

/**
 *
 * @author pokotyamu
 */
public class DataSetFunction {

    public static DataSet sum(DataSet dataSet) {
        DataSet ds = new DataSet("SUM_"+dataSet.getDataName());
        double sum = 0.0;
        for(Cell c : dataSet.getData()){
            sum += c.getNumValue();
        }
        ds.addCell(new Cell(sum));
        return ds;
    }

    public static int count(DataSet ds, Cell target) {
        int count = 0;
        for(Cell c : ds.getData()){
            if(c.equals(target)){
                count++;
            }
        }
        return count;
    }
    
}
