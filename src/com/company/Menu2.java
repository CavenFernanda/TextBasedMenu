package com.company;
import java.util.Scanner;

public class Menu2 {

    public static void displayMenu(int[] options, String[] menuFunction){
        //Display Menu
        System.out.println("*******  M E N U  *******");
        System.out.println("---------------------------------------");
        //Loop through the Menu Functions
        for(int i = 0; i < options.length; i++){
            System.out.printf("\n%d. %s",options[i],menuFunction[i]);
        }
        System.out.println("\n---------------------------------------");
        System.out.print("Please enter choice: ");
    }

    public static void main(String[] args) {

        //Declaring Scanner
        Scanner input = new Scanner(System.in);

        // Data of the Menu
        int[] options = {1,2,3,4};
        String[] menuFunctions = {"List folders and files in a directory","Display the contents of a file on screen","Display HTML Response for a Web Address","Exit Application"};

        //Exit Condition
        int EXIT = options[options.length-1]; //Assume the last index will be how to exit programme


        //display the menu
        displayMenu(options,menuFunctions);

        //Getting input from the user
        int choice = input.nextInt();

        while(choice != EXIT){

            //User's choice
            if (choice == options[0]){
                System.out.println(menuFunctions[0]);
            }
            else if (choice == options[1]){
                System.out.println(menuFunctions[1]);
            }
            else if (choice == options[2]){
                System.out.println(menuFunctions[2]);
            }

            //display the menu
            displayMenu(options,menuFunctions);

            choice = input.nextInt();
        }
        System.out.println("You have ended the programme. Have a good day!");
    }
}