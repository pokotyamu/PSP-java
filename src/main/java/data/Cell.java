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
public class Cell {
    
    private Object value;

    public Cell(Object value) {
        if(value != null){
            this.value = value;
        }else{
            this.value = "";
        }

    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean equals(Cell c){
        return value.equals(c.getValue());
    }
    
    public double getNumValue() {
        return Double.valueOf(value.toString());
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

    public boolean check(String op, int i) {
        switch(op){
            case "==":
                return (int)this.getNumValue() == i;
            case ">":
                return (int)this.getNumValue() > i;
            case "<":
                return (int)this.getNumValue() < i;
            case ">=":
                return (int)this.getNumValue() >= i;
            case "<=":
                return (int)this.getNumValue() <= i;
        }
        return false;
    }
}
