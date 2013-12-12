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
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	// url to make request
	//private static String url = "http://www.roadconexion.com/reports/.json";
	String TAG_REPORTTYPE = null;
	String TAG_USERID = null;
	String TAG_ROADNAME = null;
	String TAG_REPORT = null;
	String TAG_DATE = null;
	
	ArrayList<HashMap<String, String>> reportList = new ArrayList<HashMap<String, String>>();
	// reports JSONArray
	JSONArray reports = null;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// creating new HashMap
                //HashMap<String, String> map = new HashMap<String, String>();
                
               

                // adding HashList to ArrayList
                //reportList.add(map);
        
		//ListAdapter adapter = new SimpleAdapter(this, reportList,
		ListAdapter adapter = new SimpleAdapter(MainActivity.this, reportList,
                    R.layout.list_view,
                    new String[] { TAG_USERID, TAG_ROADNAME, TAG_REPORT, TAG_REPORTTYPE, TAG_DATE }, new int[] {
                            R.id.UserID, R.id.RoadName, R.id.ReportInfo, R.id.ReportType, R.id.CreatedDate });

            setListAdapter(adapter);
            
		

	}

}