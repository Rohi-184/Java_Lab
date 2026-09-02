import java.util.*;

class StringManipulation {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        int ch;

        do {
            System.out.println("\n1.Length  2.Uppercase  3.Lowercase  4.Reverse");
            System.out.println("5.CharAt  6.Substring  7.Replace  8.Equals");
            System.out.println("9.Contains  10.Concatenate  11.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> System.out.println("Length: " + s.length());
                case 2 -> System.out.println("Uppercase: " + s.toUpperCase());
                case 3 -> System.out.println("Lowercase: " + s.toLowerCase());
                case 4 -> System.out.println("Reverse: " + new StringBuilder(s).reverse());
                case 5 -> {
                    System.out.print("Enter index: ");
                    System.out.println("Character: " + s.charAt(sc.nextInt()));
                }
                case 6 -> {
                    System.out.print("Start: ");
                    int a = sc.nextInt();
                    System.out.print("End: ");
                    int b = sc.nextInt();
                    System.out.println("Substring: " + s.substring(a, b));
                }
                case 7 -> {
                    sc.nextLine();
                    System.out.print("Old text: ");
                    String old = sc.nextLine();
                    System.out.print("New text: ");
                    String ne = sc.nextLine();
                    System.out.println("Result: " + s.replace(old, ne));
                }
                case 8 -> {
                    sc.nextLine();
                    System.out.print("Enter another string: ");
                    System.out.println("Equal: " + s.equals(sc.nextLine()));
                }
                case 9 -> {
                    sc.nextLine();
                    System.out.print("Search text: ");
                    System.out.println("Contains: " + s.contains(sc.nextLine()));
                }
                case 10 -> {
                    sc.nextLine();
                    System.out.print("Enter another string: ");
                    System.out.println("Concatenated: " + s.concat(sc.nextLine()));
                }
                case 11 -> System.out.println("Exit");
                default -> System.out.println("Invalid choice");
            }
        } while (ch != 11);

        sc.close();
    }
}