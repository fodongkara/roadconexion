package com.roadconexion.ver1;


import com.roadconexion.ver1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleList extends Activity{
	// JSON node keys
	
	 	private static final String TAG_REPORTS = "reports";
	
	    private static final String TAG_REPORTTYPE = "type_report";
	    private static final String TAG_USERID= "user";
	    private static final String TAG_ROADNAME= "road_name";
	    private static final String TAG_REPORT= "report";
	    private static final String TAG_DATE= "created_on";
	    
	    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String road_name = in.getStringExtra(TAG_ROADNAME);
        String report = in.getStringExtra(TAG_REPORT);
        String user = in.getStringExtra(TAG_USERID);
        String created_on = in.getStringExtra(TAG_DATE);
        String type_report = in.getStringExtra(TAG_REPORTTYPE);
        
        // Displaying all values on the screen
        TextView lblNames = (TextView) findViewById(R.id.road_names);
        TextView lblReports = (TextView) findViewById(R.id.report_desc);
        TextView lblUsers = (TextView) findViewById(R.id.user_id);
        TextView lblDates = (TextView) findViewById(R.id.created_date);
        TextView lblReporttypes = (TextView) findViewById(R.id.report_type);
        
        lblNames.setText(road_name);
        lblReports.setText(report);
        lblUsers.setText(user);
        lblDates.setText(created_on);
        lblReporttypes.setText(type_report);
    }
}
