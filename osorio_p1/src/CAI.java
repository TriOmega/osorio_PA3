import java.util.Random;
import java.util.Scanner;

public class CAI {
    private static double genRandAddQuestion(int randValue1, int randValue2) {
        double addAnswer;

        System.out.printf("How much is %d plus %d?\nInput Answer Below:\n", randValue1, randValue2);
        addAnswer = (double) (randValue1 + randValue2);
        return addAnswer;
    }

    private static double genRandMultQuestion(int randValue1, int randValue2) {
        double multAnswer;

        System.out.printf("How much is %d times %d?\nInput Answer Below:\n", randValue1, randValue2);
        multAnswer = (double) (randValue1 * randValue2);
        return multAnswer;
    }

    private static double genRandSubQuestion(int randValue1, int randValue2) {
        double subAnswer;

        System.out.printf("How much is %d minus %d?\nInput Answer Below:\n", randValue1, randValue2);
        subAnswer = (double) (randValue1 - randValue2);
        return subAnswer;
    }

    private static double genRandDivQuestion(int randValue1, int randValue2) {
        double divAnswer;

        System.out.printf("How much is %d divided by %d?\nInput Answer Below:\n", randValue1, randValue2);
        divAnswer = (((double) randValue1) / ((double) randValue2));
        return divAnswer;
    }

    private static double genRandMixedQuestion(int randValue1, int randValue2, Random rand) {
        int problemType = ((rand.nextInt(4)) + 1);
        double mixedAnswer = -1;

        switch (problemType) {
            case 1:
                mixedAnswer = genRandAddQuestion(randValue1, randValue2);
                break;
            case 2:
                mixedAnswer = genRandMultQuestion(randValue1, randValue2);
                break;
            case 3:
                mixedAnswer = genRandSubQuestion(randValue1, randValue2);
                break;
            case 4:
                mixedAnswer = genRandDivQuestion(randValue1, randValue2);
                break;
            default:
                System.out.println("Error w/ problemType in Mixed genRanQuestion switch case.");
                break;
        }
        return mixedAnswer;
    }

    private static int getProblemType(Scanner scnr) {
        int chosenProblemType;

        System.out.println("What problem type would you like?");
        System.out.println("Enter the number next to the options below:");
        System.out.println("1 | Addition questions.");
        System.out.println("2 | Multiplication questions.");
        System.out.println("3 | Subtraction questions.");
        System.out.println("4 | Division questions.");
        System.out.println("5 | Mix of all types of questions.");
        System.out.print("I want option: ");
        chosenProblemType = scnr.nextInt();
        while (!(chosenProblemType >= 1 && chosenProblemType <= 5)) {
            System.out.println("Invalid response. Please try again.");
            chosenProblemType = scnr.nextInt();
        }
        System.out.println("");
        return chosenProblemType;
    }

    private static int getLowerBound(int scaleMultiplier) {
        double lowerBound;

        if (scaleMultiplier == 1) {
            lowerBound = 1.0;
        } else {
            lowerBound = Math.pow(10.0, ((double) (scaleMultiplier - 1)));
        }
        return (int) lowerBound;
    }

    private static int getUpperBound(int scaleMultiplier) {
        double upperBound;

        upperBound = Math.pow(10.0, ((double) scaleMultiplier));
        return (int) upperBound;
    }

    private static int getDifficultyLevel(Scanner scnr) {
        int chosenLevel;

        System.out.println("What difficulty level would you like?");
        System.out.println("Enter the number next to the options below:");
        System.out.println("1 | Questions use only single digit numbers.");
        System.out.println("2 | Questions use only double digit numbers.");
        System.out.println("3 | Questions use only triple digit numbers.");
        System.out.println("4 | Questions use only quadruple digit numbers.");
        System.out.print("I want difficulty: ");
        chosenLevel = scnr.nextInt();
        while (!(chosenLevel >= 1 && chosenLevel <= 4)) {
            System.out.println("Invalid response. Please try again.");
            chosenLevel = scnr.nextInt();
        }
        System.out.println("");
        return chosenLevel;
    }

    private static void sessionReport(int correctResponseCount) {
        double userScore;

        System.out.println("");
        System.out.println("Questions Correct: " + correctResponseCount);
        System.out.println("Questions Wrong: " + (10 - correctResponseCount));
        userScore = (((double) correctResponseCount) / 10);
        System.out.printf("Score: %.1f%%\n", (userScore * 100));
        if (userScore < 0.75) {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("");
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    private static String generateCorrectAnswerReponse() {
        Random rand = new Random();
        int responseNum = rand.nextInt(4);
        String response;

        switch (responseNum) {
            case 0:
                response = "Very good!";
                break;
            case 1:
                response = "Excellent!";
                break;
            case 2:
                response = "Nice work!";
                break;
            case 3:
                response = "Keep up the good work!";
                break;
            default:
                response = "Error w/ correctAnswer switch case.";
                break;
        }
        return response;
    }

    private static String generateWrongAnswerReponse() {
        Random rand = new Random();
        int responseNum = rand.nextInt(4);
        String response;

        switch (responseNum) {
            case 0:
                response = "No. Please try again.";
                break;
            case 1:
                response = "Wrong. Try once more.";
                break;
            case 2:
                response = "Don't give up!";
                break;
            case 3:
                response = "No. Keep trying.";
                break;
            default:
                response = "Error w/ wrongAnswer switch case.";
                break;
        }
        return response;
    }

    private static double generateRandomQuestion(int integerDigitSize, int problemType) {
        Random rand = new Random();
        int upperBound, lowerBound, randomValue1, randomValue2;
        double answer = -1.0;

        lowerBound = getLowerBound(integerDigitSize);
        upperBound = getUpperBound(integerDigitSize);
        randomValue1 = (rand.nextInt(upperBound - lowerBound)) + lowerBound;
        randomValue2 = (rand.nextInt(upperBound - lowerBound)) + lowerBound;
        switch (problemType) {
            case 1:
                answer = genRandAddQuestion(randomValue1, randomValue2);
                break;
            case 2:
                answer = genRandMultQuestion(randomValue1, randomValue2);
                break;
            case 3:
                answer = genRandSubQuestion(randomValue1, randomValue2);
                break;
            case 4:
                answer = genRandDivQuestion(randomValue1, randomValue2);
                break;
            case 5:
                answer = genRandMixedQuestion(randomValue1, randomValue2, rand);
                break;
            default:
                System.out.println("Error w/ problemType in generic genRanQuestion switch case.");
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean startNewSession = true;
        int i, correctResponseCount, difficultyLevel, problemType;
        double userInput, problemAnswer;

        while (startNewSession) {
            difficultyLevel = getDifficultyLevel(scnr);
            problemType = getProblemType(scnr);
            correctResponseCount = 0;
            for (i = 0; i < 10; i++) {
                problemAnswer = generateRandomQuestion(difficultyLevel, problemType);
                userInput = scnr.nextDouble();
                if (Math.abs(userInput - problemAnswer) < 0.0001) {
                    System.out.println(generateCorrectAnswerReponse());
                    correctResponseCount++;
                } else {
                    System.out.println(generateWrongAnswerReponse());
                }
                System.out.println("");
            }
            sessionReport(correctResponseCount);
            System.out.println("Would you like to start a new session? (Type true or false)");
            startNewSession = scnr.nextBoolean();
        }
    }
}
