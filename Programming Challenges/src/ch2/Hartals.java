package ch2;

import java.util.Scanner;

public class Hartals {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int numTests;
        boolean start = false;
        while(s.hasNext()){
            if(!start){
                numTests = s.nextInt();
                start = true;
            }

            //get info for individual test
            int days = s.nextInt();
            int parties = s.nextInt();
            int[] hartals = new int[parties];
            for(int i=0; i <parties; i++){
                hartals[i] = s.nextInt();
            }

            String[] trial = new String[days];
            //set friday and saturday to X
            for(int i = 5; i < days; i+=7){
                trial[i] = "X";
            }
            for(int i = 6; i < days; i+=7){
                trial[i] = "X";
            }

            //set hartal days for each party
            for(int hart: hartals){
                for(int i = hart; i <= trial.length; i += hart){
                    if(trial[i-1] != "X")
                        trial[i-1] = "S";
                }
            }
            int daysEffected=0;
            for(String day: trial){
                if(day =="S"){
                    daysEffected++;
                }
            }
            System.out.println(daysEffected);
        }
    }
}
