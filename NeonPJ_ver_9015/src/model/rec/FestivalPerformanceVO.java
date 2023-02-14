package model.rec;

public class FestivalPerformanceVO {
	





	int performanceno;
	public String getPerformancestart() {
		return performancestart;
	}
	public void setPerformancestart(String performancestart) {
		this.performancestart = performancestart;
	}
	public String getPerformanceend() {
		return performanceend;
	}
	public void setPerformanceend(String performanceend) {
		this.performanceend = performanceend;
	}
	public String getPerformancecast() {
		return performancecast;
	}
	public void setPerformancecast(String performancecast) {
		this.performancecast = performancecast;
	}
	public String getPerformancelocation() {
		return performancelocation;
	}
	public void setPerformancelocation(String performancelocation) {
		this.performancelocation = performancelocation;
	}
	public String getPerformancename() {
		return performancename;
	}
	public void setPerformancename(String performancename) {
		this.performancename = performancename;
	}
	public String getPerformancecontent() {
		return performancecontent;
	}
	public void setPerformancecontent(String performancecontent) {
		this.performancecontent = performancecontent;
	}
	public int getFestivalno() {
		return festivalno;
	}
	public void setFestivalno(int festivalno) {
		this.festivalno = festivalno;
	}
	public int getPerformanceno() {
		return performanceno;
	}

	String performancestart, performanceend, performancecast;
	String performancelocation, performancename, performancecontent; 
	int festivalno;
	
	public FestivalPerformanceVO(int performanceno,String performancename,String performancelocation,String performancestart,String  performanceend, String performancecast,String performancecontent ) {
		this.performanceno=performanceno;
		this.performancename=performancename;
		this.performancestart=performancestart;
		this.performanceend=performanceend;
		this.performancelocation=performancelocation;
		this.performancecast = performancecast;
		this.performancecontent=performancecontent;

	
		
	}
	public void setPerformanceno(int performanceno) {
		this.performanceno = performanceno;
	}

	public FestivalPerformanceVO() {}

	
}
