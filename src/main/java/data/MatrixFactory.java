/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import java.io.IOException;
import java.util.ArrayList;
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
                Matrix m = new Matrix(tableName);
                list.add(m);
            }
        } catch (IOException ex) {
            Logger.getLogger(MatrixFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
