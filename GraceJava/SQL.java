package GraceJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
public class SQL {
	
	private final Connection conn=((SQLConnection) APP.getBean("connectDao")).getConnection();
	public Map<String,String> TypeMap;
	private String tableName;
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Map<String, String> getTypeMap() {
		return TypeMap;
	}
	public void setTypeMap(Map<String, String> typeMap) {
		TypeMap = typeMap;
	}
	
public boolean secureExecute(Connection conn,PreparedStatement query){

		boolean ret=true;
		
		try
		{	
			
			if (query==null)
				return false;
			conn.setAutoCommit(false);
			query.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			query.close();

		}
		catch (SQLException e3){
			ret=false;
			try{
				conn.rollback();
			}
			catch (SQLException e2){
				e2.printStackTrace();
				
			}
			e3.printStackTrace();
		}
		return ret;
	}
	public boolean deleteByKeys(String MatchKeys,String MatchValues){
		boolean ret=false;
		String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
		String sql ="DELETE FROM "+tableName+" WHERE "+Judges;
		try{
			PreparedStatement ps= conn.prepareStatement(sql);
			int index=1;
			String[] KeyList=MatchKeys.split(",");
			String[] ValueList=MatchValues.split(",");
			for(String key :KeyList){
				PrepareSql(ps, index, key, ValueList[index-1]);
				++index;
				}
			if(secureExecute(conn, ps))
				{ret=true;}
		}
		catch(SQLException e){
			e.printStackTrace();
			ret=false;
		}
		return ret;
	}
	public boolean deleteByKeys(String MatchKeys,Object ...MatchValues){
		boolean ret=false;
		String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
		String sql ="DELETE FROM "+tableName+" WHERE "+Judges;
		try{
			PreparedStatement ps= conn.prepareStatement(sql);
			int index=1;
			String[] KeyList=MatchKeys.split(",");
			for(String key :KeyList){
				PrepareSql(ps, index, key, MatchValues[index-1]);
				++index;
				}
			if(secureExecute(conn, ps))
				{ret=true;}
		}
		catch(SQLException e){
			e.printStackTrace();
			ret=false;
		}
		return ret;
	}
	
