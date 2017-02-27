
package dao;
import entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class CourseDao extends SQL{

	public CourseDao() {
		setTypeMap(Course.getTypeMap());
		setTableName("course");
	}
	public ArrayList<Course> selectEntity(String columns,String MatchValues){
		ArrayList<Course> courseList= new ArrayList<Course>();
		ResultSet res =Select(Course.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Course course=new Course();
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
				
				course.setByKey(column, obj);
			}
			courseList.add(course);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return courseList;
	}
	public ArrayList<Course> selectEntity(String columns,Object ...MatchValues){
		ArrayList<Course> courseList= new ArrayList<Course>();
		ResultSet res =Select(Course.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Course course=new Course();
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
				
				course.setByKey(column, obj);
			}
			courseList.add(course);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return courseList;
	}
     	public ArrayList<Course> selectEntity(Course courseSelect){
            String MatchValues=courseSelect.toSQLValues();
		ArrayList<Course> courseList= new ArrayList<Course>();
		String columns=Course.toSQLColumns();
		ResultSet res =Select(Course.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Course course=new Course();
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
				
				course.setByKey(column, obj);
			}
			courseList.add(course);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return courseList;
	}
	public boolean add(Course course){
		if (isDuplicatedByKey("id",course.getId()).equals("No")){
			return addEntity(Course.toSQLColumns(),course.toSQLValues());
		}
            System.out.println("addCourseError-DuplicatedAdded.");
		return false;
	}
}
