package entity;

import java.sql.Timestamp;

import utils.GraceJava;

public class userCollection {
	
	
	private int id;
	private int userid;
	private int courseid;
	private Timestamp collecteddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public Timestamp getCollecteddate() {
		return collecteddate;
	}
	public void setCollecteddate(Timestamp collecteddate) {
		this.collecteddate = collecteddate;
	}
	
	
	public static String toSQL(){
		String attrs="id,userid,courseid,collecteddate";
		String types="int,int,int,Timestamp";
		return attrs+"#"+types;
	}
	public String toString(){
		return  String.format(GraceJava.repeat("%s", ",", 4),id,userid,courseid,collecteddate);
	}
	

}
