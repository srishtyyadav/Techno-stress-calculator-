import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "I feel pressure to reply to messages immediately.",
            "I find it hard to disconnect from work technology after hours.",
            "New software or updates make me anxious.",
            "Technology has increased my workload.",
            "I feel overwhelmed by the number of digital tools I use."
        };

        int total = 0;
        System.out.println("Rate each statement from 1 to 5.");

        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            int answer = sc.nextInt();

            while (answer < 1 || answer > 5) {
                System.out.println("Enter a number between 1 and 5:");
                answer = sc.nextInt();
            }

            total += answer;
        }

        String level;
        if (total <= 11) {
            level = "Low";
        } else if (total <= 18) {
            level = "Moderate";
        } else {
            level = "High";
        }

        System.out.println("Your total score: " + total + " out of 25");
        System.out.println("Techno-stress level: " + level);

        try {
            FileWriter fw = new FileWriter("results.txt", true);
            fw.write("Score: " + total + "/25, Level: " + level + "\n");
            fw.close();
            System.out.println("Result saved to results.txt");
        } catch (IOException e) {
            System.out.println("Could not save the result.");
        }
    }
}
