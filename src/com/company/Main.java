package com.company;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String getPath(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter path: ");
        String path = input.nextLine();
        return path;
    }
    public static void displayMenu(int[] options, String[] menuFunction) {
        //Display Menu
        System.out.println("*******\tM E N U\t*******");
        System.out.println("---------------------------------------");
        //Loop through the Menu Functions
        for (int i = 0; i < options.length; i++) {
            System.out.printf("\n%d. %s", options[i], menuFunction[i]);
        }
        System.out.println("\n---------------------------------------");
        System.out.print("Please enter choice: ");
    }

    public static void displayDirectory() {
        String path = getPath();

        File dir = new File(path);
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            System.out.println(f.getName());
        }

    }

    public static void displayFile() {

        String fileName = getPath();

        FileInputStream file;
        try {
            file = new FileInputStream(fileName);
            showFileContent(file);
        } catch (FileNotFoundException e) {
            //TODO: handle this
        }

    }

    public static void showFileContent(InputStream file) {
        BufferedReader fileOpen = new BufferedReader(
                new InputStreamReader(file));

        System.out.println("Here's your file:\r\n");

        String urlString = "";
        String current = "";

        while(true) {
            try {
                if (!((current = fileOpen.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            urlString += current;
        }
        System.out.println(urlString);
    }

    public static void displayWeb() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String uri = input.nextLine();

        try {
            URL url = new URL(uri);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            }else {
                System.out.println("Please enter an HTTP URL.");
                return;
            }

            showFileContent(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readInput(){

        System.out.println("Enter a website address: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void main(String[] args) {

        //Declaring Scanner
        Scanner input = new Scanner(System.in);

        // Data of the Menu
        int[] options = {1, 2, 3, 4};
        String[] menuFunctions = {"List folders and files in a directory", "Display the contents of a file on screen", "Display HTML Response for a Web Address", "Exit Application"};

        //Exit Condition
        int EXIT = options[options.length - 1]; //Assume the last index will be how to exit programme


        //display the menu
        displayMenu(options, menuFunctions);

        //Getting input from the user
        int choice = input.nextInt();

        while (choice != EXIT) {

            //User's choice
            if (choice == options[0]) {
                System.out.println(menuFunctions[0]);
                displayDirectory();
            } else if (choice == options[1]) {
                System.out.println(menuFunctions[1]);
                displayFile();
            } else if (choice == options[2]) {
                System.out.println(menuFunctions[2]);
                displayWeb();
            }

            //display the menu
            displayMenu(options, menuFunctions);

            //TODO: Add Exception handling for out of bounds option
            choice = input.nextInt();
        }
        System.out.println("You have ended the programme. Have a good day!");
    }
}