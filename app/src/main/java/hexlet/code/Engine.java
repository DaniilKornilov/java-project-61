package hexlet.code;

import hexlet.code.greet.Greeting;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_TO_WIN = 3;

    public static void play(Scanner scanner, String question, String[] generatedQuestions, String[] correctAnswers) {
        int round = 0;
        String name = Greeting.greetPlayerAndReturnName(scanner);
        System.out.println(question);

        while (round < ROUNDS_TO_WIN) {
            System.out.println("Question: " + generatedQuestions[round]);
            String answer = scanner.nextLine();

            if (validatePlayersAnswer(answer, correctAnswers[round], name)) {
                round++;
            } else {
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
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
