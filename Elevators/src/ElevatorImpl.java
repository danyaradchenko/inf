public class ElevatorImpl implements ElevatorManager{
    private boolean status;

    @Override
    public boolean free() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
