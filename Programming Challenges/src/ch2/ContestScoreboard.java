package ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ContestScoreboard {

    static class Contestant implements Comparable<Contestant>{
        int ID;
        int problemsSolved;
        int score;
        boolean updated;

        Contestant(int ID, int problemsSolved, int score){
            this.ID = ID;
            this.problemsSolved = problemsSolved;
            this.score = score;
            this.updated = false;
        }

        void update(JudgeEntry entry){
//            if(this.ID != entry.contestantID)
//                throw new IllegalArgumentException("Wrong Contestant");

            if(entry.judgeStatus =='C'){
                problemsSolved++;
                score += entry.time;
            }
            else if(entry.judgeStatus =='I'){
                score += 20;
            }
        }

        void print(){
            if(updated)
                System.out.println(this.ID + " " + this.problemsSolved + " " + this.score);
        }

        @Override
        public int compareTo(Contestant o) {
            if(this.problemsSolved != o.problemsSolved){
                return o.problemsSolved - this.problemsSolved;
            }
            else if(this.score != o.score){
                return this.score - o.score;
            }
            else{
                return o.ID - this.ID;
            }
        }
    }

    static class JudgeEntry{
        int contestantID;
        int problemNumber; //maybe unneccesary maybe not
        int time;
        char judgeStatus;

        JudgeEntry(int contestantID, int problemNumber, int time, char judgeStatus){
            this.contestantID = contestantID;
            this.problemNumber = problemNumber;
            this.time = time;
            this.judgeStatus = judgeStatus;
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cases = 0;
        while(s.hasNext()){
            Contestant[] teams = new Contestant[100];
            for(int i = 0; i < 100; i++){
                teams[i] = new Contestant(0,0,0);
            }
            ArrayList<JudgeEntry> entries = new ArrayList<>();
            ArrayList<Integer> teamNums = new ArrayList<>();
            if(cases ==0){
                cases = s.nextInt();
            }
            String line;
            while(!(line = s.nextLine()).isEmpty()){
                StringTokenizer tokenizer = new StringTokenizer(line);
                JudgeEntry entry = new JudgeEntry(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken().charAt(0));
//                JudgeEntry entry = new JudgeEntry(s.nextInt(), s.nextInt(), s.nextInt(), s.next().charAt(0));
                entries.add(entry);
            }

            for(JudgeEntry entry: entries){
                if(!teams[entry.contestantID-1].updated){
                    teams[entry.contestantID-1] = new Contestant(entry.contestantID, entry.problemNumber, entry.time);
                    teams[entry.contestantID-1].updated = true;
                    teamNums.add(entry.contestantID);
                }
                else{
                    teams[entry.contestantID-1].update(entry);
                }
            }
            Arrays.sort(teams);

            for(Contestant team : teams){
                team.print();
            }
            System.out.println();
        }
    }
}
