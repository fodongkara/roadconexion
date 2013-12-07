package com.roadconexion.ver1.adapters;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
import android.widget.TextView;



import com.roadconexion.ver1.R;
import com.roadconexion.ver1.data.ReportData;
import com.roadconexion.ver1.MainActivity;
//import com.roadconexion.ver1.MainActivity.MyViewHolder;



//public class ReportDataAdapter extends BaseAdapter implements OnClickListener{
public class ReportDataAdapter extends BaseAdapter
//public class ReportDataAdapter extends Activity
{
	
  private static final String RoadName = null;
private static final String ReportInfo = null;
private static final String RoadType = null;
private static final String CreatedDate = null;
private static final String UserID = null;
ArrayList<ReportData> myReports = new ArrayList<ReportData>();
  LayoutInflater inflater;
  Context context;

	

  public ReportDataAdapter(Context context, ArrayList<ReportData> myReports) {
      this.myReports = myReports;
      this.context = context;
      inflater = LayoutInflater.from(this.context); //only context can also be used

  }
	
	//public ReportDataAdapter (MainActivity a, LayoutInflater l, ArrayList<ReportData> data)
  //  {
  //  	this.activity = a;
    	//this.imgFetcher = i;
  //  	this.layoutInflater = l;
  //  	this.reports = data;
   // }

	@Override
    public int getCount() {
        return this.myReports.size();
    }
	
	//@Override
  //  public boolean areAllItemsEnabled () 
  //  {
  //  	return true;
  //  }
    
  //  @Override
  //  public Object getItem(int arg0) {
  //      return null;
  //  }

    @Override
    public ReportData getItem(int position)  {
      return myReports.get(position);
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

        mViewHolder.tvRoadName = detail(convertView, R.id.tvroadName, myReports.get(position).get(RoadName));
        mViewHolder.tvReportInfo = detail(convertView, R.id.tvReportInfo, myReports.get(position).get(ReportInfo));
        mViewHolder.tvReportType = detail(convertView, R.id.tvReportType, myReports.get(position).get(RoadType));
        mViewHolder.tvCreatedDate = detail(convertView, R.id.tvCreatedDate, myReports.get(position).get(CreatedDate));
        mViewHolder.tvUserID = detail(convertView, R.id.tvUserID, myReports.get(position).get(UserID));
        return convertView;
    }

    private Object detail(View convertView, int tvroadname, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	private TextView TextView (View v, int resId, String text) {
        Activity view = null;
		TextView tv = (TextView) view.findViewById(resId);
    	//TextView tv = (TextView) ((View) context).findViewById(resId);
        tv.setText(text);
      return tv;
    }

    //public static class MyViewHolder {
    public class MyViewHolder {
        public Object tvUserID;
		public Object tvCreatedDate;
		public Object tvReportType;
		public Object tvReportInfo;
		public Object tvRoadName;
		TextView roadName, reportInfo, reportType, createdDate, userID;

    }
       
	//}
    
}




	
	
	
	
    
    
    

    

    
    
    
    
//}
