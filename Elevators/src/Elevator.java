abstract class Elevator {
    enum Status{
        busy,
        free
    }
    int currentFloor;
    Status status;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    abstract void move(int floor);
}
