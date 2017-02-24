package entity;
import java.sql.Timestamp;

import utils.GraceJava;
/*
 * id:课程编号
 * name:课程名
 * info:课程信息
 * categoryid:所属种类的id
 * createdate:创建时间
 * mode:课程的性质
 */
public class Course {
	private int id;
	private String name;
	private String info;
	private int categoryid;
	private Timestamp createddate;
	private int mode;
	private String image;
	private int teacherid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public static String toSQL(){
		String attrs="id,name,info,categoryid,createddate,mode,image,teacherid";
		String types="int,String,String,int,Timestamp,int,String,int";
		return attrs+"#"+types;
	}
	public String toString(){
		return  String.format(GraceJava.repeat("%s", ",", 8),id,name,info,categoryid,createddate,mode,image,teacherid);
	}


}
