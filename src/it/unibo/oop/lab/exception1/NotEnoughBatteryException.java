package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	private static final long serialVersionUID = 4337899504174144323L;
	
	private final double robotBattery;
    private final double neededBattery;

    public NotEnoughBatteryException(double actual, double needed) {
    	super();
    	this.robotBattery = actual;
    	this.neededBattery= needed;
    }
    
    public String toString() {
        return "Not enough battery. need " + neededBattery + "% but robot has only " + robotBattery + "% ";
    }

    public String getMessage() {
        return this.toString();
    }
}
