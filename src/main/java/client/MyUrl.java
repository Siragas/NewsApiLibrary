package client;

import java.util.Map;

public class MyUrl {
	
	private static final String apikey = "6edd8bf798ac46ed8cc69b2094cd214b";
	private String baseUrl;
	private String extension;
	private Map<String,String> parameters;
	//https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=6edd8bf798ac46ed8cc69b2094cd214b
	


	public String getBaseUrl() {
		return baseUrl;
	}

	public MyUrl(String baseUrl, String extension, Map<String,String> parameters) {
		super();
		this.baseUrl = baseUrl;
		this.extension = extension;
		this.parameters = parameters;
	}
	
	public MyUrl(String baseUrl, String extension) {
		super();
		this.baseUrl = baseUrl;
		this.extension = extension;
		
	}
	
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	

	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public String buildUrl() {
		StringBuilder builder = new StringBuilder()
								.append(baseUrl)
								.append("/")
								.append(extension)
								.append("?");
		for(String s : parameters.keySet()) {
			builder.append(s).append("=").append(parameters.get(s)).append("&");
		}
		String ur = builder.toString();
		ur=ur.substring(0,ur.length()-1);
		
		return ur;
								
	}
	
	
	
	public static String getUrl(Map<String, String> params,String extension){
		
		params.put("apiKey", apikey);

		
		MyUrl url = new MyUrl("https://newsapi.org", extension , params );		
		
		final String finalUrl = url.buildUrl();
		
		return finalUrl;
		
	}

	@Override
	public String toString() {
		return "MyUrl [baseUrl=" + baseUrl + ", extension=" + extension + ", parameters=" + parameters + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
