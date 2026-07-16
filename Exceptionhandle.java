import java.util.Scanner;

public class Exceptionhandle{

    @SuppressWarnings("resource")
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("1. Arithmetic exception");
        System.out.println("2. Null pointer exception");
        System.out.println("3. Number format exception");
        System.out.println("4. Array index out of bound");
        System.out.println("5. string index out of bound");
        System.out.println("6. IO Exception");
        System.out.println("7. Illegal Argument Exception");
        
        System.out.println("Enter your choice (1-7):");
        int choice = s.nextInt();
        
        switch (choice) {
            case 1 -> {
                try {
                    System.out.println("Enter two numbers to divide :");
                    System.out.print("Enter First number :");
                    int a = s.nextInt();
                    System.out.print("Enter Second number :");
                    int b = s.nextInt();
                    System.out.println("Output : " + (a / b));
                } catch (ArithmeticException e) {
                    System.out.println("caught error: Division by zero");
                }
            }

            case 2 -> {
                try {
                    System.out.print("Enter a string : ");
                    s.nextLine(); // Clear scanner buffer
                    String str = s.nextLine();
                    int strlength = str.length();
                    if (str.isEmpty()) {
                        str = null;
                    }
                    System.out.print("string Length " + strlength);
                } catch (NullPointerException e) {
                    System.out.println("Error: Null object");
                }
            }

            case 3 -> {
                try {
                    System.out.print("Enter a number : ");
                    String input = s.next();
                    int Num = Integer.parseInt(input);
                    System.out.println("Parsed number : " + Num);
                } catch (NumberFormatException e) {
                    System.out.println("Error : Invalid number Format");
                }
            }

            case 4 -> {
                try {
                    System.out.println("Array size:");
                    int size = s.nextInt();
                    int array[] = new int[size];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < size; i++) {
                        array[i] = s.nextInt();
                    }
                    System.out.print("Index to access: ");
                    int index = s.nextInt();
                    System.out.println("Element : " + array[index]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("error: invalid array index");
                }
            }

            case 5 -> {
                try {
                    System.out.print("Enter a string: ");
                    s.nextLine(); // Clear scanner buffer
                    String txt = s.nextLine();
                    System.out.println("Index : ");
                    int index = s.nextInt();
                    System.out.println("Character at index : " + txt.charAt(index));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid string index");
                }
            }

            case 7 -> {
                try {
                    System.out.print("Enter a positive num: ");
                    int Num = s.nextInt();
                    if (Num < 0) {
                        throw new IllegalArgumentException("Must be positive");
                    }
                    System.out.println("valid Input : " + Num);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error : " + e.getMessage());
                }
            }

            default -> System.out.println("Invalid choice");
        }
    }
}

