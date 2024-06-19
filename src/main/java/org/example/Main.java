package org.example;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    private static UserData userData = UserData
            .getUserDataInstance();
    public static void main(String[] args) {
        User user;
        Console console = System.console();
        String username;
        char[] password;

        if (console == null) {
            System.err.format(ConsoleColors.RED.getCode() + "No console.");
            System.exit(1);
        }


        clearScreen();

        System.out.println(userData.getUsers());
        while (true) {
            System.out.println();
            System.out.print("Enter your username: " + ConsoleColors.GREEN.getCode());
            username = console.readLine();
            password = console.readPassword(ConsoleColors.RESET.getCode() + "Enter your password: ");
            user = verify(username, password);

            if (user == null) {
                System.out.print(ConsoleColors.RED.getCode() + "Sorry, Incorrect information." + ConsoleColors.RESET.getCode());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.print("something wrong");
                }
                clearScreen();
                continue;
            }
            System.out.println(ConsoleColors.GREEN.getCode() + "You logged in successfully." + ConsoleColors.RESET.getCode());
            System.out.println(ConsoleColors.GREEN.getCode() + "GoodBye." + ConsoleColors.RESET.getCode());
            System.exit(0);
        }
    }

    private static User verify(String username, char[] password) {
        User user = userData.getUsers().get(username);
        if (user == null) {
            return null;
        }

        if (! Arrays.equals(user.getPassword().toCharArray(), password)) {
            int count = user.getWrongPassword();
            user.setWrongPassword(++count);
            if (count == 3) {
                countExceeds();
            }
            if (count > 4) {
                System.out.println("you have been blocked");
                System.exit(1);
            }
            return null;
        }

        return user;
    }

    private static void countExceeds() {
        for (int i =30; i >= 0; i--) {
            System.out.format("\rSorry you entered password wrong more than 3 times wait: "
                    + ConsoleColors.RED.getCode() + "%2d" + ConsoleColors.RESET.getCode(), i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("error");
            }
        }
        clearScreen();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}