package com.lab5.greetingapi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetGreetings {
    public static void main(String[] args) {
        System.out.println("Fetching Greetings...\n");

        fetchGreeting("http://localhost:8080/greeting"); // Default greeting
        fetchGreeting("http://localhost:8080/greeting/name?name=Athsara"); // Greeting with name
        fetchGreeting("http://localhost:8080/greeting/today"); // Greeting with today's date
    }

    private static void fetchGreeting(String endpoint) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } else {
                System.out.println("Error: Could not fetch greeting from " + endpoint);
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
