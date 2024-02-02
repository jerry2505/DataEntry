package in.ajay.AnnieProject;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class calc {
	
	private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertNumberToWords(double number) {
        long wholePart = (long) number;
        int decimalPart = (int) ((number - wholePart) * 100);

        String words = convertToWords(wholePart) + " point " + convertToWords(decimalPart);
        return words;
    }

    private static String convertToWords(long number) {
        if (number == 0) {
            return "Zero";
        }

        if (number < 0) {
            return "Minus " + convertToWords(-number);
        }

        String words = "";

        if ((number / 1000000000) > 0) {
            words += convertToWords(number / 1000000000) + " Billion ";
            number %= 1000000000;
        }

        if ((number / 1000000) > 0) {
            words += convertToWords(number / 1000000) + " Million ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += convertToWords(number / 1000) + " Thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) {
            words += convertToWords(number / 100) + " Hundred ";
            number %= 100;
        }

        if (number > 0) {
            if (number < 10) {
                words += units[(int) number];
            } else if (number < 20) {
                words += teens[(int) (number % 10)];
            } else {
                words += tens[(int) (number / 10)] + " " + units[(int) (number % 10)];
            }
        }

        return words.trim();
    }

    public static void main(String[] args) {
        double number = 56.66;
        String words = convertNumberToWords(number);
        System.out.println(number + " in words: " + words);
    }
}
