package dao;

import java.util.ArrayList;
import java.util.Map;

import entity.Course;
import utils.SQL;
import utils.GraceJava;

public class courseDao {
	private SQL javaSQL;
	private final String tableName="usercollection";
	public courseDao (){
		javaSQL=new SQL();
		javaSQL.setObj(Course.toSQL());
	}
	
	public boolean add(Course course){
		String judge=javaSQL.isDuplicatedById(tableName, course.getId());
		boolean added=false;
		if (judge.equals("No")){
			String columns= String.join(",",javaSQL.getColumns());
			String types=String.join(",", javaSQL.getTypes());
			added=javaSQL.add(tableName,columns , course.toString(), types);
		}
		return added;
	}
	
	public boolean deleteById(int id){
		boolean ret=javaSQL.deleteByKey(tableName, "id", GraceJava.int2str(id), "int");
		return ret;
	}
	
	
	public boolean updateById(int id,Course courseNew){
		String MatchValues=courseNew.toString();
		String columns= String.join(",",javaSQL.getColumns());
		String types=String.join(",", javaSQL.getTypes());
		boolean ret=javaSQL.changeInfo(tableName, id,columns , MatchValues, types);
		return ret;
	}
	public Map<String , String> SelectById(String SelectedKeys,int id){
		return javaSQL.Select(tableName, SelectedKeys, "id", GraceJava.int2str(id), "int");
		
	}
	public ArrayList<Map<String,String>> SelectByKeys(String SelectedKeys,String MatchKeys,String MatchValues){
		String MatchValueTypes=javaSQL.TypesOfKeys(MatchKeys);
		return javaSQL.SelectBat(tableName, SelectedKeys, MatchKeys, MatchValues, MatchValueTypes);
	}

}
