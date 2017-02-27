
package dao;
import entity.UserCollection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class UserCollectionDao extends SQL{

	public UserCollectionDao() {
		setTypeMap(UserCollection.getTypeMap());
		setTableName("usercollection");
	}
	public ArrayList<UserCollection> selectEntity(String columns,String MatchValues){
		ArrayList<UserCollection> usercollectionList= new ArrayList<UserCollection>();
		ResultSet res =Select(UserCollection.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserCollection usercollection=new UserCollection();
			for(String column:columnsKeys){
				
				Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				usercollection.setByKey(column, obj);
			}
			usercollectionList.add(usercollection);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return usercollectionList;
	}
	public ArrayList<UserCollection> selectEntity(String columns,Object ...MatchValues){
		ArrayList<UserCollection> usercollectionList= new ArrayList<UserCollection>();
		ResultSet res =Select(UserCollection.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserCollection usercollection=new UserCollection();
			for(String column:columnsKeys){
				
				Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				usercollection.setByKey(column, obj);
			}
			usercollectionList.add(usercollection);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return usercollectionList;
	}
     	public ArrayList<UserCollection> selectEntity(UserCollection usercollectionSelect){
            String MatchValues=usercollectionSelect.toSQLValues();
		ArrayList<UserCollection> usercollectionList= new ArrayList<UserCollection>();
		String columns=UserCollection.toSQLColumns();
		ResultSet res =Select(UserCollection.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserCollection usercollection=new UserCollection();
			for(String column:columnsKeys){
				
					Object obj=null;
				String type=this.TypeMap.get(column);
				switch (type){
    
				case "Integer":
					obj=res.getInt(column);
					break;
				case "String":
					obj=res.getString(column);
					break;
				case "Date":
					obj= ToStr.Timestamp2Date(res.getTimestamp(column));
					break;
				case "Double":
					obj= res.getDouble(column);
					break;
				case "Long":
					obj= res.getLong(column);
					break;
				default:
					break;
				}
				
				
				if (obj==null) {
					continue;
				}
				
				usercollection.setByKey(column, obj);
			}
			usercollectionList.add(usercollection);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return usercollectionList;
	}
	public boolean add(UserCollection usercollection){
		if (isDuplicatedByKey("id",usercollection.getId()).equals("No")){
			return addEntity(UserCollection.toSQLColumns(),usercollection.toSQLValues());
		}
            System.out.println("addUserCollectionError-DuplicatedAdded.");
		return false;
	}
}
