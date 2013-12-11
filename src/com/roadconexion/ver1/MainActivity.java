package com.roadconexion.ver1;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	// url to make request
	private static String url = "http://www.roadconexion.com/reports/.json";
	
	// JSON Node names
	private static final String TAG_REPORTS = "reports";
	private static final String TAG_USERID = "user";
	private static final String TAG_ROADNAME = "road_name";
	private static final String TAG_REPORT = "report";
	private static final String TAG_REPORTTYPE = "type_report";
	private static final String TAG_DATE = "created_on";
	
	// reports JSONArray
	JSONArray reports = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Hashmap for ListView
		ArrayList<HashMap<String, String>> reportList = new ArrayList<HashMap<String, String>>();

		// Creating JSON Parser instance
		JSONParser jParser = new JSONParser();

		// getting JSON string from URL
		JSONObject json = jParser.getJSONFromUrl(url);

		try {
			// Getting Array of Reports
			reports = json.getJSONArray(TAG_REPORTS);
			
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
		
		
		/**
		 * Updating parsed JSON data into ListView
		 * */
		ListAdapter adapter = new SimpleAdapter(this, reportList,
				R.layout.list_item,
				new String[] { TAG_USERID, TAG_ROADNAME, TAG_REPORT, TAG_REPORTTYPE, TAG_DATE }, new int[] {
						R.id.created_on, R.id.road_name, R.id.report, R.id.type_report, R.id.created_on });

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();

		
		
		

	}

}