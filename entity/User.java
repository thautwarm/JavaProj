package entity;

import utils.GraceJava;

public class User {
	
	private int id; //�û����
	private String username; //�û������ǳ�
	private String password; //����
	private int sex; //�Ա�
	private String email; //����
	
	private String phone; //�绰
	private int pocketid; //Ǯ��id
	
	private String head; //ͷ������
	
	private int level; //�û��ȼ�
	private int experience; //�û�ѧϰʱ��
	private int access; //�û�����Ȩ��
	
	
	
	
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
