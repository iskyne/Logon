package domain;

import java.util.Date;

public class LogDom {
	private int id;
	private Date datetime;
	private int userId;
	private String IP;
	
	public int getId(){
		return this.id;
	}
	
	public Date getDatetime(){
		return this.datetime;
	}
	
	public int getUserid(){
		return this.userId;
	}
	
	public String getIP(){
		return this.IP;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setDatetime(Date datetime){
		this.datetime=datetime;
	}
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	
	public void setIP(String ip){
		this.IP=ip;
	}
}
