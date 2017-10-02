import java.io.IOException;
import java.util.Scanner;

//ID: 10137
class Trip {

    public static void main( String args[] ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int numStudents = scanner.nextInt();
            if(numStudents == 0){
                break;
            }
            double total = 0.0;
            double[] values = new double[numStudents];
            for(int i = 0; i < numStudents; i++){
                values[i] = scanner.nextDouble();
                total += values[i];
            }

            double average = total / (double) numStudents;
            average = Math.round(average * 100.0) /100.0;

            double amountOwed = 0.0;
            double amountGiven = 0.0;

            for(int i = 0; i < numStudents; i++){
                double difference = values[i] - average;
                if(difference < 0){
                    amountOwed -= difference;
                }
                else{
                    amountGiven += difference;
                }
            }

            if(amountOwed < amountGiven && amountOwed !=0.0)
                System.out.printf("$%.2f\n", amountOwed);
            else{
                System.out.printf("$%.2f\n", amountGiven);
            }


        }
    }
}
