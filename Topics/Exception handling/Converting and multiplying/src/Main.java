import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = "";
        int a;
        int multiplication = 10;
        while (true) {
            str = scanner.next();
            try {
                a = Integer.parseInt(str);
                if (a == 0) {
                    break;
                }
                System.out.println(a * multiplication);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + str);
            }
        }
    }

}