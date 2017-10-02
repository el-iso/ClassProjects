package ch4;

import java.util.Arrays;
import java.util.Scanner;

public class StacksOfFlapjacks {

    private static void flip(int[] stack, int pos){
        int[] newArr = new int[pos+1]; //size of array for just flipped elements
        for(int i = 0; i <= pos; i++){
            newArr[i] = stack[pos-i];
        }
        System.arraycopy(newArr, 0, stack, 0, newArr.length);
    }
    private static int getMaxPos(int[] stack, int currentPos){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < currentPos; i++){
            max = Math.max(max, stack[i]);
            if(max == stack[i]) {
                maxIndex = i;
            }
        }
        if(maxIndex == -1){
            throw new IllegalArgumentException("Index Cannot Be Negative");
        }
        return maxIndex;
    }

    private static boolean isSorted(int[] stack){
        for(int i = 0; i < stack.length -1; i++){
            if(stack[i] > stack[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){

            String line = scanner.nextLine();
            if(line.equals("")){
                break;
            }
            String[] stringStack = line.split(" ");
            int[] stack = new int[stringStack.length]; //int array representation of stack of flapjacks

            for(int i = 0; i < stringStack.length; i++){
                stack[i] = Integer.parseInt(stringStack[i]);
            }

            int range = stack.length;
            StringBuilder sb = new StringBuilder();
            while(range != 1){
                if(isSorted(stack)){
                    break;
                }
                int maxPos = getMaxPos(stack, range);
                if(maxPos != 0){
                    flip(stack, maxPos);
                    sb.append(Math.abs(maxPos-stack.length) + " ");
                    flip(stack, range-1);
                    sb.append(Math.abs(range-1 - stack.length) + " ");
                    range = range - 1;
                }
                else{
                    flip(stack, range - 1);
                    sb.append(Math.abs(range-1 - stack.length) + " ");
                    range = range - 1;
                }
            }
            sb.append("0");
            System.out.println(line);
            System.out.println(sb.toString());
            //System.out.println(Arrays.toString(stack));
        }


    }
}
