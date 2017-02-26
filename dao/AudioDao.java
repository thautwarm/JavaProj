
package dao;
import entity.Audio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import GraceJava.SQL;
import GraceJava.ToStr;
public class AudioDao extends SQL{

	public AudioDao() {
		setTypeMap(Audio.getTypeMap());
		setTableName("audio");
	}
	public ArrayList<Audio> selectEntity(String columns,String MatchValues){
		ArrayList<Audio> audioList= new ArrayList<Audio>();
		ResultSet res =Select(Audio.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Audio audio=new Audio();
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
				
				audio.setByKey(column, obj);
			}
			audioList.add(audio);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return audioList;
	}
	public ArrayList<Audio> selectEntity(String columns,Object ...MatchValues){
		ArrayList<Audio> audioList= new ArrayList<Audio>();
		ResultSet res =Select(Audio.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Audio audio=new Audio();
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
				
				audio.setByKey(column, obj);
			}
			audioList.add(audio);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return audioList;
	}
     	public ArrayList<Audio> selectEntity(Audio audioSelect){
            String MatchValues=audioSelect.toSQLValues();
		ArrayList<Audio> audioList= new ArrayList<Audio>();
		String columns=Audio.toSQLColumns();
		ResultSet res =Select(Audio.toSQLColumns(),columns,MatchValues);
		String[] columnsKeys=columns.split(",");
		try{
		while(res.next()){
			Audio audio=new Audio();
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
				
				audio.setByKey(column, obj);
			}
			audioList.add(audio);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return audioList;
	}
	public boolean add(Audio audio){
		if (isDuplicatedByKey("id",audio.getId()).equals("No")){
			return addEntity(Audio.toSQLColumns(),audio.toSQLValues());
		}
            System.out.println("addAudioError-DuplicatedAdded.");
		return false;
	}
}
