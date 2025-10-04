package hexlet.code;

import hexlet.code.greeting.Greeting;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class Engine {
    public static final int ROUNDS_TO_WIN = 3;

    private Engine() {
    }

    public static void play(Scanner scanner,
                            String question,
                            Supplier<String> generateQuestion,
                            UnaryOperator<String> calculateCorrectAnswer) {
        int round = 0;
        String name = Greeting.greetPlayerAndReturnName(scanner);
        System.out.println(question);

        while (round < ROUNDS_TO_WIN) {
            String generatedQuestion = generateQuestion.get();
            String correctAnswer = calculateCorrectAnswer.apply(generatedQuestion);

            System.out.println("Question: " + generatedQuestion);
            String answer = scanner.nextLine();

            if (validatePlayersAnswer(answer, correctAnswer, name)) {
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
