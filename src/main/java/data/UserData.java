/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author pokotyamu
 */
public class UserData {
    
    private ArrayList<Matrix> matrixs;

    public UserData() {
        matrixs = new ArrayList<>();
    }

    public UserData(ArrayList<Matrix> matrixs) {
        this.matrixs = matrixs;
    }

    public Matrix getMatrix(String matrixName){
        Matrix m = new Matrix();
        for (Matrix matrix : matrixs) {
            if (matrix.getName().equals(matrixName)) {
                m = matrix;
            }
        }
        return m;
    }
    
}
