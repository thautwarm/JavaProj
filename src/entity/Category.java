package entity;

import utils.ToString;

public class Category {
	/*id:种类编号
	 * name: 种类名
	 */
	private int id;
	private String name;
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
	
	
	public static String toSQL(){
		String attrs="id,name";
		String types="int,String";
		return attrs+"#"+types;
	}
	public String toString(){
		return  String.format(ToString.repeat("%s", ",", 2),id,name);
	}
	
}
