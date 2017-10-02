package ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VitosFamily {

    private static int totalDistance(ArrayList<Integer> family, int vito){

        int totalDistance = 0;
        for( int val : family ){
            totalDistance += Math.abs(val - vito);
        }
        //System.out.println(totalDistance);
        return totalDistance;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] family;
        int numCases = scanner.nextInt();
        scanner.nextLine();
        int count = 0;

        while(count < numCases){
            String line = scanner.nextLine();
            Scanner famLine = new Scanner(line);

            int familyMembers = famLine.nextInt();
            family = new int[familyMembers];
            for(int i = 0; i < familyMembers; i++){
                family[i] = famLine.nextInt();
            }

            Arrays.sort(family);
            int median = family[family.length / 2];


            int distance=0;
            for(int i = 0; i < family.length; i++){
                distance += Math.abs(family[i] - median);
            }
            System.out.println(distance);
            //System.out.println(family);
            count++;
        }
        System.exit(0);
    }
}
