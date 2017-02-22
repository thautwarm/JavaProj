package entity;
import java.sql.Timestamp;

import utils.ToString;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
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

	public int getMode() {
		return mode;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreatedate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public static String toSQL(){
		String attrs="id,name,info,categoryid,createddate,mode,image";
		String types="int,String,String,int,Timestamp,int,String";
		return attrs+"#"+types;
	}
	public String toString(){
		return  String.format(ToString.repeat("%s", ",", 7),id,name,info,categoryid,createddate,mode,image);
	}


}
