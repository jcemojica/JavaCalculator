/*
* Class for the arithmetic; should ideally consume the API
* */

package com.mojica.calculator;

public class Calculator {
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double add(double b){
        return this.total + b;
    }

    public double subtract(double b){
        return this.total - b;
    }

    public double multiply(double b){
        return this.total * b;
    }

    public double divide(double b){
        return this.total / b;
    }
}
