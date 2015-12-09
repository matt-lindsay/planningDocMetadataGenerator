public class Application {
	public static void main(String[] args) {

		// Create a new XmlGenerator object.
		XmlGenerator xmlGen = new XmlGenerator();
		// Set the path for the index file.
		//xmlGen.setCsvPath("C:\\Document\\doc1.csv"); // Windows file system.
		xmlGen.setCsvPath("/home/user/Documents/doc1.csv"); // Unix / Linux file system.
		// Read in CSV file and place into memory.
		xmlGen.readInCsvData();
	}
}
