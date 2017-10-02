package ch5;

import java.util.Scanner;

public class Ones {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line;
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            int testVal = 1;
            int numberOnes = 1;
            int number = 0;
            try {
                number = Integer.parseInt(line);
            }
            catch(Exception e){
                System.exit(0);
            }
            while(testVal != 0){
                if(number > testVal){
                    numberOnes++;
                    testVal = testVal*10 +1;
                }
                else{
                    testVal = testVal % number;
                }
            }
            System.out.println(numberOnes);
        }
        System.exit(0);
    }
}
