package com.test.creditcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardDetector {
    public static void main(String[] args) {
        String text = "Here is a sample text with a credit card number: 1234-5678-9012-3456. "
                + "Please do not store or display real credit card numbers without proper security measures.";

        // Regular expression to match potential credit card numbers (13 to 16 digits)
        String regex = "\\b(?:\\d[ -]*?){13,16}\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String potentialCreditCardNumber = matcher.group().replaceAll("[ -]", "");
//            if (isValidCreditCardNumber(potentialCreditCardNumber)) {
                System.out.println("Found potential credit card number: " + potentialCreditCardNumber);
//            }
        }
    }

    // Additional validation to check the Luhn algorithm for credit card numbers
    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int num = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (alternate) {
                num *= 2;
                if (num > 9) {
                    num = (num % 10) + 1;
                }
            }
            sum += num;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}

