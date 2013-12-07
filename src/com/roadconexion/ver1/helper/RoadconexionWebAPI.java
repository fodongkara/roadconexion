package com.roadconexion.ver1.helper;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.roadconexion.ver1.R;
import com.roadconexion.ver1.MainActivity;
import com.roadconexion.ver1.data.ReportData;
import com.roadconexion.ver1.helper.RoadconexionHelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RoadconexionWebAPI extends AsyncTask<String, Integer, String>
{
	
	private Context context;
	private MainActivity activity;
	private static final String debugTag = "RoadconexionWebAPI";
	private static final int String = 0;

	
    public RoadconexionWebAPI(MainActivity activity) {
		super();
		this.activity = activity;
		this.context = this.activity.getApplicationContext();
	}

	    @Override
    protected String doInBackground(String... params) {
        try {
        	Log.d(debugTag,"Background:" + Thread.currentThread().getName());
            String result = RoadconexionHelper.downloadFromServer(params);
            return result;
        } catch (Exception e) {
            return new String();
        }
    }

    @Override
    protected void onPostExecute(String result) 
    {
    	
    	//ArrayList<ReportData> reportdata = new ArrayList<ReportData>();
    	ArrayList<ReportData> myReports = new ArrayList<ReportData>();
    	
    	
        
        try {
			//JSONObject respObj = new JSONObject(result);
			//JSONObject topReports = respObj.getJSONObject("reports");
			//JSONObject report = respObj.getJSONObject("reports");
			//JSONArray reports = ((JSONArray)myReports).optJSONArray(String);
			JSONArray reports = new JSONArray(result);
			for(int i=0; i<reports.length(); i++) {
				//JSONObject myReport = reports.getJSONObject(i);
				JSONObject report = reports.getJSONObject(i);
				//JSONObject json_data = reports.getJSONObject(i);
				String roadName = report.getString("road_name");
				String reportInfo = report.getString("report_info");
				String reportType = report.getString("type_report");
				String createdDate = report.getString("created_on");
				String userID = report.getString("user_id");
				
				
				//reportdata.add(new ReportData(road_name,report,type_report, created_on, user));		
				//reportdata.add(new ReportData(roadName, reportInfo, reportType, createdDate, userID));
				myReports.add(new ReportData(roadName, reportInfo, reportType, createdDate, userID));		

			
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.activity.setReports(reportdata);
		this.activity.setReports(myReports);
             
    }
}




	

    
    
    
//}
