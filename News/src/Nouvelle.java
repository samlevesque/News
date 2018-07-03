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
	
	public Nouvelle(JSONObject nouvelle) {
		
	}

}
