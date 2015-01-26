package predictStock;

import classify.Classifier;
import classify.SimpleNearestClassifier;
import getData.MongoDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/** Fetches a single stock, by running a classification 
 *  algorithm on the data.
 *  @author Alan Ponte
  */
public class StockGetter {
	
	/** A new StockGetter which will use VALS
	 *  to get a stock by running classification
	 *  on the training set we have in the DB
	 *  on the user. */
	public StockGetter(ArrayList<String> vals) {
		_db = new MongoDB("dreamBank", "test");
		String userEmail = vals.get(1);
		_trainingSet = toMap(getUserTrainingSet(vals.get(1)));
		_classifier = new SimpleNearestClassifier<String, String>(_trainingSet);
		_vals = getVals(vals);
	}
	
	/** Parses the input VALS and returns a new 
	 *  List of values, each of type Double. */
	public ArrayList<Double> getVals(ArrayList<String>vals) {
		ArrayList<Double> newVals = new ArrayList<Double>();
		for (int i = 1; i < vals.size(); i += 1) {
			double currentVal = Double.parseDouble(vals.get(i));
			newVals.add(currentVal);
		}
		return newVals;
		
	}
	/** Finds a stock, and returns a list, which will
	 *  represent the values of the stock. */
	public ArrayList<String> getStock() {
		this._classifier.classify(_vals);
		return null;
	}
	
	/** Returns the Training Set in the DB related to the user,
	 *  who is identified by their EMAIL. */
	public String getUserTrainingSet(String email) {
		return _db.find("{email: " + email + "}");
	}
	
	/** Given a JSON string, returns a Map representation. */
	public Map toMap(String str) {
		//TODO
		return null;
	}
	private SimpleNearestClassifier<String, String> _classifier;
	private MongoDB _db;
	private Map _trainingSet;
	private ArrayList<Double> _vals;

}
