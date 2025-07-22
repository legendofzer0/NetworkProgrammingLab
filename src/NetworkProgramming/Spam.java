package NetworkProgramming;

import java.util.Scanner;

public class Spam {
    public static void main(String[] args) {
        String[] spamKeywords = {
                "win", "free", "offer", "money", "prize", "click here", "urgent"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message:");
        String message = scanner.nextLine().toLowerCase();

        boolean isSpam = false;
        for (String keyword : spamKeywords) {
            if (message.contains(keyword)) {
                isSpam = true;
                System.out.println("Spam keyword found: " + keyword);
            }
        }

        if (isSpam) {
            System.out.println("This message is likely spam.");
        } else {
            System.out.println("This message seems clean.");
        }

        scanner.close();
    }
}
