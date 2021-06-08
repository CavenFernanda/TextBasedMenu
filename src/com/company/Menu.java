package com.company;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        //Declaring Scanner
        Scanner input = new Scanner(System.in);

        //Display Menu
        System.out.println("*******  M E N U  *******");
        System.out.println("---------------------------------------");
        System.out.println("1. List folders and files in a directory");
        System.out.println("2. Display the contents of a file on screen");
        System.out.println("3. Display HTML Response for a Web Address");
        System.out.println("4. Exit Application\n");
        System.out.println("Please enter choice: ");

        //Getting input from the user
        int choice = input.nextInt();

        while(choice != 4){

            //User's choice
            if (choice == 1){
                System.out.println("List folders and files in a directory");
            }
            else if (choice == 2){
                System.out.println("Display the contents of a file on screen");
            }
            else if (choice == 3){
                System.out.println("Display HTML Response for a Web Address");
            }

            //Display Menu
            System.out.println("*******  M E N U  *******");
            System.out.println("---------------------------------------");
            System.out.println("1. List folders and files in a directory");
            System.out.println("2. Display the contents of a file on screen");
            System.out.println("3. Display HTML Response for a Web Address");
            System.out.println("4. Exit Application\n");
            System.out.println("Please enter choice: ");

            choice = input.nextInt();
        }
        System.out.println("You have ended the programme. Have a good day!");
    }
}
