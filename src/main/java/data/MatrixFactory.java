/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokotyamu
 */
public class MatrixFactory {

    public static ArrayList<Matrix> create(Database db){
        ArrayList<Matrix> list = new ArrayList<>();
        try {
            for(String tableName : db.getTableNames()){
                System.out.println(tableName);
                list.add(create(db,tableName));
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public static Matrix create(Database db,String tableName){
        Matrix m = new Matrix(tableName);
        try {
            Table tb = db.getTable(tableName);
            List<? extends Column> columns = tb.getColumns();
            for (Column c : columns) {
                m.addCol(new DataSet(c.getName()));
            }
            for(Row row : tb){
                for(Column c : columns){
                    m.addCell(c.getName(),row.get(c.getName()));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
}
