package ch3;

import java.util.ArrayList;
import java.util.Scanner;

public class AutomatedJudgeScript {

    private static boolean isAccepted(ArrayList<String> answer, ArrayList<String> output){
        //System.out.println("isAccepted");
        for(int i = 0; i < answer.size(); i++){
            //System.out.println("accepted loop");
            if(answer.size() == output.size()) {
                String ansLine = answer.get(i);
                String outLine = output.get(i);
                if (ansLine.length() == outLine.length()) {
                    //System.out.println("same length");
                    for (int j = 0; j < ansLine.length(); j++) {
                        if (ansLine.charAt(j) != outLine.charAt(j)) {
                            //System.out.println("return false");
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    private static boolean isPresentationError(ArrayList<String> answer, ArrayList<String> output){
        ArrayList<Character> answerNums = new ArrayList<>();
        ArrayList<Character> outputNums = new ArrayList<>();
        for(String ans : answer){
            for(int i = 0; i < ans.length(); i++){
                if(Character.isDigit(ans.charAt(i)))
                    answerNums.add(ans.charAt(i));
            }
        }
        for(String out : output){
            for(int i = 0; i < out.length(); i++){
                if(Character.isDigit(out.charAt(i)))
                    outputNums.add(out.charAt(i));
            }
        }

        if(answerNums.size() != outputNums.size()){
            return false;
        }
        else{
            for(int i = 0; i < answerNums.size(); i ++){
                if(answerNums.get(i) != outputNums.get(i)){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int ansLength;
        ArrayList<String> answer;
        ArrayList<String> output;
        while(scanner.hasNext()){
            try {
                ansLength = Integer.parseInt(scanner.nextLine());

                //System.out.println(ansLength);
                answer = new ArrayList<>();
                for (int i = 0; i < ansLength; i++) {
                    //System.out.println("in loop");
                    answer.add(scanner.nextLine());
                }
                //System.out.println(answer);
                int outLength = Integer.parseInt(scanner.nextLine());
                output = new ArrayList<>();
                for (int i = 0; i < outLength; i++) {
                    output.add(scanner.nextLine());
                }
            }
            catch(Exception e){
                break;
            }
            //System.out.println(output);
            if(isAccepted(answer, output)){
                System.out.println("Run #" + count + ": Accepted");
            }
            else if(isPresentationError(answer, output)){
                System.out.println("Run #" + count + ": Presentation Error");
            }
            else{
                System.out.println("Run #" + count + ": Wrong Answer");
            }

            count++;
        }
        System.exit(0);
    }
}
