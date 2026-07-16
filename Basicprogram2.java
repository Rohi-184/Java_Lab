import java.util.Scanner;

public class Basicprogram2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1. Factorial\n2. Fibonacci series\n3. Check palindrome\n4. Check armstrong\n5. Prime number");
        System.out.print("\nEnter your choice (1-5): ");
        int choice = s.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter a number: ");
                int factn = s.nextInt();
                int fact = 1;
                for (int i = 1; i <= factn; i++) {
                    fact = fact * i;
                }
                System.out.println("Factorial of " + factn + " is: " + fact);
            }

            case 2 -> {
                System.out.print("Enter number of terms: ");
                int terms = s.nextInt();
                int t1 = 0, t2 = 1;
                for (int i = 1; i <= terms; i++) {
                    System.out.print(t1 + " ");
                    int sum = t1 + t2;
                    t1 = t2;
                    t2 = sum;
                }
            }

            case 3 -> {
                System.out.print("Enter a number: ");
                int n = s.nextInt();
                int originalN = n, reversedN = 0;
                while (n != 0) {
                    int digit = n % 10;
                    reversedN = reversedN * 10 + digit;
                    n /= 10;
                }
                if (originalN == reversedN) System.out.println(originalN + " is palindrome");
                else System.out.println(originalN + " is not palindrome");
            }

            case 4 -> {
                // Armstrong logic added as requested functionality
                System.out.print("Enter a number: ");
                int num = s.nextInt();
                int temp = num, armSum = 0;
                while (temp != 0) {
                    int digit = temp % 10;
                    armSum += (digit * digit * digit);
                    temp /= 10;
                }
                if (armSum == num) System.out.println(num + " is an Armstrong number");
                else System.out.println(num + " is not an Armstrong number");
            }

            case 5 -> {
                System.out.print("Enter a number: ");
                int primeN = s.nextInt();
                boolean isPrime = true;
                if (primeN <= 1) isPrime = false;
                else {
                    for (int i = 2; i <= Math.sqrt(primeN); i++) {
                        if (primeN % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
                if (isPrime) System.out.println(primeN + " is prime number");
                else System.out.println(primeN + " is not prime");
            }

            default -> System.out.println("Invalid choice \nPlease enter a valid choice (1-5)");
        }
    }
}