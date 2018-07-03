import org.json.simple.JSONObject;

public class Nouvelle {
	
	private String title;
	private String description;
	private String url;
	private long publishedAt;
	
	private void setTitle(String title) {
		this.title = title;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	private void setUrl(String url) {
		this.url = url;
	}
	private void setPublishedAt(long publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getUrl() {
		return url;
	}
	public long getPublishedAt() {
		return publishedAt;
	}
	
	public Nouvelle(String title, String description, String url, long publishedAt) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.publishedAt = publishedAt;
		
	}
	
	public String toString() {
		return "title : " + this.getTitle() + "\n" 
			+ "description : " + this.getDescription() + "\n" 
			+ "url : " + this.getUrl() + "\n" 
			+ "publishedAt : " + String.valueOf(this.getPublishedAt()) + "\n";
	}

}
