public class Main {
    public static void main(String[] args) {

        ElevatorImpl elevator1 = new ElevatorImpl();
        ElevatorImpl elevator2 = new ElevatorImpl();
        ElevatorImpl elevator3 = new ElevatorImpl();

        elevator1.setStatus(false);
        elevator2.setStatus(true);
        elevator3.setStatus(true);


        CallImpl call1 = new CallImpl(new OddElevators());
        CallImpl call2 = new CallImpl(new EvenElevators());
        CallImpl call3 = new CallImpl(new EmployeeElevator());


        try {
            call1.makeCall(Call.Type.ODD_FLOOR, 5);
            System.out.println("Odd elevator is moving to floor 5");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            call2.makeCall(Call.Type.EVEN_FLOOR, 4);
            System.out.println("Even elevator is moving to floor 4");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            call3.makeCall(Call.Type.EMPLOYEE, 17);
            System.out.println("Employee elevator is moving to floor 17");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}