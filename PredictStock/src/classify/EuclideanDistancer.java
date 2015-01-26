package classify;

import java.util.ArrayList;
import java.util.List;

import classify.Classifier.Classification;
import classify.Classifier.Observation;

/** Represents the Euclidean Distance in d-space. 
 *  @author Alan Ponte
 */
public class EuclideanDistancer implements Distancer<List> {

	
	/** Returns the distance between Lists X and Y. */
	public double dist(List x, List y) {
		double distance = 0.0;
		for (int i = 0; i < y.size(); i += 1) {
			double xi = (Double) x.get(i);
			double yi = (Double) y.get(i);
			double difference = xi - yi;
			distance += Math.sqrt(Math.pow(difference, 2));
		}
		return distance;
	}
}
