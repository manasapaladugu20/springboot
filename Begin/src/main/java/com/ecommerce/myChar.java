package com.ecommerce;

public class myChar {
    private char ch;
    public myChar(char ch) {
        this.ch = ch;
    }
    public boolean isVowel(){
        if(ch =='a' || ch =='e' || ch =='i'|| ch =='o'|| ch =='u') {
            return true;
        }
        return false;
    }
    public boolean isDigit(){
        if(ch >=48 && ch<=57 ) { //between '0' and '9'
            return true;
        }
        return false;
    }
    public boolean isAlphabet(){
        if(ch >=97 && ch<=122 ) { //between 'a' and 'z'
            return true;
        }
        return false;
    }
}
