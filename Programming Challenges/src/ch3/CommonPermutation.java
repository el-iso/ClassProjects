package ch3;

import java.util.Scanner;

public class CommonPermutation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true){
            if(!scanner.hasNextLine())
                break;

            StringBuilder sb = new StringBuilder();
            boolean empty = false;
            //ArrayList<Character> visited = new ArrayList<>();
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int[] arrA = new int[26];
            int[] arrB = new int[26];
            int[] arrC = new int[26];
//            if(a.equals("") && b.equals("")){
//                break;
//            }
//            if(a.equals("") || b.equals("")){
//                empty = true;
//            }
//            if(!empty) {
                for(char c : a.toCharArray()){
                    int index = c - 'a';
                    arrA[index]++;
                }
                for(char c : b.toCharArray()){
                    int index = c - 'a';
                    arrB[index]++;
                }
                for(int i = 0; i <26; i ++){
                    arrC[i] = Math.min(arrA[i], arrB[i]);
                }

                for(int i = 0; i <26; i++){
                    for(int j = 0; j<arrC[i]; j++){
                        sb.append((char)(i+97));
                    }
                }
                System.out.println(sb.toString());
//            }
//            else{
//                System.out.println();
//            }

            if(!scanner.hasNextLine())
                break;
        }
    }
}
