package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        BattleShip battle = new BattleShip();
        Scanner scanner = new Scanner(System.in);
        //Ship ship = Ship.AIRCRAFT;
        battle.printGameField();

        for (Ship ship: Ship.values()) {
            battle.requestCoordinates(scanner, ship);
        }
    }
}

class BattleShip {

    private final char[][] gameField;
    private final int gameFieldSize = 10;
    private final char emptyField = '~';
    private final char shipField = 'O';
    private int startCoordinateA;
    private int startCoordinateB;
    private int endCoordinateA;
    private int endCoordinateB;


    BattleShip()
    {
        gameField = new char[gameFieldSize][gameFieldSize];
        for (int i = 0; i < gameFieldSize; i++) {
            for (int j = 0; j < gameFieldSize; j++) {
                gameField[i][j] = emptyField;
            }
        }
    }

    void  printGameField() {
        char rowNumber = 'A';
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < gameFieldSize; i++) {
            System.out.print(rowNumber);
            for (int j = 0; j < gameFieldSize; j++) {
                System.out.print(" " + gameField[i][j]);
            }
            System.out.println();
            rowNumber++;
        }
    }

    void requestCoordinates(Scanner scanner, Ship ship) {

        System.out.printf("Enter the coordinates of the %s (%d cells):\n", ship.getName(),
                ship.getSize());
        do {
            String startCoordinates = scanner.next();
            String endCoordinates = scanner.next();
            try {
                decodeCoordinates(startCoordinates, endCoordinates);
                checkCoordinates(ship.getSize(), ship.getName());
                for (int i = startCoordinateA; i <= endCoordinateA; i++) {
                    for (int j = startCoordinateB; j <= endCoordinateB ; j++) {
                        checkSurroundingSpace(i, j);
                    }
                }
                for (int i = startCoordinateA; i <= endCoordinateA; i++) {
                    for (int j = startCoordinateB; j <= endCoordinateB ; j++) {
                        setShip(i, j);
                    }
                }
                printGameField();
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    private void decodeCoordinates(String startCoordinates, String endCoordinates) {
        int tmp;
        int asciiDelta = 65;
        startCoordinateA = startCoordinates.charAt(0) - asciiDelta;
        startCoordinateB = Integer.parseInt(startCoordinates.substring(1)) - 1;
        endCoordinateA = endCoordinates.charAt(0) - asciiDelta;
        endCoordinateB = Integer.parseInt(endCoordinates.substring(1)) - 1;

        if (startCoordinateA > endCoordinateA) {
            tmp = endCoordinateA;
            endCoordinateA = startCoordinateA;
            startCoordinateA = tmp;
        }

        if (startCoordinateB > endCoordinateB) {
            tmp = endCoordinateB;
            endCoordinateB = startCoordinateB;
            startCoordinateB = tmp;
        }
    }

    private void checkCoordinates(int shipSize, String shipName) {

        if (checkCoordinateRange(startCoordinateA) && checkCoordinateRange(startCoordinateB)
                && checkCoordinateRange(endCoordinateA) && checkCoordinateRange(endCoordinateB)
        && ((startCoordinateA == endCoordinateA) || (startCoordinateB == endCoordinateB))) {
            if (startCoordinateA == endCoordinateA) {
                if (Math.abs(startCoordinateB - endCoordinateB) + 1 != shipSize) {
                    throw new RuntimeException("Error! Wrong length of the " + shipName +"! Try again:");
                }
            } else {
                if (Math.abs(startCoordinateA - endCoordinateA) + 1 != shipSize) {
                    throw new RuntimeException("Error! Wrong length of the " + shipName +"! Try again:");
                }
            }
        } else {
            throw new RuntimeException("Error! Wrong ship location! Try again:");
        }
    }

    private boolean checkCoordinateRange(int coordinate) {
        return coordinate >= 0 && coordinate < gameFieldSize;
    }

    private void checkSurroundingSpace(int x, int y) {
        checkFiled(x, y);
        if (x > 0) {
            checkFiled(x - 1, y);
        }
        if (x < gameFieldSize - 1) {
            checkFiled(x + 1, y);
        }
        if (y > 0) {
            checkFiled(x, y - 1);
        }
        if (y < gameFieldSize - 1) {
            checkFiled(x, y + 1);
        }
        if (y < gameFieldSize - 1 && x > 0) {
            checkFiled(x - 1, y + 1);
        }
        if (y < gameFieldSize - 1 && x < gameFieldSize - 1) {
            checkFiled(x + 1, y + 1);
        }
        if (y > 0 && x > 0) {
            checkFiled(x - 1, y - 1);
        }
        if (y > 0 && x < gameFieldSize - 1) {
            checkFiled(x + 1, y - 1);
        }
    }

    private void checkFiled(int x, int y) {
        if (gameField[x][y] == shipField) {
            throw new RuntimeException("Error! You placed it too close to another one. Try again:");
        }
    }

    private void setShip(int x, int y) {
        gameField[x][y] = shipField;
    }



}

enum Ship {
    AIRCRAFT(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3, "Cruiser"),
    DESTROYER(2, "Destroyer");

    private final int size;
    private final String name;

    Ship(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}