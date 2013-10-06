/**
 * 
 */
package br.com.econcursos.webservice;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Paulo
 *
 */
public abstract class HttpServiceClientFactory {
	
	private static final String USERNAME_HTTP_CLIENT = "mconcurso";
	private static final String PASSWORD_HTTP_CLIENT= "mconcurso";
	
	private static HttpClient httpConcursosClient;
	
	public static HttpClient getInstance() {
		
		if(httpConcursosClient == null ) {
			httpConcursosClient = getConcursosHttpClient();;
		}		
		return httpConcursosClient;
	}

	private static HttpClient getConcursosHttpClient() {
		
	    CredentialsProvider credProvider = new BasicCredentialsProvider();
	    credProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
	        new UsernamePasswordCredentials(USERNAME_HTTP_CLIENT, PASSWORD_HTTP_CLIENT));
	    
	    DefaultHttpClient client = new DefaultHttpClient();
	    client.setCredentialsProvider(credProvider);
		
		return client;
	}
}

