package classify;

/** Distancer will represent the distance between two 
 *  points of type TYPE.
 *  @author Alan Ponte
 */
public interface Distancer<Type> {
	
	/** Returns the distance from X to Y. */
	double dist(Type x, Type y);

}
