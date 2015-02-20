public class Application {
	public static void main(String[] args) {

		// Create a new XmlGenerator object.
		XmlGenerator xmlGen = new XmlGenerator();
		// Set the path for the index file.
		xmlGen.setCsvPath("C:\\Test\\mic1988\\1988.csv");
		// Read in CSV file and place into memory.
		xmlGen.readInCsvData();
		
		// Write stored properties out to an XML file.
		// Move on to the next record in memory.
	}
}
