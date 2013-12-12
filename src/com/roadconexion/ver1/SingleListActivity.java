package com.roadconexion.ver1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListActivity extends Activity {
	
	// JSON node keys
	private static final String TAG_REPORTS = "reports";
    private static final String TAG_USERID = "user";
    private static final String TAG_ROADNAME = "road_name";
    private static final String TAG_REPORT = "report";
    private static final String TAG_REPORTTYPE = "type_report";
    private static final String TAG_DATE = "created_on";


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String roadname = in.getStringExtra(TAG_ROADNAME);
        String report = in.getStringExtra(TAG_REPORT);
        String userid = in.getStringExtra(TAG_USERID);
        String date = in.getStringExtra(TAG_DATE);
        String reporttype = in.getStringExtra(TAG_REPORTTYPE);
        
        // Displaying all values on the screen
        TextView lblRoadname = (TextView) findViewById(R.id.road_name);
        TextView lblReport = (TextView) findViewById(R.id.report_desc);
        TextView lblUserid = (TextView) findViewById(R.id.user_id);
        TextView lblDate = (TextView) findViewById(R.id.created_date);
        TextView lblReporttype = (TextView) findViewById(R.id.report_type);
        
        lblRoadname.setText(roadname);
        lblReport.setText(report);
        lblUserid.setText(userid);
        lblDate.setText(date);
        lblReporttype.setText(reporttype);
    }
}
