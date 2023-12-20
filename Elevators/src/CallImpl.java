class CallImpl implements Call {
    private Elevator elevator;

    public CallImpl(Elevator elevator) {
        this.elevator = elevator;
    }
    @Override
    public void makeCall(Type callType, int floor) {
        elevator.move(floor);
    }
}
