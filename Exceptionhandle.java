import java.io.*;
import java.util.*;

public class Exceptionhandle {

    public static void main(String args[]) {
        try (Scanner s = new Scanner(System.in)) {
            
            System.out.println("1. Arithmetic exception");
            System.out.println("2. Null pointer exception");
            System.out.println("3. Number format exception");
            System.out.println("4. Array index out of bound");
            System.out.println("5. String index out of bound");
            System.out.println("6. IO Exception");
            System.out.println("7. Illegal Argument Exception");
            
            System.out.print("\nEnter your choice (1-7): ");
            int choice = s.nextInt();
            
            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("\nEnter two numbers to Perform division (a / b):\n");
                        System.out.print("\nEnter the First number : ");
                        int a = s.nextInt();
                        System.out.print("E\nnter the Second number : ");
                        int b = s.nextInt();
                        System.out.println("Output : " + (a / b));
                    } catch (ArithmeticException e) {
                        System.out.println("Caught error: Division by zero");
                    }
                }

                case 2 -> {
                    try {
                        System.out.print("Enter a string (Leave empty to trigger exception): ");
                        s.nextLine(); 
                        String str = s.nextLine();
                        if (str.isEmpty()) str = null;
                        if (str == null) throw new NullPointerException();
                        
                        System.out.print("String Length: " + str.length());
                    } catch (NullPointerException e) {
                        System.out.println("Error: Null object");
                    }
                }

                case 3 -> {
                    try {
                        System.out.print("Enter a number (or characters to trigger exception): ");
                        int num = Integer.parseInt(s.next());
                        System.out.println("Parsed number : " + num);
                    } catch (NumberFormatException e) {
                        System.out.println("Error : Invalid number Format");
                    }
                }

                case 4 -> {
                    try {
                        System.out.print("Array size: ");
                        int size = s.nextInt();
                        int array[] = new int[size];
                        System.out.println("Enter the elements: ");
                        for (int i = 0; i < size; i++) array[i] = s.nextInt();
                        
                        System.out.print("Index to access: ");
                        System.out.println("Element : " + array[s.nextInt()]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: Invalid array index");
                    }
                }

                case 5 -> {
                    try {
                        System.out.print("Enter a string: ");
                        s.nextLine(); 
                        String txt = s.nextLine();
                        System.out.print("Index : ");
                        System.out.println("Character at index : " + txt.charAt(s.nextInt()));
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Invalid string index");
                    }
                }

                case 6 -> {
                    try {
                        System.out.println("Simulating IO Operation...");
                        StringReader reader = new StringReader("Test data");
                        reader.close();
                        reader.read(); 
                    } catch (IOException e) {
                        System.out.println("Caught Error: IO Exception occurred (Stream closed)");
                    }
                }

                case 7 -> {
                    try {
                        System.out.print("Enter a positive num: ");
                        int num = s.nextInt();
                        if (num < 0) throw new IllegalArgumentException("Must be positive");
                        System.out.println("Valid Input : " + num);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                }

                default -> System.out.println("Invalid choice");
            }
        } 
    }
}