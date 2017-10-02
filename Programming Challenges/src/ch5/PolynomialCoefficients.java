package ch5;

import java.util.Scanner;

public class PolynomialCoefficients {

    private static String reverse(String number){
        StringBuilder sb = new StringBuilder();
        for( int i = 1; i <= number.length(); i++){
            sb.append(number.charAt(number.length() - i));
        }
        return sb.toString();
    }
    private static boolean isPalindrome(String number){
        String reverse = reverse(number);
        if(number.equals(reverse))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numInputs = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numInputs; i++) {
            long result = 0;
            int count = 0;
            String number = scanner.nextLine();
            String reverse = reverse(number);
            do {
                result = Long.parseLong(number) + Long.parseLong(reverse);
                number = Long.toString(result);
                reverse = reverse(Long.toString(result));
                count++;
            }
            while (!reverse.equals((Long.toString(result))));
            System.out.println(count + " " + result);
        }
    }
}
