package ch6;

import java.math.BigInteger;
import java.util.Scanner;

public class PiecesOfLand {


    public static void main(String[] args){

        BigInteger[] a = new BigInteger[2147483647];
        a[0] = BigInteger.valueOf(1);
        a[1] = BigInteger.valueOf(1);
        a[2] = BigInteger.valueOf(2);
        a[3] = BigInteger.valueOf(4);
        a[4] = BigInteger.valueOf(8);
        a[5] = BigInteger.valueOf(16);
        a[6] = BigInteger.valueOf(31);
        for(int i = 7; i < a.length; i++){
            a[i] = a[i-1].add(a[i-2]).add(a[i-3]).add(a[i-4]).add(a[i-5]);
        }

        Scanner scanner = new Scanner(System.in);
        int numInputs = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numInputs; i++){
            try {
                int num = Integer.parseInt(scanner.nextLine());

                System.out.println(a[num]);
            }
            catch(Exception e){
                break;
            }
        }

    }

}