	public String isDuplicatedById(Long id){
		String sql="SELECT COUNT(id) FROM "+tableName+" WHERE id= ?";
		String  bool="Yes";
		try{
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setLong(1,id);
			ResultSet ret = ps.executeQuery();
			int num=0;
			while(ret.next())
			{	
			num = ret.getInt(1);
			if (num!=0)
					{

					break;
					}
				}
			if (num == 0 )
			{
				bool="No";
			}
			ps.close();
		}
		catch (SQLException e){
			bool="Error";
		}	
		return bool;
	}
	public  void PrepareSql(PreparedStatement ps,int index,String key,Object value) throws SQLException{
		String type=TypeMap.get(key);
		switch (type){
		case "String":
			ps.setString(index,(String) value);
			break;
		case "Long":
			ps.setLong(index,(Long)value);
			break;
		case "Integer":
			ps.setInt(index,(Integer)value);
			break;
		case "Date" :
			ps.setTimestamp(index, ToStr.Date2Timestamp((Date)value) );
			break;
		
		case "Double":
			ps.setDouble(index, (Double)value);
			break;
		default:
			System.out.println("SQLValueTypeError");
			return;
		}
	}

public  void PrepareSql(PreparedStatement ps,int index,String key,String value) throws SQLException{
	String type=TypeMap.get(key);
	//

	switch (type){
	case "String":
		ps.setString(index,value);
		break;
	case "Long":
		ps.setLong(index,ToStr.str2long(value));
		break;
	case "Integer":
		ps.setInt(index,ToStr.str2int(value));
		break;
	case "Date" :
		ps.setTimestamp(index, ToStr.str2Timestamp(value) );
		break;
	case "Double":
		ps.setDouble(index, ToStr.str2double(value));
		break;
	default:
		System.out.println("SQLValueTypeError");
		return;
	}
}
public String isDuplicatedByKey(String key,Object value){
	String sql="SELECT COUNT(_KEY) FROM "+tableName+" WHERE _KEY= ?";
	String  bool="Yes";
	try{
		sql=sql.replaceAll("_KEY", key);
		PreparedStatement ps= conn.prepareStatement(sql);
		String valueType=TypeMap.get(key);
		switch (valueType){
			case "String":
				ps.setString(1,(String)value);
				break;
			
		case "Long":
			ps.setLong(1,(Long)value);
			break;
		case "Integer":
			ps.setInt(1,(Integer)value);
			break;
			
		case "Date" :
			ps.setTimestamp(1, ToStr.Date2Timestamp((Date)value));
			break;
		
		case "Double":
			ps.setDouble(1, (Double)value);
			break;
			
		default:
			System.out.println("SQLValueTypeError");
			return "Error";
		}
		ResultSet ret = ps.executeQuery();
		int num=0;
		while(ret.next())
		{	
		num = ret.getInt(1);
			if (num!=0)
			{
			break;
			}
		}
		
		if (num == 0 )
		{
			bool="No";
		}
		
		ps.close();
	}
	catch (SQLException e){
		bool="Error";
	}
	return bool;
}
public String isDuplicatedByKey(String key,String value){
	String sql="SELECT COUNT(_KEY) FROM "+tableName+" WHERE _KEY= ?";
	String  bool="Yes";
	try{
		sql=sql.replaceAll("_KEY", key);
		PreparedStatement ps= conn.prepareStatement(sql);
		String valueType=TypeMap.get(key);
		switch (valueType){
		case "String":
			ps.setString(1,value);
			break;
		case "Long":
			ps.setLong(1,ToStr.str2long(value));
			break;
		case "Integer":
			ps.setInt(1,ToStr.str2int(value));
			break;
		case "Date" :
			ps.setTimestamp(1, ToStr.str2Timestamp(value) );
			break;
		case "Double":
			ps.setDouble(1, ToStr.str2double(value));
			break;
		default:
			System.out.println("SQLValueTypeError");
			return "Error";
		}
		ResultSet ret = ps.executeQuery();
		int num=0;
		while(ret.next())
		{	
		num = ret.getInt(1);
			if (num!=0)
			{
			break;
			}
		}
		
		if (num == 0 )
		{
			bool="No";
		}
		
		ps.close();
	}
	catch (SQLException e){
		bool="Error";
	}
	return bool;
}


//返回一个结果集，结果集每一条记录都可以生成一个entity对象(信息不一定完全)。
public ResultSet Select(String SelectedKeys,String MatchKeys,String MatchValues)
{	
	String[] JudgeNull=ToStr.ExceptNull(MatchKeys, MatchValues);
	MatchKeys=JudgeNull[0];
	MatchValues=JudgeNull[1];
	if (MatchKeys.length()==0){
		System.out.println("InputMatchInfoError-AllValueEmpty."+"\nMatchKeys:"+MatchKeys+"\nMatchValues:"+MatchValues);
		return null;
	}
	String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
	ResultSet results=null;	
	String sql ="SELECT "+SelectedKeys+" FROM "+tableName+" WHERE "+Judges;	
	try{
		PreparedStatement ps = conn.prepareStatement(sql);
		int i=1;
		String[] KeyList=MatchKeys.split(",");
		String[] ValueList=MatchValues.split(",");
		for(String key :KeyList){
			PrepareSql(ps, i, key,ValueList[i-1]);
			++i;
			}
		results = ps.executeQuery();
		
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return results;
}
public ResultSet Select(String SelectedKeys,String MatchKeys,Object ...MatchValues)
{	
	String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
	ResultSet results=null;	
	String sql ="SELECT "+SelectedKeys+" FROM "+tableName+" WHERE "+Judges;	
	try{
	
		PreparedStatement ps = conn.prepareStatement(sql);
		
		int i=1;
		String[] KeyList=MatchKeys.split(",");
		for(String key :KeyList){
			PrepareSql(ps, i, key,MatchValues[i-1]);
			++i;
			}
		results = ps.executeQuery();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return results;
}

public boolean addEntity(String MatchKeys,String MatchValues){
	boolean ret=false;
	
	
	//判断是否存在字段为空，存在则消除该字段；全空则return false.
	String[] JudgeNull=ToStr.ExceptNull(MatchKeys, MatchValues);
	MatchKeys=JudgeNull[0];
	MatchValues=JudgeNull[1];
	if (MatchKeys.length()==0){
		return false;
		
	}
	
	
	String[] ValueList=MatchValues.split(",");
	String[] ValueUnknown= new String[ValueList.length];
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]="?";
		}	
	String sql="INSERT INTO "+tableName+"("+MatchKeys+") VALUES ("+String.join(",", ValueUnknown)+")";
	int index=1;
	String[] KeyList =MatchKeys.split(",");
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	for(String key :KeyList){
		PrepareSql(ps, index, key, ValueList[index-1]);
		++index;
		}
	if (secureExecute(conn, ps))
			{ret=true;}
	}
	catch(SQLException e){
		e.printStackTrace();
		ret=false;
	}
	return ret;	
}
public boolean addEntity(String MatchKeys,Object ...MatchValues){
	boolean ret=false;
	String[] ValueUnknown= new String[MatchValues.length];
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]="?";
		}	
	String sql="INSERT INTO "+tableName+"("+MatchKeys+") VALUES ("+String.join(",", ValueUnknown)+")";
	int index=1;
	String[] KeyList =MatchKeys.split(",");
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	for(String key :KeyList){
		PrepareSql(ps, index, key, MatchValues[index-1]);
		++index;
		}
	if (secureExecute(conn, ps))
			{ret=true;}
	}
	catch(SQLException e){
		e.printStackTrace();
		ret=false;
	}
	return ret;	
}

