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
	//private ProgressDialog progDialog;
	private Context context;
	private MainActivity activity;
	private static final String debugTag = "RoadconexionWebAPI";

	/**
	 * Construct a task
	 * @param activity
	 */
    public RoadconexionWebAPI(MainActivity activity) {
		super();
		this.activity = activity;
		this.context = this.activity.getApplicationContext();
	}

	@Override
    protected void onPreExecute() {
        super.onPreExecute(); 
    	//progDialog = ProgressDialog.show(this.activity, "Search", this.context.getResources().getString(R.string.looking_for_reports) , true, false);
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
    	
    	//progDialog.dismiss();
        //if (result.length() == 0) {
        //    this.activity.alert ("Unable to find post");
        //    return;
        //}
        
        try {
			JSONObject respObj = new JSONObject(result);
			//JSONObject topReports = respObj.getJSONObject("reports");
			JSONObject report = respObj.getJSONObject("reports");
			JSONArray reports = topReports.getJSONArray("reports");
			for(int i=0; i<reports.length(); i++) {
				JSONObject report = reports.getJSONObject(i);	
				String roadName = report.getString("road_name");
				String reportInfo = report.getString("report_info");
				String reportType = report.getString("type_report");
				String createdDate = report.getString("created_on");
				String userID = report.getString("user_id");
				//JSONObject artistObj = track.getJSONObject("artist");
				//String artistName = artistObj.getString("name");
				//String artistUrl = artistObj.getString("url");
				//String imageUrl;
				//try {
				//	JSONArray imageUrls = track.getJSONArray("image");
				//	imageUrl = null;
				//	for(int j=0; j<imageUrls.length(); j++) {
				//		JSONObject imageObj = imageUrls.getJSONObject(j);
				//		imageUrl = imageObj.getString("#text");
				//		if(imageObj.getString("size").equals("medium")) {
				//			break;
				//		}
				//	}
				//} catch (Exception e) {
				//	imageUrl = null;
				//}
				
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
