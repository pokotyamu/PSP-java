/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import data.Cell;
import data.DataSet;
import data.Matrix;

/**
 *
 * @author pokotyamu
 */
public class MatrixFunction {
    
    public static void div(Matrix m, String d1, String d2) {
        DataSet ds1 = m.getDataSet(d1);
        DataSet ds2 = m.getDataSet(d2);
        DataSet ans = new DataSet("DIV_"+d1+"."+d2);
        System.out.println(ds1);
        System.out.println(ds2);
        for(int index = 0; index < ds1.size(); index++){
            ans.addCell(new Cell(ds1.getNumCell(index) / ds2.getNumCell(index)));
        }
        System.out.println(ans);
        m.addCol(ans);
    }
    
    public static void div(Matrix m, String d1, int num) {
        DataSet ds1 = m.getDataSet(d1);
        DataSet ans = new DataSet("DIV_"+d1+"."+num);
        for(int index = 0; index < ds1.size(); index++){
            ans.addCell(new Cell(ds1.getNumCell(index) / num));
        }
        m.addCol(ans);
    }

    
    public static void div(Matrix m, int num, String d1) {
        DataSet ds1 = m.getDataSet(d1);
        DataSet ans = new DataSet("DIV_"+num+"."+d1);
        for(int index = 0; index < ds1.size(); index++){
            ans.addCell(new Cell(num / ds1.getNumCell(index)));
        }
        m.addCol(ans);
    }
}
