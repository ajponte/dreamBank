package classifyTests;

import org.junit.Test;

import classify.SimpleNearestClassifier;
import classify.Classifier;

import java.util.ArrayList;
import java.util.HashMap;
public class TestSimpleNearestNeighbors {
	
	@Test
	public void test() {
		HashMap<Double, Double> trainingSet = new HashMap<Double, Double>();
		trainingSet.put(0.0, 1.0);
		trainingSet.put(1.0, 4.0);
		
		ArrayList<Double> vals = new ArrayList<Double>();
		vals.add(2.4);
		vals.add(3.3);
		Classifier c = new SimpleNearestClassifier(trainingSet);
		c.classify(vals);
	}

}
