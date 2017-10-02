package ch2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JollyJumpers {

    public static boolean isJolly(ArrayList<Integer> vals, ArrayList<Integer> validVals){
        for (int val: vals) {
            if(!validVals.contains(val)){
                return false;
            }
        }
        for(int val: validVals){
            if(!vals.contains(val))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        StringTokenizer tokenizer;
        while((scanner.hasNext())) {
            tokenizer = new StringTokenizer(scanner.nextLine());
            int n = -1;
            if(tokenizer.hasMoreElements()) {
                n = Integer.parseInt(tokenizer.nextToken());
            }

            ArrayList<Integer> jolly = new ArrayList<>(n);
            ArrayList<Integer> diff = new ArrayList<>(n-1);
            ArrayList<Integer> vals = new ArrayList<>(n-1);

            for (int i = 0; i < n; i++) {
                Integer val = Integer.parseInt(tokenizer.nextToken());
                jolly.add(i, val);
                //System.out.println(jolly);
            }
            for(int i = 0; i < n-1; i++){
                diff.add(i, Math.abs(jolly.get(i)-jolly.get(i+1)));
                //System.out.println(diff);
            }
            for(int i = 0; i < n-1; i++){
                vals.add(i,i+1);
            }

            if(isJolly(diff, vals))
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");

        }
        System.exit(0);
    }
}
