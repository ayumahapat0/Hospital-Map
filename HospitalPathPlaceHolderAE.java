public class HospitalPathPlaceHolderAE extends CS400Graph {
    protected String origin;
    protected String destination;
    protected int minutesTravelled;
    protected int distanceTravelled;

    public HospitalPathPlaceHolderAE(String origin, String destination, int minutesTravelled, int distanceTravelled){
        this.origin = origin;
        this.destination = destination;
        this.minutesTravelled = minutesTravelled;
        this.distanceTravelled = distanceTravelled;
    }

    public String getOrigin(){
        return this.origin;
    }

    public String getDestination(){
        return this.destination;
    }

    public int getMinutesTravelled(){
        return this.minutesTravelled;
    }

    public int getDistanceTravelled() { return this.distanceTravelled;}
}
