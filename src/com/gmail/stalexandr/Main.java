package com.gmail.stalexandr;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String smsText;
    private static int messSize;

    private static void inData(Scanner scanner) {
        System.out.print("Enter text os SMS: ");
        try {
            do {
                smsText = scanner.nextLine();
                if (smsText.isEmpty() || smsText.length() > 500) {
                    System.out.println("Text limit exceeded!");
                    continue;
                }
                break;
            } while (true);
            System.out.println("Enter size of SMS: ");
            do {
                messSize = scanner.nextInt();
                if (messSize == 0 || messSize > 500) {
                    System.out.println("Incorrect size of SMS!");
                    continue;
                }
                break;
            } while (true);
        } finally {
            scanner.close();
        }
    }

    private static int smsCount (String text, int messSize) {

        int numOfSMS = 0;
        int last;
        String smsStr = text.trim();
        while (true) {
            if (smsStr.length() <= messSize){
                numOfSMS++;
                break;
            }
            last = smsStr.substring(0, messSize).lastIndexOf(" ");
            if (last == -1) {
                System.err.println("Word to big for send!");
                return -1;
            }
            numOfSMS++;
            smsStr = smsStr.substring(last + 1);
        }
        return numOfSMS;
    }

    public static void main(String[] args) {

        inData(scanner);
        System.out.println(smsCount(smsText, messSize));



}
}
