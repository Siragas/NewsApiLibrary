package model;

public class NewsInfo {
	
	private   String title;
	private   String description;
	private   String release_date;
	private   String web_adress;
	private   String source;
	
	
	public NewsInfo(String title, String description, String release_date, String web_adress,String source) {
		super();
		
		this.title = title;
		this.description = description;
		this.release_date = release_date;
		this.web_adress = web_adress;
		this.source = source;
	}

	public NewsInfo(Result theResult) {
		
		this.title=theResult.getTitle();
		this.description = theResult.getDescription();
	    this.release_date = theResult.getPublishedAt();
	    this.web_adress = theResult.getUrl();
		this.source = theResult.getSource().getName();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getWeb_adress() {
		return web_adress;
	}

	public void setWeb_adress(String web_adress) {
		this.web_adress = web_adress;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "NewsInfo [title=" + title + ", description=" + description + ", release_date=" + release_date
				+ ", web_adress=" + web_adress + ", source=" + source + "]";
	}

	
	

	
	
	
	
	
	
	

}
