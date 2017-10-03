package ch6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Eli on 10/2/2017.
 */
public class HowManyFibs {
    static ArrayList<BigInteger> fibNums = new ArrayList<>();

    static void fibs(BigInteger a, BigInteger b){
        fibNums.add(a);

        if(a.compareTo(BigInteger.valueOf(10).pow(100)) != 1){ // a is not greater than 10^100
            fibs(b, a.add(b));
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger int1, int2;

        fibs(BigInteger.ONE, new BigInteger("2"));
        while(scanner.hasNext()){
            int1 = scanner.nextBigInteger();
            int2 = scanner.nextBigInteger();

            if(int1.compareTo(BigInteger.ZERO) == 0  && int2.compareTo(BigInteger.ZERO) == 0){
                break;
            }
            int indexOfFib = 0;
            for(BigInteger el : fibNums){
                if(el.compareTo(int1) != -1){
                    indexOfFib = fibNums.indexOf(el);
                    break;
                }
            }
            int count = 0;
            while(fibNums.get(indexOfFib).compareTo(int2) != 1){
                count++;
                indexOfFib++;
            }
            System.out.println(count);
        }
    }
}
