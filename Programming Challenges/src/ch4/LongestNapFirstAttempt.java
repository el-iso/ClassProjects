package ch4;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestNapFirstAttempt {

    static class Appointment implements Comparable<Appointment>{
        String startStr, endStr;
        int start, end;
        Appointment(String line){
            startStr = line.substring(0,5);
            endStr = line.substring(6,11);
            String startHr = line.substring(0,2);
            String startMin = line.substring(3,5);
            String endHr = line.substring(6,8);
            String endMin = line.substring(9,11);

            start = Integer.parseInt(startHr + startMin);
            end = Integer.parseInt(endHr + endMin);
        }
        Appointment(String start, String end){
            this.startStr = start;
            this.endStr = end;
            String startHr = start.substring(0,2);
            String startMin = start.substring(3,5);
            String endHr = end.substring(0,2);
            String endMin = end.substring(3,5);

            this.start = Integer.parseInt(startHr + startMin);
            this.end = Integer.parseInt(endHr + endMin);
        }

        public int compareTo(Appointment app){
            if(this.start < app.start){
                return -1;
            }
            else if(this.start > app.start){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

    private static String parseDuration(int napTime){
        String duration = String.valueOf(napTime);
        if(duration.length() < 4){
            duration = "0" + duration;
        }
        System.out.println(duration);
        int[] time = new int[2];
        time[0] = Integer.parseInt(duration.substring(0,2));
        time[1] = Integer.parseInt(duration.substring(2, duration.length()));
        StringBuilder sb = new StringBuilder();
        if(time[0] >0){
            sb.append(time[0]);
            sb.append(" hours and ");
        }
        sb.append(time[1]);
        sb.append(" minutes.");

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int day = 1;
        while(scanner.hasNextLine()){
            ArrayList<Appointment> appointments = new ArrayList<>();
            int appts = Integer.parseInt(scanner.nextLine());
            appointments.add(new Appointment("10:00", "10:00"));
            appointments.add(new Appointment("18:00", "18:00"));
            for(int a = 0; a < appts; a++){
                appointments.add(new Appointment(scanner.nextLine()));
            }

            Appointment startNap = appointments.get(0);
            Appointment endNap = null;
            int longestNapTime = 0;
            for(int i = 0; i < appointments.size() - 1; i++){
                Appointment appOne = appointments.get(i);
                Appointment appTwo = appointments.get(i+1);
                int napTime = appTwo.start - appOne.end;
                if(napTime > longestNapTime){
                    startNap = appOne;
                    endNap = appTwo;
                    longestNapTime = napTime;
                }
            }


            System.out.print("Day #" + day + " : the longest nap starts at ");
            System.out.print(startNap.endStr);
            System.out.print(" and will last for ");
            System.out.println(parseDuration(longestNapTime));

            day++;
        }
    }

}
