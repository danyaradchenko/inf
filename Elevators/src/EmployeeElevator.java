public class EmployeeElevator extends Elevator {
    public void move(int floor) {
        if (floor >= 1 && floor <= 16) {
            setCurrentFloor(floor);
        } else {
            throw new IllegalArgumentException("Employee elevator can only move to floors 1-16");
        }
    }
}
