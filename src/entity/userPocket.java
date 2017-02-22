package entity;

import utils.ToString;

/*
 * id: Ǯ���ı��
 * 
 * total :Ǯ����
 */
public class userPocket {
	private int id;
	private double total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public static String[] Attrs(){
		return  "id,total".split(",");
	}
	
	public static String toSQL(){
		String attrs="id,total";
		String types="int,double";
		return attrs+"#"+types;
	}
	public String toString(){
		return  String.format(ToString.repeat("%s", ",", 2),id,total);
	}

}
