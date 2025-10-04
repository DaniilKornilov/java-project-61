package hexlet.code;

import hexlet.code.greeting.Greeting;

import java.util.Arrays;
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

        String[] generatedQuestions = generateQuestions(generateQuestion);
        String[] correctAnswers = calculateCorrectAnswers(generatedQuestions, calculateCorrectAnswer);

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

    private static String[] calculateCorrectAnswers(String[] questions,
                                                    UnaryOperator<String> calculateCorrectAnswer) {
        String[] correctAnswers = new String[Engine.ROUNDS_TO_WIN];
        Arrays.setAll(correctAnswers, i -> calculateCorrectAnswer.apply(questions[i]));
        return correctAnswers;
    }

    private static String[] generateQuestions(Supplier<String> generateQuestion) {
        String[] questions = new String[Engine.ROUNDS_TO_WIN];
        Arrays.setAll(questions, i -> generateQuestion.get());
        return questions;
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
