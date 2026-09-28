package Exercise_12;

import java.util.Scanner;

public class StudentResult {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            StudentBean student = new StudentBean();
            
            System.out.print("Enter Student Name: ");
            student.setName(sc.nextLine());
            
            System.out.print("Enter Roll Number: ");
            student.setRoll(sc.nextInt());
            
            int[] marks = new int[5];
            
            System.out.println("Enter Marks:");
            
            for (int i = 0; i < 5; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }
            
            student.setMarks(marks);
            
            System.out.println("\n===== STUDENT RESULT =====");
            
            System.out.println("Name    : " + student.getName());
            System.out.println("Roll No : " + student.getRoll());
            
            for (int i = 0; i < 5; i++) {
                System.out.println(
                        "Subject " + (i + 1) + " : " + student.getMarks()[i]
                );
            }
            
            System.out.println("Total   : " + student.getTotal());
            System.out.println("Average : " + student.getAverage());
            System.out.println("Grade   : " + student.getGrade());
            System.out.println("Result  : " + student.getResult());
        }
    }
}