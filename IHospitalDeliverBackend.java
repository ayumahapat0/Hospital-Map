import java.util.List;
import java.util.LinkedList;

/**
 * This class utilizes the Hospital Object developed by the Data Wrangler and CS400GraphSorted class
 * implemented by the Algorithm Engineer to efficiently search for hospitals by their name.
 * The backend adds and filters the hospitals by the time it takes to get from one hospital
 * to another. After this filtering is done, get the resulting list of stops to get from start
 * hospital to destination hospital in the shortest time, the time it takes, the hospital list
 * nearby the start hospital and nearby the end hospital.
 */
public interface IHospitalDeliverBackend {
  /**
   * This method adds hospital object
   * @param hospital
   */
  public void addHospital(IHospital hospital);
  /**
   * this method gets a list of hospitals which are available for users
   * @return list of available hosputals
   */
  public List<HospitalPathPlaceHolderAE> getAvailableHospitals();

  /**
   * This method searches the start hospital using a number
   * @param num the number users entered
   */
  public void searchStartHospital(int num);

  /**
   * This method searches the end hospital using a number
   * @param num the number users entered
   */
  public void searchEndHospital(int num);

  /**
   * This method adds and filters the hospitals by time it takes from start to destination
   * @param start start hospital
   * @param destination destinate hospital
   */
  public void filterByTime(String start, String destination);
  /**
   * This method gets the resulting list of stops to get from start
   * hospital to destination hospital in the shortest time
   * @param start the start hospital
   * @param destination the destination hospital
   * @return list of hospitals to get from start to destination in the shortest time
   */
  public List<HospitalPathPlaceHolderAE> getPath(String start, String destination);

  /**
   * This method gets the hospital list nearby the start hospital
   * @param start the start hospital
   * @return list of hospitals nearby the start
   */
  public List<HospitalPathPlaceHolderAE> getNearbyStart(String start);

  /**
   * This method gets the hospital list nearby the end hospital
   * @param destination
   * @return list of hospitals nearby destination
   */
  public List<HospitalPathPlaceHolderAE> getNearbyDestination(String destination);

  /**
   * This method gets the time taken by the shortest path
   * @return time taken by the shortest path
   */
  public int getTime();
}