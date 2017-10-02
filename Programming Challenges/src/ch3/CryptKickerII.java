package ch3;

import java.util.ArrayList;
import java.util.Scanner;

public class CryptKickerII {
    private static boolean containsAllLetters(String test){
        for(int i = 97; i <= 122; i++){
            if(!test.contains(String.valueOf(Character.toChars(i))))
                return false;
        }
        return true;
    }

    private static String getCode(ArrayList<String> lines, String known){
        for(String option : lines){
            if(option.length() == known.length() && containsAllLetters(option)){
                String[] optionArr = option.split(" ");
                String[] knownArr = known.split(" ");
                if(optionArr.length == knownArr.length){
                    boolean found = true;
                    for(int i = 0; i < optionArr.length; i++){
                        if(optionArr[i].length() != knownArr[i].length()){
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        return option;
                    }
                }
            }
        }
        return "No solution.";
    }

    private static boolean makeMap(Integer[] map, String encoded, String known){
        for(int i = 0; i < known.length(); i++){
            if(encoded.charAt(i) != ' ') {
                int index = encoded.charAt(i) - 'a';
                if (map[index] == null) {
                    map[index] = known.charAt(i) - 'a';
                } else if (map[index] != known.charAt(i) - 'a') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String knownString = "the quick brown fox jumps over the lazy dog";

        int cases = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        int count = 0;
        while(count < cases){
            Integer[] alphabet = new Integer[26];

            ArrayList<String> lines = new ArrayList<>();
            String line;
            try {
                while (!(line = scanner.nextLine()).isEmpty()) {
                    //System.out.println(line);
                    lines.add(line);
                }
            }
            catch(Exception e){
                break;
            }

            String qbfEn = getCode(lines, knownString);
            if(qbfEn.equals("No solution.")){
                System.out.println(qbfEn);
                System.out.println();
            }
            else{
                boolean validEncoding = makeMap(alphabet, qbfEn, knownString);
                if(!validEncoding){
                    System.out.println("No solution.");
                    System.out.println();
                }
                else{
                    StringBuilder sb;
                    ArrayList<String> decoded = new ArrayList<>();

                    for(String el : lines){
                        sb = new StringBuilder();
                        for(int i = 0; i < el.length(); i++){
                            if(el.charAt(i) != ' ')
                                sb.append(Character.toChars(alphabet[el.charAt(i)-'a'] + 'a'));
                            else
                                sb.append(' ');
                        }
                        decoded.add(sb.toString());
                    }
                    for (String el : decoded) {
                        System.out.println(el);
                    }
                    System.out.println();
                }
            }
            count++;
        }
    }
}
