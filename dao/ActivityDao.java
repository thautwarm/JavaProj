
package dao;
import entity.Activity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class ActivityDao extends SQL{

	public ActivityDao() {
		setTypeMap(Activity.getTypeMap());
		setTableName("activity");
	}
	public ArrayList<Activity> selectEntity(String columns,String MatchValues){
		ArrayList<Activity> activityList= new ArrayList<Activity>();
		ResultSet res =Select(Activity.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Activity activity=new Activity();
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
				
				activity.setByKey(column, obj);
			}
			activityList.add(activity);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return activityList;
	}
	public ArrayList<Activity> selectEntity(String columns,Object ...MatchValues){
		ArrayList<Activity> activityList= new ArrayList<Activity>();
		ResultSet res =Select(Activity.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Activity activity=new Activity();
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
				
				activity.setByKey(column, obj);
			}
			activityList.add(activity);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return activityList;
	}
     	public ArrayList<Activity> selectEntity(Activity activitySelect){
            String MatchValues=activitySelect.toSQLValues();
		ArrayList<Activity> activityList= new ArrayList<Activity>();
		String columns=Activity.toSQLColumns();
		ResultSet res =Select(Activity.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Activity activity=new Activity();
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
				
				activity.setByKey(column, obj);
			}
			activityList.add(activity);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return activityList;
	}
	public boolean add(Activity activity){
		if (isDuplicatedByKey("id",activity.getId()).equals("No")){
			return addEntity(Activity.toSQLColumns(),activity.toSQLValues());
		}
            System.out.println("addActivityError-DuplicatedAdded.");
		return false;
	}
}
