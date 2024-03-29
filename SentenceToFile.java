import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SentenceToFile {
    public static void main(String[] args) {
        // Prompting the user to enter a sentence
        System.out.println("Please enter a sentence:");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        scanner.close();

        // Writing the sentence to a file named "output.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(sentence);
            System.out.println("Sentence successfully written to output.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
