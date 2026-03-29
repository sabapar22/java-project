package com.ecoquest.models;

// everyone should do workout
// this file gives xp for logging workout sessions
public class Workout extends Activity {
    public Workout(int minutes, String type) {
        super("Workout: " + type + " (" + minutes + " mins)", (int)(minutes / 10)); 
    }
    @Override
    public String getDetails() {
        return "[HEALTH] " + description + " | Gain: +" + xpPoints + " XP";
    }
}