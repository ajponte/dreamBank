package getData;

public class Main {
	public static void main(String[] args) {
		String dbName = "dreambank";
		String collName = "test";
		MongoDB db = new MongoDB(dbName, collName);
		db.connect();
		
	}
}
