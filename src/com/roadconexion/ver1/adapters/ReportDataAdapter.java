package com.roadconexion.ver1.adapters;


import java.util.ArrayList;



//import android.app.Activity;
import android.content.Context;
//import android.content.Intent;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
import android.widget.TextView;



import com.roadconexion.ver1.R;
//import com.roadconexion.ver1.data.ReportData;
//import com.roadconexion.ver1.MainActivity;
import com.roadconexion.ver1.data.ReportData;
//import com.roadconexion.ver1.MainActivity.MyViewHolder;



//public class ReportDataAdapter extends BaseAdapter implements OnClickListener{
public class ReportDataAdapter extends BaseAdapter
//public class ReportDataAdapter extends Activity
{
	

//ArrayList<ReportData> myReports = new ArrayList<ReportData>();
//ArrayList<ReportData> reports = new ArrayList<ReportData>();
  ArrayList<ReportData> reports;
  LayoutInflater inflater;
  Context context;
  //String[] myReports;

	

  //public ReportDataAdapter(Context context, ArrayList<ReportData> myReports)
  public ReportDataAdapter(Context context, ArrayList<ReportData> data) {
      //this.myReports = myReports;
      //this.reports = reports;
      this.reports = data;
      this.context = context;
      inflater = LayoutInflater.from(this.context); //only context can also be used

  }
	

	@Override
    public int getCount() {
        return this.reports.size();
    }
	

    @Override
    public ReportData getItem(int position)  {
      return reports.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }





    
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      MyViewHolder mViewHolder;
      if(convertView == null) {
          //convertView = inflater.inflate (R.layout.activity_main, parent, false);
          convertView = inflater.inflate (R.layout.list_view, null);
          mViewHolder = new MyViewHolder();
          convertView.setTag(mViewHolder);
      } else {
          mViewHolder = (MyViewHolder) convertView.getTag();
      }
      detail(convertView, R.id.tvRoadName, reports.get(position).getRoadName());
      detail(convertView, R.id.tvReportInfo, reports.get(position).getReportInfo());
      detail(convertView, R.id.tvReportType, reports.get(position).getReportType());
      detail(convertView, R.id.tvCreatedDate, reports.get(position).getCreatedDate());
      detail(convertView, R.id.tvUserID, reports.get(position).getUserID());
      
        return convertView;
    }

   
   

	




	private TextView detail(View v, int resId, String text) {
        //Activity view = null;
		TextView tv = (TextView) v.findViewById(resId);
    	//TextView tv = (TextView) ((View) context).findViewById(resId);
        tv.setText(text);
      return tv;
    }

    //public static class MyViewHolder {
    /*public class MyViewHolder {
        public Object tvUserID;
		public Object tvCreatedDate;
		public Object tvReportType;
		public Object tvReportInfo;
		public Object tvRoadName;
		TextView roadName, reportInfo, reportType, createdDate, userID;

    }
    */
       
	 private class MyViewHolder {
	    	
	    }
	//}
    
}




	
	
	
	
    
    
    

    

    
    
    
    
//}
