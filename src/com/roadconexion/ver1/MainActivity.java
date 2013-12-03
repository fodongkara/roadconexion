package com.roadconexion.ver1;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.roadconexion.ver1.adapters.ReportDataAdapter;
import com.roadconexion.ver1.data.ReportData;
//import com.roadconexion.ver1.R;






public class MainActivity extends Activity {


	ListView reportList;
	Context context = MainActivity.this;
	//ArrayList<ReportData> = new ArrayList<ReportData>();
	//ArrayList<ReportData> reportdata = new ArrayList<ReportData>();
	//ArrayList<ReportData> reports;
	ArrayList<ReportData> myReports = new ArrayList<ReportData>();

	//private ArrayList<ReportData> reports;
	//private ListView reportList;
	private LayoutInflater layoutInflator;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//context = this;
		setContentView(R.layout.activity_main);

		//this.inMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        reportList = (ListView) findViewById(R.id.report_list);
        //Insert data into the list before setting the adapter
        //Otherwise it will generate NUllPointerException......
        //reportList.setAdapter
        //getDataInList();
        //report();
        

        //oh God!!!!!
        //setReports(rmyeports);


        reportList.setAdapter(new ReportDataAdapter(context, myReports));
	
        //this.layoutInflator = LayoutInflater.from(this);

        
	}

	//if i have my own strings 
    //private void getDataInList(){

    //}
    
   // public void setReports(ArrayList<ReportData> reports) {
   	public void setReports(ArrayList<ReportData> myReports) {
		this.reports = reports;
		//this.reportList.setAdapter(new ReportDataAdapter(this,this.imgFetcher,this.layoutInflator, this.reports));
		//this.reportList.setAdapter(new ReportDataAdapter(this,this.layoutInflator, this.reports));
		
	}
    
    //public ReportData report;

	

	
}
	

/**
* Started from the bottom now we're here
**/