import java.util.Scanner;

public class Main {
    public static void initializeArray(char[][] cinema) {
        // Initialize all seats as 'S' (available)
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = 'S';
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of rows and seats per row from the user
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();

        // Create the cinema seating arrangement
        char[][] cinema = new char[rows][seats];

        // Initialize all spots as S in cinema
        initializeArray(cinema);


        System.out.println("Cinema:");
        System.out.print("  "); // For column numbers
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " "); // Row numbers
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter a row number: ");
        int chosenRow = scanner.nextInt();

        System.out.print("Enter a seat number in that row: ");
        int chosenSeat = scanner.nextInt();

        int ticketPrice = 0;
        int numOfSeats = rows * seats;

        // Determine ticket price
        if (numOfSeats >= 60 && rows % 2 != 0) {
            int frontRows = (rows-1) / 2;
            int backRows = (rows+1) / 2;
            ticketPrice = (chosenRow <= frontRows) ? 10 : 8;
        } else if (numOfSeats >= 60) {
            int frontRows = rows / 2;
            int backRows = rows / 2;
            ticketPrice = (chosenRow <= frontRows) ? 10 : 8;
        } else {
            ticketPrice = 10;
        }

        System.out.println("Ticket price: $"+ ticketPrice);

        // Change that number in array
        cinema[chosenRow-1][chosenSeat-1] = 'B';

        System.out.println("Cinema:");
        System.out.print("  "); // For column numbers
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " "); // Row numbers
            for (int j = 0; j < seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }


    }
}
