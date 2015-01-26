package classify;

import java.util.Map;
import java.util.List;
/** A K-Nearest Neighbor Classifier, which will classify 
 *  data from a training set using the K-Nearest Neighbor 
 *  algorithm.
 * @author Alan Ponte
 */
public class KnearestClassifier<ObservationType, ClassificationType> 
				extends Classifier<ObservationType, ClassificationType> {

	
	/** A new KnearestClassifier which will grab training 
	 *  set data from TRAININGSET. The TRAININGSET is a map
	 *  from observations to classes. */
	public KnearestClassifier(Map trainingSet) {
		_trainingSet = trainingSet;
	}
	
	/** Returns the Training Set of THIS Classifier. */
	public Map getTrainingSet() {
		return _trainingSet;
	}
	
	/** Adds the KEY and VALUE to the training set. */
	public void addToTrainingSet(ObservationType key, ClassificationType value) {
		_trainingSet.put(key, value);
	}
	
	/** Runs the K-Nearest neighbor algorithm on the training set. */
	public ClassificationType runAlgorithm() {
		// TODO
		return null;
	}
	
	/** The Training Set used in THIS classifier. */
	private Map _trainingSet;
}
