package _15_exception_debug_.bai_tap.luyen_tap_exception;

class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
        super("This is not a triangle !!");
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}