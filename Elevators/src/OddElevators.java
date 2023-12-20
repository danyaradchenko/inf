public class OddElevators extends Elevator {
    public void move(int floor) {
        if (floor % 2 != 0) {
            setCurrentFloor(floor);
        } else {
            throw new IllegalArgumentException("Odd elevator can only move to odd floors");
        }
    }
}
