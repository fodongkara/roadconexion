package com.roadconexion.ver1.helper;


import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpResponse;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.HttpEntity;
//import org.apache.http.InputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
//import java.io.ByteArrayInputStream;

public class RoadconexionHelper {
	private static final String RoadConexionReportURL = "http://www.roadconexion.com/reports/.json";
	private static final int HTTP_STATUS_OK = 200;
	private static byte[] buff = new byte[1024];
	//private static final String tagtag = "RoadConexionReportURL";

	public static class ApiException extends Exception {
	private static final long serialVersionUID = 11;
	
	
		public ApiException(String msg)
		{
			super(msg);
		}
		
		public ApiException(String msg, Throwable thr)
		{
			super(msg, thr);
		}
	}
	/**
	 * pull the server info
	 */
	
	//protected static synchronized String downloadFromServer (String... params) 
	protected static synchronized String downloadFromServer (String... params)
	throws ApiException
	
	{
		
		String url = RoadConexionReportURL;
		String retval = null;



		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();
		

		// Creating HTTP Post
		//this is a post
		//HttpPost httpPost = new HttpPost(
		//		"http://www.roadconexion.com/user");

		//the get
		HttpGet request = new HttpGet(url);


		// Making HTTP Request
		try {
			HttpResponse response = httpClient.execute(request);
			StatusLine status = response.getStatusLine();
			if (status.getStatusCode() != HTTP_STATUS_OK){
				//handle status exception
				throw new ApiException("Invalid Request" + status.toString());
			}

			// process the content
			HttpEntity entity = response.getEntity();
			InputStream ist = entity.getContent();
			ByteArrayOutputStream content = new ByteArrayOutputStream();

			int readCount = 0;
			while ((readCount = ist.read(buff)) != -1) {
				content.write(buff, 0, readCount);

			}
			retval = new String (content.toByteArray());



			//Log.d("Http Response:", response.toString());


		} catch (Exception e) {
			// writing exception to log
			throw new ApiException("Unable to connect to Server, try again later" + e.getMessage(), e);
			//e.printStackTrace();
		} 
		//catch (IOException e) {
			// writing exception to log
//			e.printStackTrace();

		return retval;
///
	//	}
	}
	
}
