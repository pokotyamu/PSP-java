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
public class Matrix {
    
    private List<DataSet> cols;
    private DataSet projectIDds;
    private String name;
    
    public Matrix() {
        cols = new ArrayList<>();
        projectIDds = new DataSet("ProjectIDs");
    }
    
    public Matrix(String name){
        cols = new ArrayList<>();
        projectIDds = new DataSet("ProjectIDs");
        this.name = name;
    }

    public Matrix(List<DataSet> cols, String name) {
        this.cols = cols;
        this.name = name;
    }
    
    
    
    //DataSetの順番については正しく並べ替えられているものとする
    public void addCol(DataSet ds){
        cols.add(ds);
    }
    
    //まとめて追加
    public void addCols(List<DataSet> cols) {
        for (DataSet col : cols) {
            this.cols.add(col);
        }
    }
    
    public void setProjectID(DataSet ds){
        this.projectIDds = ds;
    }
    
    public DataSet getProjectID(){
        return projectIDds;
    }
    
    public int getProjectIDIndex(Cell c){
        return projectIDds.getCellIndex(c);
    }
    
    public int getProjectIDIndex(Object ob){
        return projectIDds.getCellIndex(new Cell(ob));
    }
    
    public int getProjectIDIndex(int id){
        return projectIDds.getCellIndex(new Cell(id));
    }
    
    public DataSet getDataSet(String name) {
        DataSet ds = new DataSet();
        for (DataSet col : cols) {
            if(col.isName(name)){
                return col;
            }
        }
        return ds;
    }

    public String getName() {
        return name;
    }
    
    public Cell getCell(String colName, int i){
        return this.getDataSet(colName).getCell(i);
    }

    //ひょっとしたらシャローコピーになってる可能性あり
    public List<DataSet> getCols() {
        return cols;
    }

    //テーブル列内のソート関数
    //keyが1の時：降順
    //keyが−1の時：昇順
    public void sort(int key,String dataName){
        DataSet ds = this.getDataSet(dataName);
        if(key > 0){//昇順
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getNumCell(i) > ds.getNumCell(j)){
                        switchCell(i, j);
                    }
                }
            }
        }else{//降順
            for(int i = 0; i < ds.size()-1;i++){
                for(int j = i+1; j < ds.size();j++){
                    if(ds.getNumCell(i) < ds.getNumCell(j)){
                        switchCell(i, j);
                    }
                }
            }
        }
    }
    
    //その他の全ての列に対しても並べ替えを行う
    private void switchCell(int a,int b){
        for (DataSet col : cols) {
            col.switchCell(a, b);
        }
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("TableName : ");
        strb.append(name);
        strb.append("\n=Cols=\n");
            for (DataSet col : cols) {
                try{
                    strb.append(col);
                    strb.append("\n");
                }catch(NullPointerException nu){
                    System.out.println("nullはここ");
                }
            }
        return strb.toString();
    }

    public void addCell(String name, Object cell) {
        getDataSet(name).addCell(new Cell(cell));
    }

    public int size() {
        return this.cols.size();
    }
    
    public List<String> getNameList(){
        List<String> namelist = new ArrayList<>();
        for (DataSet col : cols) {
            namelist.add(col.getDataName());
        }
        return namelist;
    }

    public void mergeMatrix(Matrix m2) {
        for(DataSet ds : m2.getCols()){
            if(!this.getNameList().contains(ds.getDataName())){
                cols.add(ds);
            }            
        }
    }

    public void setName(String target, String after) {
        this.getDataSet(target).setName(after);
    }
    
    public Matrix selectDataSet(List<String> names){
        List<DataSet> list = new ArrayList<>();
        for (String name : names) {
            list.add(getDataSet(name));
        }
        return new Matrix(list, name);        
    }
    
    public void filter(String target, String op, int num){
        DataSet ds = this.getDataSet(target);
        for (int i = ds.size() - 1; i >=0; i--) {
            Cell c = ds.getCell(i);
            if(!c.check(op, num)){
                removeRowCell(i);
            }
        }
    }

    private void removeRowCell(int i) {
        for (DataSet col : cols) {
            col.remove(i);
        }
    }
}