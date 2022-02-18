package client;

import java.util.List;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import exception.NewsApiException;
import model.ErrorResponse;
import model.NewsInfo;
import model.Newsresult;
import model.SourcesInfo;
import model.SourcesResult;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;


@Service
public class RestConsumer {
	  
	
	  public static Newsresult  get_API_data (Map<String ,String> params,String extension ) throws NewsApiException {
		 
		 
		 String uri =MyUrl.getUrl(params,extension);
		 
		 
		 HttpEntity entity;
		 
		 final HttpGet getRequest = new HttpGet(uri);
//		 uri.substring(uri.indexOf('?'), uri.length());
		 
		 final CloseableHttpClient httpclient = HttpClients.createDefault();
		 try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
				  entity = response.getEntity();
				 ObjectMapper mapper = new ObjectMapper();

				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
					if (errorResponse.getMessage() != null)
						throw new NewsApiException ("Error occurred on API call: " + errorResponse.getMessage());
				}
				
				return mapper.readValue(entity.getContent(), Newsresult.class);
			} 
		 
		 catch (IOException e) {
			 	
				throw new NewsApiException ("Error requesting data from the News API.", e);
			}
		 
		 
	  }
	  
	
	  
	  public static List <NewsInfo> get_Data(Map<String ,String> params,String extension ) throws NewsApiException {
		    Newsresult result = get_API_data (params,extension);
			List<NewsInfo> newsInfoList = new ArrayList<>(result.getArticles().size());
			for (model.Result theResult : result.getArticles()) {
				newsInfoList.add(new NewsInfo(theResult));
			}
			return newsInfoList;
		}
	  
	  
	  
	  
	  
	  public static SourcesResult  get_API_data_sources () throws NewsApiException {
			 
		  	 String extension="v2/top-headlines/sources";
		     Map <String, String> params= new HashMap<String, String>() ;
			 String uri =MyUrl.getUrl(params,extension);
			 
			 HttpEntity entity;
			 
			 final HttpGet getRequest = new HttpGet(uri);
//			 uri.substring(uri.indexOf('?'), uri.length());
			 
			 final CloseableHttpClient httpclient = HttpClients.createDefault();
			 try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
					  entity = response.getEntity();
					 ObjectMapper mapper = new ObjectMapper();

					if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
						ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
						if (errorResponse.getMessage() != null)
							throw new NewsApiException ("Error occurred on API call: " + errorResponse.getMessage());
					}
					
					return mapper.readValue(entity.getContent(), SourcesResult .class);
				} 
			 
			 catch (IOException e) {
				 	
					throw new NewsApiException ("Error requesting data from the News API.", e);
				}
			 
			 
		  }
	  
	  
	  
	  
	  public static List <SourcesInfo> get_Data_sources() throws NewsApiException {
		    SourcesResult result = get_API_data_sources ();
			List<SourcesInfo> sourcesInfoList = new ArrayList<>(result.getSources().size());
			for (model.Source theResult : result.getSources()) {
				sourcesInfoList.add(new SourcesInfo(theResult));
			}
			return sourcesInfoList;
		}
	  
	  
	  
	  
	  
	  
	
	 
}