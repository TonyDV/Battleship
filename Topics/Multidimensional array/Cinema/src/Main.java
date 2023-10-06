import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int seats = scanner.nextInt();
        int freeSeats;
        int rowNumber = 0;
        for (int i = 0; i < x; i++) {
            freeSeats = 0;
            for (int j = 0; j < y; j++) {
                if (array[i][j] == 0) {
                    freeSeats++;
                    if (seats <= freeSeats) {
                        break;
                    }
                } else {
                    freeSeats = 0;
                }
            }
            if (seats <= freeSeats) {
                rowNumber = ++i;
                break;
            }
        }
        System.out.println(rowNumber);

    }
}