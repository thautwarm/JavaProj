
package dao;
import entity.UserPocket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class UserPocketDao extends SQL{

	public UserPocketDao() {
		setTypeMap(UserPocket.getTypeMap());
		setTableName("userpocket");
	}
	public ArrayList<UserPocket> selectEntity(String columns,String MatchValues){
		ArrayList<UserPocket> userpocketList= new ArrayList<UserPocket>();
		ResultSet res =Select(UserPocket.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserPocket userpocket=new UserPocket();
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
				
				userpocket.setByKey(column, obj);
			}
			userpocketList.add(userpocket);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userpocketList;
	}
	public ArrayList<UserPocket> selectEntity(String columns,Object ...MatchValues){
		ArrayList<UserPocket> userpocketList= new ArrayList<UserPocket>();
		ResultSet res =Select(UserPocket.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserPocket userpocket=new UserPocket();
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
				
				userpocket.setByKey(column, obj);
			}
			userpocketList.add(userpocket);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userpocketList;
	}
     	public ArrayList<UserPocket> selectEntity(UserPocket userpocketSelect){
            String MatchValues=userpocketSelect.toSQLValues();
		ArrayList<UserPocket> userpocketList= new ArrayList<UserPocket>();
		String columns=UserPocket.toSQLColumns();
		ResultSet res =Select(UserPocket.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			UserPocket userpocket=new UserPocket();
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
				
				userpocket.setByKey(column, obj);
			}
			userpocketList.add(userpocket);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userpocketList;
	}
	public boolean add(UserPocket userpocket){
		if (isDuplicatedByKey("id",userpocket.getId()).equals("No")){
			return addEntity(UserPocket.toSQLColumns(),userpocket.toSQLValues());
		}
            System.out.println("addUserPocketError-DuplicatedAdded.");
		return false;
	}
}
