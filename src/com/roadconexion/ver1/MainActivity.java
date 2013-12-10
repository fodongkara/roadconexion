package com.roadconexion.ver1;

import java.util.ArrayList;

import android.app.Activity;
//import android.app.ProgressDialog;
import android.content.Context;
//import android.os.AsyncTask;
import android.os.Bundle;
//import android.widget.ListAdapter;
//import android.view.LayoutInflater;
import android.widget.ListView;

import com.roadconexion.ver1.adapters.ReportDataAdapter;
import com.roadconexion.ver1.data.ReportData;
import com.roadconexion.ver1.helper.RoadconexionWebAPI;

//import com.roadconexion.ver1.R;

public class MainActivity extends Activity {
	
	//RoadconexionWebAPI = new RoadconexionWebAPI();
	// private static final ListAdapter ReportDataAdapter = null;
	// private static final String[] ReportData = {"Dan"};
	ListView reportList;
	//Context context = MainActivity.this;
	Context context;
	//public void setReports(ArrayList<ReportData> myReports, Object object) {
	//public void setReports(ArrayList<ReportData> reportdata) {
		// TODO Auto-generated method stub
		
	//}
	//setReports(ArrayList<ReportData> myReports2, Object object)

	//ArrayList<ReportData> myReports = new ArrayList<ReportData>();
	ArrayList<ReportData> reportdata = new ArrayList<ReportData>();
	
	// private LayoutInflater layoutInflator;
	//for testing
	/*String[] roadName = new String[] { "Kira Road", "Kampala Road" };
	String[] reportType = new String[] { "Road Status", "Traffic Jam" };
	String[] reportInfo = new String[] {
			"There is alot of jam next to the police",
			"Kampala Road is flooded, causing alot of jam" };
	String[] createdDate = new String[] { "11-11-2013", "11-11-2013" };
	String[] userID = new String[] { "1", "37" };
*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// context = this;
		setContentView(R.layout.activity_main);
		context = this;

		// this.inMgr = (InputMethodManager)
		// getSystemService(Context.INPUT_METHOD_SERVICE);

		reportList = (ListView) findViewById(R.id.report_list);
		// ReportDataAdapter ad= new ReportDataAdapter(myReports, this,
		// layoutInflator);
		//ReportDataAdapter ad = new ReportDataAdapter(context, myReports);
		ReportDataAdapter ad = new ReportDataAdapter(context, reportdata);
		// ReportDataAdapter ad = new ReportDataAdapter(myR)
		reportList.setAdapter(ad);
		//for testing
		//getDataInList();
		
		
		//ReportDataTask loaderTask = new ReportDataTask();
		
		
		//test
		//RoadconexionWebAPI loaderTask = new RoadconexionWebAPI(MainActivity.this);
		
		//loaderTask.execute();
		
		
		// oh God!!!!!
		// setReports(rmyeports);

		// reportList.setAdapter(new ReportDataAdapter(context, myReports));

	}

	//public void setReports(ArrayList<ReportData> myReports2)
	//public void setReports(ArrayList<ReportData> myReports2)
	public void setReports(ArrayList<ReportData> reportdata) {
		// TODO Auto-generated method stub
		
	}

	

}

	
	/*
	public void getDataInList() {
		for (int i = 0; i < 2; i++) {
			ReportData ld = new ReportData();
			ld.setRoadName(roadName[i]);
			ld.setReportType(reportType[i]);
			ld.setReportInfo(reportInfo[i]);
			ld.setCreatedDate(createdDate[i]);
			ld.setUserID(userID[i]);

			myReports.add(ld);
		}
	}

	public void setReports(ArrayList<ReportData> myReports2, Object object) {
		// TODO Auto-generated method stub

	};

	// }

	

}

/**
 * Started from the bottom now we're here
 **/
