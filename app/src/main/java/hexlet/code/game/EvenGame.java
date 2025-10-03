package hexlet.code.game;

import hexlet.code.greet.Greeting;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final int ROUNDS_TO_WIN = 3;
    private static final Random random = new Random();

    public static void play(Scanner scanner) {
        int correctAnswers = 0;
        String name = Greeting.greetPlayerAndReturnName(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (correctAnswers < ROUNDS_TO_WIN) {
            int number = askQuestionAndReturnNumber();

            String answer = scanner.nextLine();
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (validatePlayersAnswer(answer, correctAnswer, name)) {
                correctAnswers++;
            } else {
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static int askQuestionAndReturnNumber() {
        int number = random.nextInt(100); // random number from 0 to 99
        System.out.println("Question: " + number);
        return number;
    }

    private static boolean validatePlayersAnswer(String answer, String correctAnswer, String playerName) {
        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            return false;
        }
    }
}
