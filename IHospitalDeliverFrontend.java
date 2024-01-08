import java.util.List;
/**
 * Instances of classes that implement this interface can be used to drive a
 * console-based text user interface for the Organ Delivery System App.
 */
public interface IHospitalDeliverFrontend {
	
    /**
     * This method drives the entire print loop for the
     * Organ Delivery System App.  This loop will continue to run until the user
     * explicitly enters the quit command.
     */
	public void runCommandLoop();
	
	public void displayCommandMenu(); // prints command options to System.out
	public void displayHospitals(List<String> hospitals); // displays a list of Hospitals
	public void showStartingPointNearbyHospitals(); // displays nearby hospitals from starting point
	public void showDestinationNearbyHospitals(); // displays nearby hospitals from destination	
	public void setStartingPoint(); // set the starting point
	public void setDestination(); // set the destination


}
