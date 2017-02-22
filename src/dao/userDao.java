package dao;
import java.util.Map;
import entity.User;
import utils.SQL;
import utils.ToString;
public class userDao {
	
	private SQL javaSQL;
	private final String tableName="user";
	public userDao(){
		javaSQL=new SQL();
		javaSQL.setObj(User.toSQL());
	}
	
	
	
	public boolean add(User user){
		String judge=javaSQL.isDuplicatedById(tableName, user.getId());
		boolean added=false;
		if (judge.equals("No")){
			String columns= String.join(",",javaSQL.getColumns());
			String types=String.join(",", javaSQL.getTypes());
			added=javaSQL.add(tableName,columns , user.toString(), types);
		}
		return added;
	}
	
	
	
	public boolean deleteById(int id){
		boolean ret=javaSQL.deleteByKey(tableName, "id", ToString.int2str(id), "int");
		return ret;
	}
	
	
	
	
	public String userCheckById(User user){
		String ret=null;
		Map<String , String> map=javaSQL.Select(tableName, "password", "id",ToString.int2str(user.getId()),"int");
		if (map==null){
			ret="NoUserHasTheId";
		}
		else
		
		{ 
			if(map.get("username").equals(user.getUsername()))

				{
					ret="Yes";
				}
			else
				{
					ret="No";
				}	
				
		}
	return ret;
	}
	
	
	
	public boolean updateById(int id,User userNew){
		String MatchValues=userNew.toString();
		String columns= String.join(",",javaSQL.getColumns());
		String types=String.join(",", javaSQL.getTypes());
		boolean ret=javaSQL.changeInfo(tableName, id,columns , MatchValues, types);
		return ret;
	}
	
	public Map<String , String> SelectById(String SelectedKeys,int id){
		return javaSQL.Select(tableName, SelectedKeys, "id", ToString.int2str(id), "int");
		
	}
	
}
