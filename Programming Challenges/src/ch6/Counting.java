package ch6;

import java.math.BigInteger;
import java.util.Scanner;

public class Counting {

    public static void main(String[] args){

        BigInteger[] a = new BigInteger[1001];
        a[0] = BigInteger.valueOf(1);
        a[1] = BigInteger.valueOf(2);
        a[2] = BigInteger.valueOf(5);
        a[3] = BigInteger.valueOf(13);
        for(int i = 4; i < 1001; i++){
            a[i] = a[i-1].add(a[i-1]).add(a[i-2]).add(a[i-3]);
        }

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
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
