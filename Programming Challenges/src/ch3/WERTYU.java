package ch3;

import java.util.Scanner;

public class WERTYU {

    public static String keyboard = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        while(s.hasNext()){
            String line = s.nextLine();
            StringBuilder sb = new StringBuilder();

            for(char ch : line.toCharArray()){
                if(ch != ' ') {
                    sb.append(keyboard.charAt(keyboard.indexOf(ch) -1));
                }
                else{
                    sb.append(' ');
                }
            }
            System.out.println(sb.toString());
        }

    }
}
