package bean;

public class TrainManage {
	
	private String trainid;       //车次
	private String start;         //出发地
	private String end;           //目的地
	private String time;          //行车时间
	private float yzprice;        //硬座票价
	private float rzprice;        //软座票价
	private float ywprice;        //硬卧票价
	private float rwprice;        //软卧票价
	private String root;          //车辆路线 
	
	public String getTrainid() { return trainid; }
	public String getStart() { return start; }
	public String getEnd() { return end; }
	public String getTime() { return time; }
	public Float getYzprice() { return yzprice; }
	public Float getRzprice() { return rzprice; }
	public Float getYwprice() { return ywprice; }
	public Float getRwprice() { return rwprice; }
	public String getRoot() { return root; }
	
	public void setTrainid(String str) { this.trainid =  str; }
	public void setStart(String str) { this.start =  str; }
	public void setEnd(String str) { this.end = str; }
	public void setTime(String str) { this.time = str; }
	public void setYzprice(Float price) { this.yzprice = price; }
	public void setRzprice(Float price) { this.rzprice = price; }
	public void setYwprice(Float price) { this.ywprice = price; }
	public void setRwprice(Float price) { this.rwprice = price; }
	public void setRoot(String str) { this.root = str; }
	
}
