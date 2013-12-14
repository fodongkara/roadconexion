package com.roadconexion.ver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.roadconexion.ver1.R;
import android.app.Activity;
import android.app.ListActivity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {

    // url to make request
    private static String url = "http://www.roadconexion.com/reports/?format=json";
    
    // JSON Node names
    private static final String TAG_REPORTTYPE = "type_report";
    private static final String TAG_USERID= "user";
    private static final String TAG_ROADNAME= "road_name";
    private static final String TAG_REPORT= "report";
    private static final String TAG_DATE= "created_on";
	
	JSONArray reports = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
        new HttpAsyncTask().execute(url);
	}
	
	public void ReportList(JSONArray reports){
		
		setContentView(R.layout.activity_main);
		
		ArrayList<HashMap<String, String>> reportList = new ArrayList<HashMap<String, String>>();
		
		try {
            // looping through All Contacts
            for(int i = 0; i < reports.length(); i++){
                JSONObject c = reports.getJSONObject(i);
                
                // Storing each json item in variable
                String user = c.getString(TAG_USERID);
                String road_name = c.getString(TAG_ROADNAME);
                String report = c.getString(TAG_REPORT);        
                String type_report = c.getString(TAG_REPORTTYPE);
                String created_on = c.getString(TAG_DATE);
                
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
                
                // adding each child node to HashMap key => value
                map.put(TAG_USERID, user);
                map.put(TAG_ROADNAME, road_name);
                map.put(TAG_REPORT, report);
                map.put(TAG_REPORTTYPE, type_report);
                map.put(TAG_DATE, created_on);

                // adding HashList to ArrayList
                reportList.add(map);
                
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
		//ListAdapter adapter = new SimpleAdapter(this, reportList,
		ListAdapter adapter = new SimpleAdapter(MainActivity.this,reportList,R.layout.list_view,new String[] { TAG_USERID, TAG_ROADNAME, TAG_REPORT, TAG_REPORTTYPE, TAG_DATE },
				new int[] {R.id.UserID, R.id.RoadName, R.id.ReportInfo, R.id.ReportType, R.id.CreatedDate }	);
		setListAdapter(adapter);
	}
	
	public static void POST(String url2) {
		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();
		// Creating HTTP Post
		HttpPost httpPost = new HttpPost("http://10.0.2.2:8000/users/");

		// Building post parameters
		// key and value pair
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("username", "the_user"));
		nameValuePair.add(new BasicNameValuePair("email", "userzzz@gmail.com"));

		// Url Encoding the POST parameters
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
		} catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}

		// Making HTTP Request
		try {
			HttpResponse response = httpClient.execute(httpPost);
			// writing response to log
			Log.d("Http Response:", response.toString());
		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();

		}
	}

	public static String GET(String url) {
		InputStream inputStream = null;
		String result = "";
		System.out.print("here");
		try {

			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();
			JSONObject json = null;
			// convert inputstream to string
			if (inputStream != null)

				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;
	}

	public boolean isConnected() {
		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected())
			return true;
		else
			return false;
	}
	
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			System.out.print(urls[0]);
			return GET(urls[0]);
		}

		//onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			try {
				JSONArray json = new JSONArray(result);
				ReportList(json);
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
}