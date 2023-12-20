public class EvenElevators extends Elevator {
    public void move(int floor) {
        if (floor % 2 == 0) {
            setCurrentFloor(floor);
        } else {
            throw new IllegalArgumentException("Even elevator can only move to even floors");
        }
    }
}
