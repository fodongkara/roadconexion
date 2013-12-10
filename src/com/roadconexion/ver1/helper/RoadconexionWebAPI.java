package com.roadconexion.ver1.helper;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.roadconexion.ver1.R;
import com.roadconexion.ver1.MainActivity;
import com.roadconexion.ver1.data.ReportData;
import com.roadconexion.ver1.helper.RoadconexionHelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

//public class RoadconexionWebAPI extends AsyncTask<String, Integer, String>
public class RoadconexionWebAPI extends AsyncTask<String, Integer, String>
//private class RoadconexionWebAPI extends AsyncTask<Void, Void, Void> {
{
	
	private ProgressDialog dialog;
	private Context context;
	private MainActivity activity;
	private static final String debugTag = "RoadconexionWebAPI";
	//private static final int String = 0;
	//ArrayList<ReportData> myReports;
	//ArrayList<ReportData> reportdata;

	
    public RoadconexionWebAPI(MainActivity activity) {
		super();
		this.activity = activity;
		this.context = this.activity.getApplicationContext();
	}



		
		
		//#Override
		protected String doInBackground(String... params) {
		//protected void doInBackground(Void... params) {
	        try {
	        	//Thread.sleep(5000);
	        	Log.d(debugTag,"Background:" + Thread.currentThread().getName());
	            String result = RoadconexionHelper.downloadFromServer(params);
	            return result;
	        } catch (Exception e) {
	        //} catch (InterruptedException e) {
	        	//e.printStackTrace();
	            return new String();
	        }
	       // return null;
	    }
		//

	

	

    @Override
    protected void onPostExecute(String result) 
    {
    	//dialog.dismiss();
    	//ArrayList<ReportData> reportdata = new ArrayList<ReportData>();
    	//ArrayList<ReportData> myReports = new ArrayList<ReportData>(); 
    	ArrayList<ReportData> reportdata = new ArrayList<ReportData>();
    	
        
        try {
			//JSONObject json = new JSONObject(result);
        	
			//JSONObject data = json.getJSONObject("reports");
			
			JSONArray reports = new JSONArray(result);
			for(int i=0; i<reports.length(); i++) {
			//for(int i=0; i<5; i++) {
				//JSONObject myReport = reports.getJSONObject(i);
				JSONObject report = reports.getJSONObject(i);
				//JSONObject json_data = reports.getJSONObject(i);
				String roadName = report.getString("road_name");
				String reportInfo = report.getString("report");
				String reportType = report.getString("type_report");
				String createdDate = report.getString("created_on");
				String userID = report.getString("user");
			
				//myReports.add(new ReportData(roadName, reportInfo, reportType, createdDate, userID));
				reportdata.add(new ReportData(roadName, reportInfo, reportType, createdDate, userID));

			}
			
		} 
        catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		this.activity.setReports(reportdata);
        //myReports.notifyDataSetChanged();
        //used to be
		//this.activity.setReports(myReports, null);
		//this.activity.setReports(myReports, myReports);
		//super.onPostExecute(result);
             
    }



	



	
}




	

    
    
    
//}
