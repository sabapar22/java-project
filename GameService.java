package com.ecoquest.services;

import com.ecoquest.models.Activity;
import com.ecoquest.utils.ConsoleLooks;
import java.util.ArrayList;
import java.util.List;

// this file is for control and making a Game like environment :))
public class GameService {
    private String currentUser;
    private List<String> activityLog;

    public GameService(String user) {
        this.currentUser = user;
        loadData();
    }
    private void loadData() {
        activityLog = FileService.readFromFile(currentUser + "_log.txt");
    }
    public void addActivity(Activity a) {
        activityLog.add(a.toCSV());
        FileService.saveToFile(currentUser + "_log.txt", a.toCSV(), true);
        ConsoleLooks.printSuccess("Successfully Added New XP!! ENJOY!" + a.getXpPoints());
    }
    public void viewStats() {
        int totalXP = 0;
        ConsoleLooks.printHeader("Your Eco-Journal");
        if(activityLog.isEmpty()) System.out.println("No activities yet.");
        
        for (String line : activityLog) {
            String[] parts = line.split(",");
            System.out.println("ID: " + parts[0].substring(8) + " | " + parts[1] + " | " + parts[2] + " XP");
            totalXP += Integer.parseInt(parts[2]);
        }
        System.out.println("\n>> TOTAL SCORE: " + totalXP);
        System.out.println(">> STATUS: " + (totalXP > 0 ? "Eco-Hero" : "Polluter"));
    }
    public void deleteActivity(String partialId) {
        boolean found = false;
        List<String> newList = new ArrayList<>();
        for (String line : activityLog) {
            if (line.split(",")[0].contains(partialId)) {
                found = true;
                continue;
            }
            newList.add(line);
        }
        if (found) {
            activityLog = newList;
            FileService.clearFile(currentUser + "_log.txt");
            for (String line : newList) {
                FileService.saveToFile(currentUser + "_log.txt", line, true);
            }
            ConsoleLooks.printSuccess("Entry deleted.");
        } else {
            ConsoleLooks.printError("ID not found.");
        }
    }
}