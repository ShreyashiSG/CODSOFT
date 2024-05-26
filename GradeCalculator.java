package Tasks;

import java.util.Scanner;

public class GradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scan =new Scanner(System.in);

        //Taking input of total number of subjects
        System.out.println("Enter the number of subjects: ");
        int numSubjects = scan.nextInt();

        int totalMarks =0;
        //Taking input of marks of each subject
        for (int i=1; i<=numSubjects; i++)
        {
            System.out.println("Enter the marks for "+i+ "(out of 100): ");
            int marks = scan.nextInt();

            //Calculating Total Marks
            totalMarks += marks ;
        }

        //Calculating the Average Percentage
        double avgPercentage = (double) totalMarks/ numSubjects;

        //Calculating Grade
        String grade ;
        if(avgPercentage >= 90){
            grade = "O";
        } else if (avgPercentage >= 80) {
            grade = "A";
        } else if (avgPercentage >= 70) {
            grade = "B";
        } else if (avgPercentage >= 60) {
            grade = "C";
        } else if (avgPercentage >= 50){
            grade = "D";
        }else {
            grade = "F";
        }

        //Printing the result 
        System.out.println("Total Marks: "+ totalMarks);
        System.out.println("Average Percentage: "+ avgPercentage);
        System.out.println("Grade: "+ grade);

    }
}

/*
OUTPUT: 
Enter the number of subjects: 
5
Enter the marks for 1(out of 100):
90
Enter the marks for 2(out of 100):
93
Enter the marks for 3(out of 100):
97
Enter the marks for 4(out of 100):
89
Enter the marks for 5(out of 100):
85
Total Marks: 454
Average Percentage: 90.8
Grade: O
  */
