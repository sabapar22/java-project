package com.ecoquest.main;

import com.ecoquest.services.AuthService;
import com.ecoquest.services.GameService;
import com.ecoquest.models.ScreenTIme;
import com.ecoquest.models.VehicleUsage;
import com.ecoquest.models.Workout;
import com.ecoquest.utils.ConsoleLooks;
import java.util.Scanner;

// WELCOME TO THE MAIN FILE OF THE PROJECT
// project is now completed by saba parveen
// this was created for the purpose of university course completion
public class Main {
    private static Scanner scn = new Scanner(System.in);
    private static AuthService auth = new AuthService();

    public static void main(String[] args) {
        ConsoleLooks.printHeader("Welcome to EcoQuest (Made by saba parveen)");       
        String loggedInUser = null;
        while (loggedInUser == null) {
            ConsoleLooks.printMenu("Login", "Register", "Exit");
            int choice = scn.nextInt();
            scn.nextLine();

            if (choice == 3) System.exit(0);
            System.out.print("Username => ");
            String user = scn.nextLine();
            System.out.print("Password => ");
            String pass = scn.nextLine();
            if (choice == 1) {
                if (auth.login(user, pass)) {
                    loggedInUser = user;
                    ConsoleLooks.printSuccess("Login Successful!");
                } else ConsoleLooks.printError("Invalid Credentials.");
            } else if (choice == 2) {
                if (auth.register(user, pass)) ConsoleLooks.printSuccess("Registered! Now Login.");
            }
        }
        GameService game = new GameService(loggedInUser);
        while (true) {
            ConsoleLooks.printHeader("Main Menu");
            ConsoleLooks.printMenu(
                "Log Car Ride (Reduce XP)", 
                "Log Workout (Increase XP)",
                "Log Screen Time (Reduce XP)",     
                "View Stats & History", 
                "Delete an Entry", 
                "Logout"
            );
            int choice = scn.nextInt();
            try {
                switch (choice) {
                case 1:
                    System.out.print("Enter KM driven => ");
                    double km = scn.nextDouble();
                    game.addActivity(new VehicleUsage(km, "Car"));
                    break;
                case 2:
                    System.out.print("Enter workout type (e.g., Running, Yoga): ");
                    String type = scn.next();
                    System.out.print("Enter duration in minutes => ");
                    int mins = scn.nextInt();
                    game.addActivity(new Workout(mins, type)); 
                    break;
                case 3:
                    System.out.print("Enter hours spent on phone => ");
                    double hours = scn.nextDouble();
                    game.addActivity(new ScreenTIme(hours));
                    break;
                case 4:
                    game.viewStats();
                    break;
                case 5:
                    System.out.print("Enter the ID from stats to delete => ");
                    String id = scn.next();
                    game.deleteActivity(id);
                    break;
                case 6:
                    System.out.println("Goodbye, " + loggedInUser + "!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                ConsoleLooks.printError("Invalid input! Please enter a number.");
            } 
        }
    }
}

// thanks for visiting this codes :)