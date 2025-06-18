package com.ecommerce.delnew;

import java.util.Scanner;

public class del {

    public static void main(String[] args)
    {
        int a,c =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a:");
         a = sc.nextInt();
        for(int i=1;i<=10;i++){
            c= a*i;
            System.out.println("Output:"+ a + "*"+ i +"=" c);
        }
    }
}
