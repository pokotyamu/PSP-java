/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pokotyamu
 */
public class UserData {
    
    private ArrayList<Matrix> matrices;

    public UserData() {
        this.matrices = new ArrayList<>();
    }

    public UserData(ArrayList<Matrix> matrixs) {
        this.matrices = matrixs;
    }

    public Matrix getMatrix(String matrixName){
        Matrix m = new Matrix();
        for (Matrix matrix : matrices) {
            if (matrix.getName().equals(matrixName)) {
                m = matrix;
            }
        }
        return m;
    }
    
    public List<String> getMatrixNames(){
        List<String> nameList = new ArrayList();
        for (Matrix matrix : matrices) {
            nameList.add(matrix.getName());
        }
        return nameList;
    }
    
}
