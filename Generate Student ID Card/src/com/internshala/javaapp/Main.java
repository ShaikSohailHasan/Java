package com.internshala.javaapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name = null;
        int age = 0;
        char blood_group;
        String group = null;

        Scanner x = new Scanner(System.in);

        System.out.println("Enter your name: ");
        name = x.nextLine();

        System.out.println("Enter your age: ");
        age = x.nextInt();

        System.out.println("Enter your blood group: ");
        blood_group = x.next().charAt(0);

        // IF ELSE IF Ladder for Group.
        if(age >= 20)
        {
            group = "RED";
        } else if(age >= 15)
        {
            group = "BLUE";
        }else if(age >= 10)
        {
            group = "YELLOW";
        }else if(age >= 5)
        {
            group = "GREEN";
        }else
        {
            group = "WHITE";
        }

        System.out.println("        STUDENT ID CARD       ");
        System.out.println("------------------------------");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Blood Group: "+blood_group);
        System.out.println("------------------------------");
        System.out.println("Your group is "+group);
        System.out.println("------------------------------");

    }
}
