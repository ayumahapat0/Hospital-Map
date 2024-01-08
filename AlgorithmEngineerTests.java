// --== AlgorithmEngineerTests==--
// Name: Ayush Mahapatra
// Email: mahapatra3@wisc.edu
// Team: BE
// TA: Yuye Jiang
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra note>
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the functionality of the CS400GraphSorted class
 */
public class AlgorithmEngineerTests {

    private CS400GraphSorted minutes;
    private CS400GraphSorted distance;


    /**
     * creates a Map with vertices that holds Strings as data
     */
    @BeforeEach
    public void createMap() {
        minutes = new CS400GraphSorted("minutesTravelled");
        distance = new CS400GraphSorted("distanceTravelled");

        HospitalPathPlaceHolderAE path1 = new HospitalPathPlaceHolderAE("A", "B", 6, 16);
        HospitalPathPlaceHolderAE path2 = new HospitalPathPlaceHolderAE("A", "D", 5, 15);
        HospitalPathPlaceHolderAE path3 = new HospitalPathPlaceHolderAE("A", "C", 2, 12);
        HospitalPathPlaceHolderAE path4 = new HospitalPathPlaceHolderAE("C", "F", 1, 11);
        HospitalPathPlaceHolderAE path5 = new HospitalPathPlaceHolderAE("C", "B", 3, 13);
        HospitalPathPlaceHolderAE path6 = new HospitalPathPlaceHolderAE("B", "C", 2, 12);
        HospitalPathPlaceHolderAE path7 = new HospitalPathPlaceHolderAE("B", "E", 1, 11);
        HospitalPathPlaceHolderAE path8 = new HospitalPathPlaceHolderAE("D", "E", 3, 13);
        HospitalPathPlaceHolderAE path9 = new HospitalPathPlaceHolderAE("F", "D", 1, 11);
        HospitalPathPlaceHolderAE path10 = new HospitalPathPlaceHolderAE("F", "A", 1, 11);
        HospitalPathPlaceHolderAE path11 = new HospitalPathPlaceHolderAE("E", "A", 4, 14);

        ArrayList<HospitalPathPlaceHolderAE> list = new ArrayList<>();
        list.add(path1);
        list.add(path2);
        list.add(path3);
        list.add(path4);
        list.add(path5);
        list.add(path6);
        list.add(path7);
        list.add(path8);
        list.add(path9);
        list.add(path10);
        list.add(path11);

        for (int i = 0; i < list.size(); i++) {
            minutes.insertVertex(list.get(i).getOrigin());
            minutes.insertVertex((list.get(i).getDestination()));
            minutes.insertEdge(list.get(i).getOrigin(), list.get(i).getDestination(), list.get(i).getMinutesTravelled());

            distance.insertVertex(list.get(i).getOrigin());
            distance.insertVertex((list.get(i).getDestination()));
            distance.insertEdge(list.get(i).getOrigin(), list.get(i).getDestination(), list.get(i).getDistanceTravelled());
        }
    }

    /**
     * Checks the minutes travelled between "B" and "F"
     */
    @Test
    public void testPathCostMinutes1(){
        assertEquals(3, minutes.mostEfficientPath("B", "F", "minutesTravelled").distance);
    }

    /**
     * Checks the minutes travelled between "D" and "B"
     */
    @Test
    public void testPathCostMinutes2(){
        assertEquals(12,minutes.mostEfficientPath("D", "B", "minutesTravelled").distance);
    }

    /**
     * Checks the ordered sequence between "D" and "B"
     */
    @Test
    public void testPathMinutesPathList(){
        assertEquals("[D, E, A, C, B]", minutes.mostEfficientPath("D", "B", "minutesTravelled").dataSequence.toString());
    }

    /**
     * Checks the distance travelled between "D" and "B"
     */
    @Test
    public void testPathCostDistance1(){
        assertEquals(15, distance.mostEfficientPath("A", "D", "distanceTravelled").distance);
    }

    /**
     * Checks the distance travelled between "D" and "B"
     */
    @Test
    public void testPathDistance2(){
        assertEquals(23, distance.mostEfficientPath("A", "F", "distanceTravelled").distance);
    }

    /**
     * Checks the ordered sequence between "F" and "B"
     */
    @Test
    public void testPathDistancePathList(){
        assertEquals("[F, A, B]", distance.mostEfficientPath("F", "B", "distanceTravelled").dataSequence.toString());
    }
}
