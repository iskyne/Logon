package domain;

import java.io.Serializable;
import java.util.Date;

public class UserDom implements Serializable{
	private int id;
	private String name;
	private String password;
	private int credit;
	private Date datetime;
	private String IP;
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public int getCredit(){
		return this.credit;
	}
	
	public Date getDatetime(){
		return this.datetime;
	}
	
	public String getIP(){
		return this.IP;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void setCredit(int credit){
		this.credit=credit;
	}
	
	public void setDatetime(Date datetime){
		this.datetime=datetime;
	}
	
	public void setIP(String ip){
		this.IP=ip;
	}
}