public boolean changeInfoById(Long id,String Keys,String Values){
	//System.out.println(id);
	boolean ret=false;
	String[] ValueList=Values.split(",");
	String[] ValueUnknown= new String[ValueList.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE id=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, ValueList[index-1]);
		++index;
		}
	PrepareSql(ps, index, "id",id);
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	
	return ret;
}
public boolean changeInfoById(int id,String Keys,String Values){
	
	//System.out.println(id);
	boolean ret=false;
	String[] ValueList=Values.split(",");
	String[] ValueUnknown= new String[ValueList.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE id=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, ValueList[index-1]);
		++index;
		}
	PrepareSql(ps, index, "id",Long.valueOf(id));
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	
	return ret;
}
public boolean changeInfoById(Long id,String Keys,Object ...Values){
	boolean ret=false;
	String[] ValueUnknown= new String[Values.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE id=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, Values[index-1]);
		++index;
		}
	PrepareSql(ps, index, "id",id);
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	return ret;
}
public boolean changeInfoById(int id,String Keys,Object ...Values){
	boolean ret=false;
	String[] ValueUnknown= new String[Values.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE id=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, Values[index-1]);
		++index;
		}
	PrepareSql(ps, index, "id",Long.valueOf(id));
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	return ret;
}


public boolean changeInfoByKey(String MatchKey,String MatchValue,String Keys,String Values){
	boolean ret=false;
	String[] ValueList=Values.split(",");
	String[] ValueUnknown= new String[ValueList.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE "+MatchKey+"=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, ValueList[index-1]);
		++index;
		}
	PrepareSql(ps, index, MatchKey,MatchValue);
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	
	return ret;
}
public boolean changeInfoByKey(String MatchKey,Object MatchValue,String Keys,Object ...ValueList){
	boolean ret=false;
	String[] ValueUnknown= new String[ValueList.length];
	String[] KeyList=Keys.split(",");
	
	for(int index=0;index<ValueUnknown.length;++index){
		ValueUnknown[index]= KeyList[index]+"=?";
		}	
	String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE "+MatchKey+"=?";
	try{
	PreparedStatement ps = conn.prepareStatement(sql);
	int index=1;
	for(String key :KeyList){
		PrepareSql(ps, index, key, ValueList[index-1]);
		++index;
		}
	PrepareSql(ps, index, MatchKey,MatchValue);
	if(secureExecute(conn,ps)){
		ret=true;
	}
	}
	catch(SQLException e){
		ret=false;
	}
	return ret;
}
}



