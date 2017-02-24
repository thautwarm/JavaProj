package dao;


import java.util.ArrayList;
import java.util.Map;
import entity.userCollection;
import utils.SQL;
import utils.GraceJava;

public class userCollectionDao {
	private SQL javaSQL;
	private final String tableName="userCollection";
	public userCollectionDao (){
		javaSQL=new SQL();
		javaSQL.setObj(userCollection.toSQL());
	}
	public boolean add(userCollection collection){
		String judge=javaSQL.isDuplicatedById(tableName, collection.getId());
		boolean added=false;
		if (judge.equals("No")){
			String columns= String.join(",",javaSQL.getColumns());
			String types=String.join(",", javaSQL.getTypes());
			added=javaSQL.add(tableName,columns , collection.toString(), types);
		}
		return added;
	}
	public boolean deleteById(int id){
		boolean ret=javaSQL.deleteByKey(tableName, "id", GraceJava.int2str(id), "int");
		return ret;
	}
	public boolean updateById(int id,userCollection collectionNew){
		String MatchValues=collectionNew.toString();
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
