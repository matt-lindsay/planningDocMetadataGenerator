import java.util.Properties;
import java.io.*;

public class XmlGenerator {
	// State variables (12 tokens).
	private String csvPath;
	
	private String title; // File Number.
	private String description; // Description.
	private String created; // Document Date.
	private String author; // Null.
	private String publisher; // Surrey Heath BC.
	private String contributor; // Null.
	private String type; // 'Planning Case File'.
	private String identifier; // Filepath.
	private String source; // Null.
	private String coverage; // Null.
	private String rights; // 'Planning Public'.
	private String subject; // CaseFullRef.
	private String path; // Output path for XML file.
	
	// Setters.
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	// Getters.
	public String getCsvPath() {
		return csvPath;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCreated() {
		return created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getContributor() {
		return contributor;
	}
	
	public String getType() {
		return type;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getCoverage() {
		return coverage;
	}
	
	public String getRights() {
		return rights;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getPath() {
		return path;
	}
	
	// Methods.
	public void readInCsvData() {
		BufferedReader reader = null;
		String line = "";
		String csvSplitBy = ",";
		
		try {
			reader = new BufferedReader(new FileReader(getCsvPath()));
			// Start Looping through each record in memory.
			while ((line = reader.readLine()) != null) {
				// Separate each token when a ',' is found. Place each token into a property.
				String[] records = line.split(csvSplitBy);
				
				this.setTitle(records[1]);
				this.setDescription(records[2]);
				this.setCreated(records[3]);
				this.setAuthor(records[4]);
				this.setPublisher(records[5]);
				this.setContributor(records[6]);
				this.setType(records[7]);
				this.setIdentifier(records[8]);
				this.setSource(records[9]);
				this.setCoverage(records[10]);
				this.setRights(records[11]);
				this.setSubject(records[12]);
				this.setPath(records[13]);
				
				//System.out.println(getTitle() + " " +  getDescription() + " " + getCreated() + " " + getIdentifier() + " " + getSubject() + " " + getPath());
				
				xmlCreater();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void xmlCreater() throws IOException {
		Properties prop = new Properties();
		prop.setProperty("type", "cm:content");
		prop.setProperty("aspects", "cm:versionable,cm:dublincore");
		prop.setProperty("cm:title", this.getTitle());
		prop.setProperty("cm:description", this.getDescription());
		prop.setProperty("cm:created", this.getCreated());
		// cm:dublincore properties.
		prop.setProperty("cm:author", this.getAuthor());
		prop.setProperty("cm:publisher", this.getPublisher());
		prop.setProperty("cm:contributor", this.getContributor());
		prop.setProperty("cm:type", this.getType());
		prop.setProperty("cm:identifier", this.getIdentifier());
		prop.setProperty("cm:dcsource", this.getSource());
		prop.setProperty("cm:coverage", this.getCoverage());
		prop.setProperty("cm:rights", this.getRights()); // User groups?
		prop.setProperty("cm:subject", this.getSubject());
		
		FileOutputStream fos = new FileOutputStream(this.getPath() + ".metadata.properties.xml");
		prop.storeToXML(fos, "IndexData");
		fos.close();
		
		System.out.println(this.getPath() + ".metadata.properties.xml");
	}
}
