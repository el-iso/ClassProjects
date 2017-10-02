package ch3;

import java.util.*;

public class FileFragmentation {

    private static ArrayList<String> cloneList(ArrayList<String> list) {
        ArrayList<String> clone = new ArrayList<>(list.size());
        clone.addAll(list);
        return clone;
    }

    private static boolean checkMatches(String attempt, ArrayList<String> frags){
        int count = 0;
        for (int i = 0; i < frags.size(); i++) {
            for (int j = 0; j < frags.size(); j++) {
                String f = frags.get(i) + frags.get(j);
                String f2 = frags.get(j) + frags.get(i);
                if((i != j) && (f.equals(attempt) || f2.equals(attempt))){
                    frags.set(i, "x");
                    frags.set(j, "x");
                    count += 2;
                    break;
                }
            }
        }
        return count == frags.size();

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        String test = scanner.nextLine();
        scanner.nextLine();
        int count = 0;
        while(count < cases){

            ArrayList<String> frags = new ArrayList<>();
            String line;

            int shortest = Integer.MAX_VALUE;
            int longest = Integer.MIN_VALUE;
            int fileLength;

            try {
                while (!(line = scanner.nextLine()).isEmpty()) {
                    //System.out.println(line);
                    shortest = Math.min(shortest, line.length());
                    longest = Math.max(longest, line.length());
                    frags.add(line);
                }
            }
            catch(Exception e){
                break;
            }
            fileLength = shortest + longest;

            String file = "";
            boolean solutionFound = false;
            for(int i = 0; i < frags.size(); i++){
                for(int j = 0; j < frags.size(); j++){
                    if(i != j) {
                        file = frags.get(i) + frags.get(j);
                        if(file.length() == fileLength) {
                            ArrayList<String> copy = cloneList(frags);

                            solutionFound = checkMatches(file, copy);
                            if(solutionFound){
                                break;
                            }

                        }
                    }
                }
                if(solutionFound){
                    break;
                }
            }
            System.out.println(file);
            System.out.println();
            count++;
        }
        System.exit(0);
    }
}
