// --== IHospital Loader ==--
// Name: Jasper Bo
// Email: jjbo@wisc.edu
// Team: BE
// TA: Yuye
// Lecturer: Gary Dahl
// Notes to Grader:
import java.util.List;
import java.io.FileNotFoundException;

/**
 * instance of a class that implements this interface to load
 * a list of students from a json file
 * The following hospitals have these attributes:
 *    - Name: name of hospital
 */


public interface IHospitalLoader {

    /**
     * this methods loads the list of hospitals described in the json file
     * @param filepath
     * @return a list of Hospitals
     * @throws FileNotFoundException - file does not exist
     */
    List<IHospital> loadHospitals(String filepath) throws FileNotFoundException;
}