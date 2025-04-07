import java.util.Scanner;


public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine().trim();


        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();

                pipe.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        }
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value;
        do {
            value = getInt(pipe, prompt + " [" + low + " - " + high + "]");
            if (value < low || value > high) {
                System.out.println("Input out of range. Try again.");
            }
        } while (value < low || value > high);
        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value;
        do {
            value = getDouble(pipe, prompt + " [" + low + " - " + high + "]");
            if (value < low || value > high) {
                System.out.println("Input out of range. Try again.");
            }
        } while (value < low || value > high);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");

            response = pipe.nextLine().trim().toLowerCase();

            if (response.equals("y")) return true;
            if (response.equals("n")) return false;


            System.out.println("Invalid input. Please enter Y or N.");
        } while (true);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        do {
            System.out.print("\n" + prompt + ": ");

            response = pipe.nextLine();
            if (response.matches(regEx)) return response;
            System.out.println("Invalid input. Does not match pattern. Try again.");
        } while (true);
    }
    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        int msgLength = msg.length();
        int padding = (WIDTH - msgLength - 6) / 2;

        System.out.println("*".repeat(WIDTH));
        System.out.println("***" + " ".repeat(padding) + msg + " ".repeat(WIDTH - msgLength - 6 - padding) + "***");
        System.out.println("*".repeat(WIDTH));
    }
}








//pretty header


