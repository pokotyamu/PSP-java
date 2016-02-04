/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import data.Cell;
import data.DataSet;
import data.Matrix;
import jdk.nashorn.internal.codegen.CompilerConstants;

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

    public static Matrix apply(Matrix time, String function, boolean isRow) {
        Matrix temp = new Matrix();
        if (isRow) {

        }else{//byCol
            for(String names : time.getNameList()){
                switch(function){
                    case "sum":
                        temp.addCol(DataSetFunction.sum(time.getDataSet(names)));
                }
            }

        }
        return temp;        
    }

    public static Matrix byCount(Matrix matrix, String colName, String target) {
        Matrix count = new Matrix(matrix.getName());
        DataSet ds = matrix.getDataSet(target).uniqueList();
        count.addCol(ds);
        DataSet cds = new DataSet("COUNT_"+colName);
        for(Cell c : ds.getData()){
            cds.addCell(new Cell(DataSetFunction.count(matrix.getDataSet(target),c)));
        }
        count.addCol(cds);
        return count;
    }

    public static void parcentage(Matrix matrix, String colName) {
        DataSet ds = new DataSet("PARCENTAGE_"+colName);
        DataSet targetDS = matrix.getDataSet(colName);
        DataSet sum = DataSetFunction.sum(targetDS);
        for (Cell c :targetDS.getData()){
            ds.addCell(new Cell(c.getNumValue() / sum.getNumCell(0) * 100));
        }
        matrix.addCol(ds);
    }

    public static void stackParcentage(Matrix matrix, String colName) {
        parcentage(matrix, colName);
        DataSet ds = new DataSet("STACK_PARCENTAGE_"+colName);
        DataSet targetDS = matrix.getDataSet("PARCENTAGE_"+colName);
        double stack = 0.0;
        for(Cell c : targetDS.getData()){
            stack+=c.getNumValue();
            if(stack > 100.0){
                stack = 100.0;
            }            
            ds.addCell(new Cell(stack));
        }
        matrix.addCol(ds);
    }
}
