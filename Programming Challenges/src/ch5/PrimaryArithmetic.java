package ch5;

import java.util.Arrays;
import java.util.Scanner;

public class PrimaryArithmetic {

    private static String reverse(String number){
        StringBuilder sb = new StringBuilder();
        for( int i = 1; i <= number.length(); i++){
            sb.append(number.charAt(number.length() - i));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line;

        while(!(line = scanner.nextLine()).equals("0 0")){
            Scanner lineScanner = new Scanner(line);
            String num1 = reverse(Integer.toString(lineScanner.nextInt()));
            String num2 = reverse(Integer.toString(lineScanner.nextInt()));
            int[] arr1 = new int[9];
            int[] arr2 = new int[9];

            for(int i = 0; i < num1.length(); i++){
                arr1[8 - i] = Integer.parseInt(Character.toString(num1.charAt(i)));
            }
            for(int i = 0; i < num2.length(); i++){
                arr2[8 - i] = Integer.parseInt(Character.toString(num2.charAt(i)));
            }
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));

            int carry = 0;
            for(int i = arr1.length-1; i >= 0; i--){
                int val = arr1[i] + arr2[i];
                if(val >=10 && i > 0){
                    carry++;
                    arr1[i-1]++;
                }
                else if(val >= 10 && i==0) {
                    carry++;
                }
            }
            if(carry ==0){
                System.out.println("No carry operation.");
            }
            else if(carry==1){
                System.out.println("1 carry operation.");
            }
            else{
                System.out.println(carry + " carry operations.");
            }
        }

    }
}
