public class ElevatorUnavailableException extends Exception {
    public ElevatorUnavailableException() {
        super("All elevators are currently busy. Please wait or use the stairs.");
    }
}
