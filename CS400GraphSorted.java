// --== CS400GraphSorted ==--
// Name: Ayush Mahapatra
// Email: mahapatra3@wisc.edu
// Team: BE
// TA: Yuye Jiang
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra note>
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * This class extends the CS400 graph class by extending the functionality of the
 * shortestPath method
 */
public class CS400GraphSorted extends CS400Graph<String> {
    protected String attribute; // attribute that determines the weights of the dges

    /**
     * constructs a graph with an attribute that describes the edge weights
     * @param attribute - String that determines type of edge weight (minutes or distance)
     */
    public CS400GraphSorted(String attribute){
        super();
        this.attribute = attribute;
    }

    /**
     * constructs a graph with edge weight representing minutes
     */
    public CS400GraphSorted(){
        super();
        this.attribute = "minutesTravelled";
    }

    /**
     * returns the shortest path based the attribute that determines the edge weights
     * @param start - starting location
     * @param end - destination
     * @param attribute - String that determines type of edge weight (minutes or distance)
     * @return shortest path based type of edge weight
     */
    public Path mostEfficientPath(String start, String end, String attribute){

        // find shortest path based on minutes
        if(attribute.equals("minutesTravelled")){
           return mostEfficientPathMinutes(start, end);
        }
       // find shortest path based on mintues
       return mostEfficientPathDistance(start, end);
        
    }

    /**
     * finds the shortest path based on minutes
     * @param start - starting location
     * @param end - ending location
     * @return - the shortest path based on minutes
     */
    private Path mostEfficientPathMinutes(String start, String end){
        // check if vertices are valid
        if(start == null || end == null){
            throw new NoSuchElementException("No Path is found");
        }
        if(!vertices.containsKey(start) || !vertices.containsKey(end)){
            throw new NoSuchElementException("No Path is found");
        }
        PriorityQueue<Path> frontier = new PriorityQueue<>();
        ArrayList<Path> pathsVisited = new ArrayList<>();

        Path starting = new Path(vertices.get(start));
        frontier.add(starting);

        while (!frontier.isEmpty()) {

            // path with highest priority
            Path high = frontier.remove();
            pathsVisited.add(high);


            // replace the path the higher priority
            for(int i = 0; i < pathsVisited.size(); i++){
                if(high.end.equals(pathsVisited.get(i).end)){
                    if(high.compareTo(pathsVisited.get(i)) < 0){
                        pathsVisited.set(i,high);
                        pathsVisited.remove(pathsVisited.size()-1);
                    }
                    if(high.compareTo(pathsVisited.get(i)) > 0){
                        pathsVisited.remove(pathsVisited.size()-1);
                    }
                }
            }



            // add new paths to the frontier
            for (int i = 0; i < high.end.edgesLeaving.size(); i++) {
                boolean visited = false;
                Path newPath = new Path(high, high.end.edgesLeaving.get(i));

                for (int j = 0; j < pathsVisited.size(); j++) {
                    //check if the node has already been visited
                    if (newPath.end.equals(pathsVisited.get(j).end)) {
                        visited = true;
                        if (newPath.compareTo(pathsVisited.get(j)) < 0) {
                            pathsVisited.set(j,newPath);
                        }
                    }
                }



                if(!visited) {
                    frontier.add(newPath);
                }

            }

        }
        // find the path with end vertex
        Path shortest = null;
        for (int k = 0; k < pathsVisited.size(); k++) {
            if (pathsVisited.get(k).end.data == end) {
                shortest = pathsVisited.get(k);
            }
        }

        if(shortest == null){
            throw new NoSuchElementException("No Path is found!");
        }

        return shortest;

    }

    /**
     * finds the shortest path based on distance
     * @param start - starting location
     * @param end - ending location
     * @return - the shortest path based on distance
     */
    private Path mostEfficientPathDistance(String start, String end) {
        // check if vertices are valid
        if(start == null || end == null){
            throw new NoSuchElementException("No Path is found");
        }
        if(!vertices.containsKey(start) || !vertices.containsKey(end)){
            throw new NoSuchElementException("No Path is found");
        }
        PriorityQueue<Path> frontier = new PriorityQueue<>();
        ArrayList<Path> pathsVisited = new ArrayList<>();

        Path starting = new Path(vertices.get(start));
        frontier.add(starting);

        while (!frontier.isEmpty()) {

            // path with highest priority
            Path high = frontier.remove();
            pathsVisited.add(high);


            // replace the path the higher priority
            for(int i = 0; i < pathsVisited.size(); i++){
                if(high.end.equals(pathsVisited.get(i).end)){
                    if(high.compareTo(pathsVisited.get(i)) < 0){
                        pathsVisited.set(i,high);
                        pathsVisited.remove(pathsVisited.size()-1);
                    }
                    if(high.compareTo(pathsVisited.get(i)) > 0){
                        pathsVisited.remove(pathsVisited.size()-1);
                    }
                }
            }



            // add new paths to the frontier
            for (int i = 0; i < high.end.edgesLeaving.size(); i++) {
                boolean visited = false;
                Path newPath = new Path(high, high.end.edgesLeaving.get(i));

                for (int j = 0; j < pathsVisited.size(); j++) {
                    //check if the node has already been visited
                    if (newPath.end.equals(pathsVisited.get(j).end)) {
                        visited = true;
                        if (newPath.compareTo(pathsVisited.get(j)) < 0) {
                            pathsVisited.set(j,newPath);
                        }
                    }
                }



                if(!visited) {
                    frontier.add(newPath);
                }

            }

        }
        // find the path with end vertex
        Path shortest = null;
        for (int k = 0; k < pathsVisited.size(); k++) {
            if (pathsVisited.get(k).end.data == end) {
                shortest = pathsVisited.get(k);
            }
        }

        if(shortest == null){
            throw new NoSuchElementException("No Path is found!");
        }

        return shortest;

    }
}
