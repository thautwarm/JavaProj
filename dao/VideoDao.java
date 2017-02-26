
package dao;
import entity.Video;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class VideoDao extends SQL{

	public VideoDao() {
		setTypeMap(Video.getTypeMap());
		setTableName("video");
	}
	public ArrayList<Video> selectEntity(String columns,String MatchValues){
		ArrayList<Video> videoList= new ArrayList<Video>();
		ResultSet res =Select(Video.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Video video=new Video();
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
				
				video.setByKey(column, obj);
			}
			videoList.add(video);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return videoList;
	}
	public ArrayList<Video> selectEntity(String columns,Object ...MatchValues){
		ArrayList<Video> videoList= new ArrayList<Video>();
		ResultSet res =Select(Video.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Video video=new Video();
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
				
				video.setByKey(column, obj);
			}
			videoList.add(video);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return videoList;
	}
     	public ArrayList<Video> selectEntity(Video videoSelect){
            String MatchValues=videoSelect.toSQLValues();
		ArrayList<Video> videoList= new ArrayList<Video>();
		String columns=Video.toSQLColumns();
		ResultSet res =Select(Video.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Video video=new Video();
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
				
				video.setByKey(column, obj);
			}
			videoList.add(video);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return videoList;
	}
	public boolean add(Video video){
		if (isDuplicatedByKey("id",video.getId()).equals("No")){
			return addEntity(Video.toSQLColumns(),video.toSQLValues());
		}
            System.out.println("addVideoError-DuplicatedAdded.");
		return false;
	}
}
