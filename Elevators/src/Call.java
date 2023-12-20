interface Call {
    enum Type {
        EVEN_FLOOR,
        ODD_FLOOR,
        EMPLOYEE
    }

    void makeCall(Type callType, int floor);
}