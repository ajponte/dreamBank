package getData;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;

import java.net.UnknownHostException;


/** MongoDB connects to the Mongo Labs instance
 *  through the RESTful API.
 *  
 * @author Alan Ponte
 */

public class MongoDB {
	
	/** A new MongoDB connection to the database named DBNAME
	 *  and collection COLLECTIONNAME. */
	public MongoDB(String dbName, String collectionName) {
		_dbName = dbName;
		_collectionName = collectionName;
	}
	
	/** Performs a connection to the database. */
	public void connect() {
		_textUri = "mongodb://aponte:R@gnaros89@ds063180.mongolab.com:63180/" + _collectionName;
		_uri = new MongoURI(_textUri);
		try {
			_mongo = new Mongo(_uri);
		} catch (UnknownHostException uhe) {
			System.out.println("Error connecting to mongolabs: " + uhe.getMessage());
		}

		System.out.println("Connected to database: " + _dbName 
				+ " collection: " + _collectionName);	
	}
	
	/** Returns a string representing the data returned
	 *  from performing the QUERY. */
	public String find(String query) {
		//TODO
		return "";
	}
	
	private String _dbName;
	private String _collectionName;
	
	/** The URI which will be the connection to the MongoLabs instance. */
	private String _textUri;
	
	private MongoURI _uri;
	
	private Mongo _mongo;

}
