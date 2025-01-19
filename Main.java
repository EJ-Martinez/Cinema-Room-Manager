import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Cinema:
                  1 2 3 4 5 6 7 8
                1 S S S S S S S S
                2 S S S S S S S S
                3 S S S S S S S S
                4 S S S S S S S S
                5 S S S S S S S S
                6 S S S S S S S S
                7 S S S S S S S S""");

        // Get num of rows
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        // Get number of seats in each row
        System.out.println("Enter the number of seats in each row");
        int seats = scanner.nextInt();

        /*
         * If the total number of seats in the screen room is not more than 60, then the price of each ticket is 10 dollars.
         * In a larger room, the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half.
         * Please note that the number of rows can be odd, for example, 9 rows. In this case,
         * the first half is the first 4 rows, and the second half is the other 5 rows
         */

        int income;
        int numOfSeats = rows * seats;

        // Determine ticket price
        if (numOfSeats >= 60 && rows % 2 != 0) {
            int frontRows = (rows-1) / 2;
            int backRows = (rows+1) / 2;
            income = ((frontRows * seats) * 10) + ((backRows * seats) * 8);
        } else if (numOfSeats >= 60) {
            int frontRows = rows / 2;
            int backRows = rows / 2;
            income = ((frontRows * seats) * 10) + ((backRows * seats) * 8);
        } else {
            income = numOfSeats * 10;
        }

        System.out.println("Total income:");
        System.out.printf("$%d", income);

    }
}
