package ch4;

import java.util.Arrays;
import java.util.Scanner;

public class LongestNap {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int day = 1;
        while(scanner.hasNextLine()){
            int appts;
            try {
                appts = Integer.parseInt(scanner.nextLine());
            }
            catch(Exception e){
                break;
            }
            int[] appointments = new int[4*appts];

            for(int a = 0; a < appointments.length; a = a +4){
                String line = scanner.nextLine();
                line = line.replace(":", " ");
                Scanner lineScanner = new Scanner(line);

                appointments[a] = lineScanner.nextInt();
                appointments[a+1] = lineScanner.nextInt();
                appointments[a+2] = lineScanner.nextInt();
                appointments[a+3] = lineScanner.nextInt();

            }

            boolean[] sched = new boolean[481];

            for(int i = 0; i <appointments.length; i = i+4){
                int index = (appointments[i] - 10)*60 + appointments[i+1];
                int end = (appointments[i+2] - 10)*60 + appointments[i+3];

                for(int j = index; j < end; j++){
                    sched[j] = true;
                }
            }
            //System.out.println(Arrays.toString(sched));
            String lastStart = "10:00";
            String currentStart = "10:00";
            int currentInt = 0;
            int lastInt = 0;
            int lastTime = 0;
            int currentTime = 0;
            for(int i = 0; i < sched.length; i++){
                if(currentTime ==0){
                    currentStart = Integer.toString(i/60 + 10) + ":" + ((i%60<10) ? "0"+Integer.toString(i%60 ) : Integer.toString(i%60 ));
                    currentInt = i;
                }

                if(currentTime > lastTime){
                    lastTime = currentTime;
                    if(currentTime == lastTime){
                        lastStart = currentStart;
                        lastInt = currentInt;
                    }
                }
                currentTime++;
                if(sched[i]){
                    currentTime = 0;
                }
            }
//            System.out.println(lastStart + " " + lastTime);
//            if(lastInt + lastTime == 8*60 - 1){
//                lastTime++;
//            }
            StringBuilder sb = new StringBuilder();
            if(lastTime / 60 > 0){
                sb.append(lastTime/60);
                sb.append(" hours and ");
            }
            sb.append(lastTime%60);
            sb.append(" minutes.");

            System.out.println("Day #" + day + ": the longest nap starts at " + lastStart + " and will last for " + sb.toString());
            day++;
        }
    }
}
