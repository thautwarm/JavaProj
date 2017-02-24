package entity;

import utils.GraceJava;

public class User {
	
	private int id; //用户编号
	private String username; //用户名，昵称
	private String password; //密码
	private int sex; //性别
	private String email; //邮箱
	
	private String phone; //电话
	private int pocketid; //钱包id
	
	private String head; //头像链接
	
	private int level; //用户等级
	private int experience; //用户学习时长
	private int access; //用户级别、权限
	
	
	
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPocketid() {
		return pocketid;
	}
	public void setPocketid(int pocketid) {
		this.pocketid = pocketid;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	
	
	public static String toSQL(){
		String attrs="id,username,password,sex,email,phone,pocketid,head,level,access,experience";
		String types="int,String,String,int,String,String,int,String,int,int,int";
		return attrs+"#"+types;
	}
	
	public String toString(){
		return  String.format(GraceJava.repeat("%s", ",", 11),id,username,password,sex,email,phone,pocketid,head,level,access,experience);
	}
}
