//ESU1Final
//Create a school gradebook

//imports
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //initialize the scanner and array
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> studentAverages = new ArrayList<Double>();

        //initialize the variables
        double classTotal = 0;
        int numClasses = 0;

        while (true) {
            
            //asks the user for the student email
            System.out.print("Enter student email address (type exit to quit): ");
            String email = scanner.nextLine();

            if (email.equals("exit")) {

                //stops the code when the user is done inputting student marks
                break;

            }

            //get the student marks
            processStudentMarks(scanner, studentAverages, classTotal, numClasses, email);

        }


        System.out.print(numClasses);

        //prints the students marks and the class average
        printResults(studentAverages, classTotal, numClasses);

        //closes the scanner
        scanner.close();

    }

    public static void processStudentMarks(Scanner scanner, ArrayList<Double> studentAverages, double classTotal, int numClasses, String email) {

        //initialize the variables
        double totalMark = 0;
        int numMarkedClasses = 0;

        //asks the user for the students marks for 4 classes
        System.out.println("Enter marks for classes:");

        for (int i = 1; i <= 4; i++) {

            System.out.print("Class " + i + ": ");
            int mark = scanner.nextInt();

            //updates the student mark if they had a class
            if (mark != -1) {

                totalMark += mark;
                numMarkedClasses++;
                System.out.println(numMarkedClasses);

            }
            
        }

        //averaging the marks for the student and adding it to a database
        if (numMarkedClasses > 0) {
            double averageMark = totalMark / numMarkedClasses;
            classTotal += averageMark;
            numClasses++;
            studentAverages.add(averageMark);
            System.out.printf("Student %s average mark: %.2f\n", email.split("@")[0], averageMark);

            //consume newline
            scanner.nextLine();

        }

    }

    public static void printResults(ArrayList<Double> studentAverages, double classTotal, int numClasses) {

        if (numClasses > 0) {

            //average the marks of each student together
            double overallAverage = classTotal / numClasses;

            //print the class average
            System.out.printf("Class average: %.2f\n", overallAverage);

            //print each students average
            System.out.println("All Students Averages:");
            for (int i = 0; i < studentAverages.size(); i++) {
                System.out.printf("Student %d average mark: %.2f\n", i++, studentAverages.get(i));
            }

        }

    }

}
