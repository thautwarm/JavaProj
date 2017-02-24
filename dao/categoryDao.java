package dao;


import java.util.ArrayList;
import java.util.Map;

import entity.Category;
import utils.SQL;
import utils.GraceJava;

public class categoryDao {
	private SQL javaSQL;
	private final String tableName="category";
	public categoryDao (){
		javaSQL=new SQL();
		javaSQL.setObj(Category.toSQL());
	}

	public boolean add(Category category){
		String judge=javaSQL.isDuplicatedById(tableName, category.getId());
		boolean added=false;
		if (judge.equals("No")){
			String columns= String.join(",",javaSQL.getColumns());
			String types=String.join(",", javaSQL.getTypes());
			added=javaSQL.add(tableName,columns , category.toString(), types);
		}
		return added;
	}
	
	public boolean deleteById(int id){
		boolean ret=javaSQL.deleteByKey(tableName, "id", GraceJava.int2str(id), "int");
		return ret;
	}
	public boolean updateById(int id,Category categoryNew){
		String MatchValues=categoryNew.toString();
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
