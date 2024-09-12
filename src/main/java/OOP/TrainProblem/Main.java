package OOP.TrainProblem;

import java.util.Scanner;

class Passenger {
    Train currTrain;

    public Passenger(Train train) {
        this.currTrain = train;
    }

    public boolean reserveSeats(int numSeats) {
        if (currTrain.reserveSeats(numSeats)) {
            return true;
        } else {
            return false;
        }
    }
}

class Train {
    private int availSeats;
    private int reservSeats;

    public Train(int totalSeats) {
        this.availSeats = totalSeats;
    }

    public boolean checkAvailability(int numSeats) {
        if (numSeats <= availSeats) {
            return true;
        }
        return false;
    }

    public boolean reserveSeats(int numSeats) {
        if (checkAvailability(numSeats)) {
            this.availSeats -= numSeats;
            this.reservSeats += numSeats;
            return true;
        } else {
            return false;
        }
    }

    public int getAvailSeats() {
        return this.availSeats;
    }

    public int getReservSeats() {
        return this.reservSeats;
    }
}

class ReservationSystem {
    public static void displayStatus(Train train) {
        System.out.println("Total Seats: " + train.getAvailSeats());
        System.out.println("Reserved Seats: " + train.getReservSeats());
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalSeats = scanner.nextInt();
            // int numSeatsToCheck = scanner.nextInt();
            int numSeatsToReserve = scanner.nextInt();

            Train trainA = new Train(totalSeats);
            Passenger passengerA = new Passenger(trainA);

            System.out.println(trainA.checkAvailability(numSeatsToReserve));
            System.out.println(passengerA.reserveSeats(numSeatsToReserve));
            ReservationSystem.displayStatus(trainA);
        }
    }

}
