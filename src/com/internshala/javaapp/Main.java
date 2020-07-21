package com.internshala.javaapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0;

        Scanner x = new Scanner(System.in);

        System.out.println("Tax Calculator App");
        System.out.println("------WELCOME-----"+"\n");

        System.out.println("Enter total person count: ");
        count = x.nextInt();
        System.out.println("\n");

        String[] name = new String[count];
        long[] annual_income = new long[count];
        double[] tax = new double[count];

        for(int i = 0; i < count; i++)
        {
            System.out.println("Enter name "+(i+1)+": ");
            name[i] = x.next();
            System.out.println("Enter "+name[i]+"'s Annual Income: ");
            annual_income[i] = x.nextInt();
            System.out.println("\n");
        }

        for(int i = 0; i < count; i++)
        {
            if(annual_income[i] >= 300000 )
            {
                tax[i] = 0.2 * annual_income[i];
            }else if (annual_income[i] >= 100000 )
            {
                tax[i] = 0.1 * annual_income[i];
            }else
            {
                tax[i] = 0;
            }
        }
        System.out.println("\n");
        System.out.println("Names with liable taxes");
        System.out.println("-----------------------");
        for(int i = 0; i < count; i++)
        {
            System.out.println(name[i]+": "+ "\u20B9 "+tax[i]);
        }
        x.close();
    }
}
