import java.util.Scanner;

public class Basicprogram1 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Addition of n numbers\n2. Check odd or even\n3. Count vowels, consonants\n4. Check leap year\n5. Reverse the number");
        System.out.print("\nEnter your choice (1-5): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("How many numbers want to add: ");
                int count = sc.nextInt();
                int sum = 0;
                System.out.println("Enter " + count + " numbers:");
                for (int i = 1; i <= count; i++) {
                    System.out.print("Number " + i + ": ");
                    sum += sc.nextInt();
                }
                System.out.println("The total sum is: " + sum);
            }

            case 2 -> {
                System.out.print("Enter a number: ");
                int n = sc.nextInt();
                if (n % 2 == 0) {
                    System.out.println("Number is even");
                } else {
                    System.out.println("Number is odd");
                }
            }

            case 3 -> {
                System.out.print("Enter a word: ");
                String word = sc.next().toLowerCase();
                int vowels = 0, consonants = 0;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
                System.out.println("Word length: " + word.length());
                System.out.println("Vowels: " + vowels);
                System.out.println("Consonants: " + consonants);
            }

            case 4 -> {
                System.out.print("Enter a year: ");
                int year = sc.nextInt();
                boolean isLeap = false;
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        isLeap = (year % 400 == 0);
                    } else {
                        isLeap = true;
                    }
                }
                if (isLeap) System.out.println("It is Leap year");
                else System.out.println("It is not leap year");
            }

            case 5 -> {
                System.out.print("Enter a number to reverse: ");
                int revNum = sc.nextInt();
                int originalNum = revNum;
                int reverse = 0;
                while (revNum != 0) {
                    int digit = revNum % 10;
                    reverse = reverse * 10 + digit;
                    revNum /= 10;
                }
                System.out.println("Original Number: " + originalNum);
                System.out.println("Reversed Number: " + reverse);
            }

            default -> System.out.println("Invalid choice\nPlease enter a valid choice (1-5)");
        }
    }
}