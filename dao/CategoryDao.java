
package dao;
import entity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class CategoryDao extends SQL{

	public CategoryDao() {
		setTypeMap(Category.getTypeMap());
		setTableName("category");
	}
	public ArrayList<Category> selectEntity(String columns,String MatchValues){
		ArrayList<Category> categoryList= new ArrayList<Category>();
		ResultSet res =Select(Category.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Category category=new Category();
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
				
				category.setByKey(column, obj);
			}
			categoryList.add(category);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return categoryList;
	}
	public ArrayList<Category> selectEntity(String columns,Object ...MatchValues){
		ArrayList<Category> categoryList= new ArrayList<Category>();
		ResultSet res =Select(Category.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Category category=new Category();
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
				
				category.setByKey(column, obj);
			}
			categoryList.add(category);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return categoryList;
	}
     	public ArrayList<Category> selectEntity(Category categorySelect){
            String MatchValues=categorySelect.toSQLValues();
		ArrayList<Category> categoryList= new ArrayList<Category>();
		String columns=Category.toSQLColumns();
		ResultSet res =Select(Category.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Category category=new Category();
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
				
				category.setByKey(column, obj);
			}
			categoryList.add(category);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return categoryList;
	}
	public boolean add(Category category){
		if (isDuplicatedByKey("id",category.getId()).equals("No")){
			return addEntity(Category.toSQLColumns(),category.toSQLValues());
		}
            System.out.println("addCategoryError-DuplicatedAdded.");
		return false;
	}
}
