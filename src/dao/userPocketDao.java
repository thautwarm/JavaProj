package dao;
import java.util.Map;
import entity.User;
import utils.SQL;
import utils.ToString;
import entity.userPocket;
public class userPocketDao {
	
	private SQL javaSQL;
	private final String tableName="userPocket";
	public userPocketDao (){
		javaSQL=new SQL();
		javaSQL.setObj(userPocket.toSQL());
	}

	public boolean add(userPocket pocket){
		String judge=javaSQL.isDuplicatedById(tableName, pocket.getId());
		boolean added=false;
		if (judge.equals("No")){
			String columns= String.join(",",javaSQL.getColumns());
			String types=String.join(",", javaSQL.getTypes());
			added=javaSQL.add(tableName,columns , pocket.toString(), types);
		}
		return added;
	}
	
	public boolean deleteById(int id){
		boolean ret=javaSQL.deleteByKey(tableName, "id", ToString.int2str(id), "int");
		return ret;
	}
	
	
	

	public String getTotal(User user){
		String ret=null;
		Map<String , String> map=javaSQL.Select(tableName, "total", "id",ToString.int2str(user.getPocketid()),"int");
		if (map==null){
			ret="NoUserHasThePocketId:this user has a wrong userPocketId";
		}
		else{
			ret=map.get("total");
		}
	return ret;
	}
	
	
	public boolean updateById(int id,userPocket pocketNew){
		String MatchValues=pocketNew.toString();
		String columns= String.join(",",javaSQL.getColumns());
		String types=String.join(",", javaSQL.getTypes());
		boolean ret=javaSQL.changeInfo(tableName, id,columns , MatchValues, types);
		return ret;
	}
	public Map<String , String> SelectById(String SelectedKeys,int id){
		return javaSQL.Select(tableName, SelectedKeys, "id", ToString.int2str(id), "int");
		
	}
	
	
}
