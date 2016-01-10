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
public class DataSet {
    
    private String dataName;
    private List<Cell> cells;

    //init
    public DataSet(){
        this.dataName = "";
        this.cells = new ArrayList<>();
    }
    
    public DataSet(String dataName) {
        this.dataName = dataName;
        this.cells = new ArrayList<>();
    }
    
    public String getDataName() {
        return dataName;
    }
    
    public void addCell(Cell c){
        cells.add(c);
    }
    
    public void setCell(int index,Cell c){
        cells.set(index, c);
    }

    public boolean isName(String dataName) {
        return this.dataName.equals(dataName);
    }

    public void switchCell(int a, int b) {
        Cell tempc = this.cells.get(a);
        this.cells.set(a, cells.get(b));
        this.cells.set(b, tempc);
    }
    
    public int size() {
        return this.cells.size();
    }

    public Cell getCell(int i) {
        return this.cells.get(i);
    }

    public double getNumCell(int i) {
        return cells.get(i).getNumValue();
    }
    
    public int getCellIndex(Cell c) {
        return cells.indexOf(c);
    }
    
    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("dataName : ");
        strb.append(dataName);
        strb.append("\nCell : ");
        strb.append(cells);
        return strb.toString();
    }

    public List<Cell> getData() {
        return cells;
    }

    public boolean isExist() {
        return this.dataName.length() > 0;
    }
}
