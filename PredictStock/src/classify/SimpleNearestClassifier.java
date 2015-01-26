package classify;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/** A SimpleNearestClassifier performs a (simple/basic) 
 *  classification algorithm on the training set.
 * @author Alan Ponte
 */
public class SimpleNearestClassifier<ObservationType, ClassificationType> 
				extends Classifier<ObservationType, ClassificationType> {
	
	/** A new SipleNearestClassifier which will get its training data
	 *  from TRAININGSET. */
	public SimpleNearestClassifier(Map trainingSet) {
		_trainingSet = trainingSet;
		_classificationResults = new ArrayList<ClassificationType>();
	}
	
	/** Adds a new (KEY, VALUE) data to the Training Set. */
	public void addToTrainingSet(ObservationType key, ClassificationType value) {
		_trainingSet.put(key, value);
	}
	
	/** Returns the Training Set of THIS Classifier. */
	public Map getTrainingSet() {
		return _trainingSet;
	}
	
	/** Performs the simple classification algorithm on VALS and 
	 *  stores the result in a list. */
	public void classify(ArrayList<ObservationType> vals) {
		ArrayList<ObservationType> trainingxVlas = getTrainingSetXvals();
		int numObservations = getNumObservations();
		double minDist = 1.0;
		for (int i = 0; i < numObservations; i += 1) {
			EuclideanDistancer distance = 
					new EuclideanDistancer();
			// Needs to be fixed.  i should be some xi*.
			if (distance.dist(vals, trainingxVlas) < i) {
				minDist = i;
			}

		}
		
	}
	
	/** Returns the number of observations in the training set. */
	public int getNumObservations() {
		return this._trainingSet.values().size();
	}
	
	/** Returns all X-values from the training set. */
	public ArrayList<ObservationType> getTrainingSetXvals() {
		ArrayList<ObservationType> vals = new ArrayList<ObservationType>();
		Set<ObservationType> xvals = (Set<ObservationType>) _trainingSet.values();
		for (ObservationType x : xvals) {
			vals.add(x);
		}
		return vals;
	}
	
	public double getMinDistance() {
		return 0.0;
	}
	

	
	public List getClassificationResults() {
		return _classificationResults;
	}
	
	private List _classificationResults;
	private Map _trainingSet;
}
