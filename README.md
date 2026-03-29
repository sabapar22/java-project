# EcoQuest - A Gamified Habit Tracker

## Project Overview
EcoQuest is a simple Java console project I built to make sustainability tracking less boring. Instead of just writing down numbers, this app turns your daily habits into a game. You get "XP" (Experience Points) for doing good things like working out, and you lose XP for doing things that have a high carbon footprint, like driving a car or using your phone too much.

## Features
* **User Login:** You can register and login. Passwords are saved securely (hashed) so they aren't just plain text.
* **Activity Logging:** You can log three types of activities:
    * **Transport:** Driving cars (Reduces XP).
    * **Screen Time:** Using digital devices (Reduces XP).
    * **Workout:** Running or Yoga (Increases XP).
* **Stats & Levels:** The app calculates your total score and tells you if you are an "Eco-Hero" or a "Polluter."
* **Save Data:** Everything is saved to text files in a `data` folder, so you don't lose progress when you close the app.
* **Delete Entries:** If you make a mistake, you can delete a log entry using its ID.

## Technologies Used
* **Language:** Java (JDK)
* **Tools:** VS Code / Notepad++ (for editing), Command Prompt (for running).
* **Concepts:** OOP (Inheritance, Polymorphism), File Handling, Exception Handling.

## How to Install & Run
Since this uses a package structure, you have to run it from the `src` folder.

1.  Open your terminal/command prompt.
2.  Navigate to the `src` folder inside the project:
    ```bash
    cd EcoQuest/src
    ```
3.  Compile all the java files together:
    ```bash
    javac com/ecoquest/utils/*.java com/ecoquest/models/*.java com/ecoquest/services/*.java com/ecoquest/main/*.java
    ```
4.  Run the Main file:
    ```bash
    java com.ecoquest.main.Main
    ```

## Testing
* **Input Test:** Try entering "abc" when the app asks for kilometers. It won't crash; it will just ask you to enter a number again.
* **Data Test:** Register a user, log some data, and exit. Open the app again and login; your data will still be there.
