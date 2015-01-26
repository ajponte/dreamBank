package classify;

import java.util.List;
import java.util.Map;
/** A classifier will perform the classification 
 *  algorithm on data. 
 *  Each classifier will classify observations
 *  and classes of the observations.
 *  The Observations will be of Type OBSERVATIONTYPE and the 
 *  Classifications will be of Type CLASSIFICATIONTYPE.  
 *  
 *  @author Alan Ponte
 */

public abstract class Classifier<ObservationType, ClassificationType> {
	
	/** Represents an observation in the Classifier. */
	public class Observation {
		
		/** A new observation, which is OBSERVATION. */
		public Observation(ObservationType observation) {
			_observation = observation;
		}
		
		/** Returns the data of THIS Observation. */
		public ObservationType getObservation() {
			return _observation;
		}
		private ObservationType _observation;
	}
	
	/** Represents a Classification of data in the Classifier. */
	public class Classification {
		/** A new Classification, which is CLASSIFICATION. */
		public Classification(ClassificationType classification) {
			_classification = classification;
		}
		
		/** Returns the data of THIS Classification. */
		public ClassificationType getClassification() {
			return _classification;
		}
		private ClassificationType _classification;
	}
	
}
