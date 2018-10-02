package com.roadconexion.ver1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import com.actionbarsherlock.app.SherlockListFragment;

public class FragmentUpdates extends SherlockListFragment {
	private static String url = "http://www.roadconexion.com/reports/?format=json";
	private static final String TAG_REPORTTYPE = "type_report";
	private static final String TAG_USERID = "user";
	private static final String TAG_ROADNAME = "road_name";
	private static final String TAG_REPORT = "report";
	private static final String TAG_DATE = "created_on";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.allupdates, container, false);
		new HttpAsyncTask().execute(url);
		return view;
	}
	
	@SuppressLint("SimpleDateFormat")
	public String DateFormat(String rawDate){
		StringBuffer sbDate = new StringBuffer();
		sbDate.append(rawDate);
		String subDate = sbDate.substring(0, 19).toString();
		String stripDate = subDate.replace("T", " ");
		String newDate = stripDate.replaceAll("-", "/");
		
		long epoch = 0;
		
		try {
			epoch = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(newDate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date currentDate = new Date();
		long diffInSeconds = (currentDate.getTime() - epoch) / 1000;
		String elapsed = "";
		long seconds = diffInSeconds;
		long mins = diffInSeconds / 60;
		long hours = diffInSeconds / 3600;
		long days = diffInSeconds / 86400;
		long weeks = diffInSeconds / 604800;
		long months = diffInSeconds / 2592000;

		if (seconds < 120) {
		    elapsed = "one minute ago";
		} else if (mins < 60) {
		    elapsed = mins + " minutes ago";
		} else if (hours < 24) {
		    elapsed = hours + " " + (hours > 1 ? "hrs" : "hr")+ " ago";
		} else if (hours < 48) {
		    elapsed = "one day ago";
		} else if (days < 7) {
		    elapsed = days + " days ago";
		} else if (weeks < 5) {
		    elapsed = weeks + " " + (weeks > 1 ? "weeks" : "week") + " ago";
		} else if (months < 12) {
		    elapsed = months + " " + (months > 1 ? "months" : "months")+ " ago";
		} else {
		    elapsed = "more than a year ago";
		}
		return elapsed;
	}

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			System.out.print(urls[0]);
			new JSONActivity();
			return JSONActivity.GET(urls[0]);
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			try {
				JSONObject json = new JSONObject(result);
				ReportList(json);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		private void ReportList(JSONObject reports) throws JSONException {

			ArrayList<HashMap<String, String>> reportList = new ArrayList<HashMap<String, String>>();

			try {
				// looping through All Contacts
				JSONArray results = reports.getJSONArray("results");
				
				for (int i = 0; i < results.length(); i++) {
					
					JSONObject c = results.getJSONObject(i);

					// Storing each json item in variable
					String user = c.getString(TAG_USERID);
					String road_name = c.getString(TAG_ROADNAME);
					String report = c.getString(TAG_REPORT);
					String type_report = c.getString(TAG_REPORTTYPE);
					//Date created_on_raw = (Date) c.get(TAG_DATE);
					//String created_on_raw = c.getString(TAG_DATE);
					String created_on = DateFormat(c.getString(TAG_DATE));
	
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

			ListAdapter adapter = new SimpleAdapter(getActivity(), reportList,
					R.layout.list_view,
					new String[] { TAG_USERID, TAG_ROADNAME, TAG_REPORT,
							TAG_REPORTTYPE, TAG_DATE }, new int[] {
							R.id.UserID, R.id.RoadName, R.id.ReportInfo,
							R.id.ReportType, R.id.CreatedDate });

			setListAdapter(adapter);
		}
	}
}