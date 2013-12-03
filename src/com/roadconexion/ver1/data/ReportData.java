package com.roadconexion.ver1.data;

public class ReportData {
	private String roadName;
	private String reportInfo;
	private String reportType;
	private String createdDate;
	private String userID;

	//road_name = models.TextField(max_length=1000, blank=False)
    //report= models.TextField(blank=False)
    //type_report=models.CharField(max_length=1000,choices=TYPE_CHOICES,blank=False)
    //created_on = models.DateTimeField(auto_now_add=True)
    //user = models.ForeignKey(User)

    public ReportData(String roadName, String reportInfo, String reportType, String createdDate, String userID) {
		super();
		this.roadName = roadName;
		this.reportInfo = reportInfo;
		this.reportType = reportType;
		this.createdDate = createdDate;
		this.userID = userID;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getReportInfo() {
		return reportInfo;
	}

	public void setReportInfo(String reportInfo) {
		this.reportInfo = reportInfo;
	}

	public String getreportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}



	
	
	



