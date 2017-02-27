
package dao;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class UserDao extends SQL{

	public UserDao() {
		setTypeMap(User.getTypeMap());
		setTableName("user");
	}
	public ArrayList<User> selectEntity(String columns,String MatchValues){
		ArrayList<User> userList= new ArrayList<User>();
		ResultSet res =Select(User.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			User user=new User();
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
				
				user.setByKey(column, obj);
			}
			userList.add(user);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	public ArrayList<User> selectEntity(String columns,Object ...MatchValues){
		ArrayList<User> userList= new ArrayList<User>();
		ResultSet res =Select(User.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			User user=new User();
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
				
				user.setByKey(column, obj);
			}
			userList.add(user);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
     	public ArrayList<User> selectEntity(User userSelect){
            String MatchValues=userSelect.toSQLValues();
		ArrayList<User> userList= new ArrayList<User>();
		String columns=User.toSQLColumns();
		ResultSet res =Select(User.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			User user=new User();
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
				
				user.setByKey(column, obj);
			}
			userList.add(user);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	public boolean add(User user){
		if (isDuplicatedByKey("id",user.getId()).equals("No")){
			return addEntity(User.toSQLColumns(),user.toSQLValues());
		}
            System.out.println("addUserError-DuplicatedAdded.");
		return false;
	}
}
