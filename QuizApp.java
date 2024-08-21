import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static final int TIME_LIMIT = 10;  // Time limit in seconds per question
    private static int currentQuestionIndex = 0;
    private static int score = 0;
    private static boolean answerSubmitted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid"},
            {"What is the largest planet in our solar system?", "Earth", "Mars", "Jupiter", "Saturn"},
            {"Who wrote 'Hamlet'?", "Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"},
            {"Which element has the chemical symbol 'O'?", "Oxygen", "Gold", "Hydrogen", "Iron"}
        };

        int[] correctAnswers = {1, 3, 2, 1};  // Correct options (1-based index)

        System.out.println("Welcome to the Quiz!");
        
        for (currentQuestionIndex = 0; currentQuestionIndex < questions.length; currentQuestionIndex++) {
            displayQuestion(scanner, questions[currentQuestionIndex], correctAnswers[currentQuestionIndex]);
        }

        displayResult(questions.length);
        scanner.close();
    }

    private static void displayQuestion(Scanner scanner, String[] question, int correctAnswer) {
        System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + question[0]);

        for (int i = 1; i < question.length; i++) {
            System.out.println(i + ": " + question[i]);
        }

        Timer timer = new Timer();
        answerSubmitted = false;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!answerSubmitted) {
                    System.out.println("\nTime's up!");
                    timer.cancel();
                    return;
                }
            }
        };

        timer.schedule(task, TIME_LIMIT * 1000);

        System.out.print("Your answer (1-" + (question.length - 1) + "): ");
        int userAnswer = scanner.nextInt();
        answerSubmitted = true;
        timer.cancel();

        if (userAnswer == correctAnswer) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was " + correctAnswer + ": " + question[correctAnswer]);
        }
    }

    private static void displayResult(int totalQuestions) {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + " out of " + totalQuestions);
    }
}
