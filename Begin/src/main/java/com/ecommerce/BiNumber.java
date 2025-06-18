package com.ecommerce;

public class BiNumber {
    private int num1;
    private int num2;
    public BiNumber(int n1,int n2){
        this.num1= n1;
        this.num2=n2;
    }



    int add(){
        return num1+num2;
    }
    int multiply(){
        return num1*num2;
    }
    void dob(){
        this.num1 *=2;
        this.num2 *=2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
