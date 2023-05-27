package util;

import java.util.Scanner;

/**
 *
 * @author Huynh Van Phuot
 */
public class MyUtils {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String input;
        while (true) {
            System.out.print(inputMsg);
            input = sc.nextLine().trim();
            if (input.length() == 0 || input.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return input;
            }
        }
    }
    
    public static String getStringReg(  String inputMsg, String pattern,
                                        String errorMsg, boolean ignorcaseSpace) {
        boolean tmp = true;
        System.out.print(inputMsg);
        String result;
        do {
            result = sc.nextLine();
            result = result.trim();
            if (!ignorcaseSpace) {
                if (result.isEmpty()) {
                    return result;
                }
            }
            if (result.isEmpty()) {
                System.out.print("The input is not empty!\nPlease re-input: ");
            } else {
                if (result.matches(pattern)) {
                    tmp = false;
                } else {
                    System.out.print(errorMsg + "\nPlease re-input: ");
                }
            }
        } while (tmp == true);
        return result;
    }
}
