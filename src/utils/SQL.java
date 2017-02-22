package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import utils.APP;
import utils.SQLConnection;

public class SQL {
	
	private String[] columns;
	private String[] types;
	private Map<String,String> colMAPtype;
	

	public Map<String, String> getColMAPtype() {
		return colMAPtype;
	}
	public void setColMAPtype(Map<String, String> colMAPtype) {
		this.colMAPtype = colMAPtype;
	}
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	
	public void setObj(String obj2SQL){
		String[] strs=obj2SQL.split("#");
		this.setColumns(strs[0].split(","));
		this.setTypes(strs[1].split(","));
		int i=0;
		Map<String,String> colMAPtype=new HashMap<String,String>();
		for(String type:types){
			colMAPtype.put(columns[i], type);
			i+=1;
		}
		this.setColMAPtype(colMAPtype);
	}
	
	public Connection getConn(){
		Connection conn= ((SQLConnection) APP.getBean("connectDao")).getConnection();
		return conn;
	}
	
	public String isDuplicatedById(String tableName,int id){
		Connection conn=null;
		String sql="SELECT COUNT(id) FROM "+tableName+" WHERE id= ?";
		String  bool="Yes";
		try{
			conn = getConn();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,id);
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
	public String isDuplicatedByKey(String tableName,String key,String value,String valueType){
		Connection conn=null;
		String sql="SELECT COUNT(_KEY) FROM "+tableName+" WHERE _KEY= ?";
		String  bool="Yes";
		try{
			conn = getConn();
			sql=sql.replaceAll("_KEY", key);
			PreparedStatement ps= conn.prepareStatement(sql);
			
			switch (valueType){
			
			case "String":
				ps.setString(1,value);
				break;
				
			case "int":
				ps.setInt(1,ToString.str2int(value));
				break;
				
			case "Timestamp" :
				ps.setTimestamp(1, ToString.str2date(value));
				break;
			
			case "double":
				ps.setDouble(1, ToString.str2double(value));
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
	public boolean deleteByKey(String tableName,String MatchKeys,String MatchValues,String MatchValueTypes){
		boolean ret=false;
		String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
		Connection conn=getConn();
		String sql ="DELETE FROM "+tableName+" WHERE "+Judges;
		try{
			PreparedStatement ps= conn.prepareStatement(sql);
			int i=1;
			String[] ValueList=MatchValues.split(",");
			String[] TypeList=MatchValueTypes.split(",");
			for(String type :TypeList){
				ToString.PrepareSql(ps, i, ValueList[i-1], type);
				++i;
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
	

	
	public Map<String,String> Select(String tableName,String SelectedKeys,String MatchKeys,String MatchValues,String MatchValueTypes)
	{	
		
		String Judges=MatchKeys.replaceAll(",", " =? and ")+"=?";
		
		Map<String,String> mapping=null;
		
		Connection conn=getConn();
		String sql ="SELECT "+SelectedKeys+" FROM "+tableName+" WHERE "+Judges;
		
		
		
		
		try{
		
			PreparedStatement ps = conn.prepareStatement(sql);
		
			int i=1;
			String[] ValueList=MatchValues.split(",");
			String[] TypeList=MatchValueTypes.split(",");
			for(String type :TypeList){
				ToString.PrepareSql(ps, i, ValueList[i-1], type);
				++i;
				}
			//
			ToString.p(ps.toString());
			ResultSet results = ps.executeQuery();
			mapping=ToString.MapFill(results,SelectedKeys.split(","),this.colMAPtype);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return mapping;
	}
	
	public boolean add(String tableName,String MatchKeys,String MatchValues,String MatchValueTypes){
		boolean ret=false;
		Connection conn=getConn();
		String[] ValueList=MatchValues.split(",");
		String[] ValueUnknown= new String[ValueList.length];
		
		for(int index=0;index<ValueUnknown.length;++index){
			ValueUnknown[index]="?";
			}	
		
		String sql="INSERT INTO "+tableName+"("+MatchKeys+") VALUES ("+String.join(",", ValueUnknown)+")";
		String[] TypeList=MatchValueTypes.split(",");
		int i=1;
		
		try{
		PreparedStatement ps = conn.prepareStatement(sql);
		for(String type :TypeList){
			ToString.PrepareSql(ps, i, ValueList[i-1], type);
			++i;
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
public boolean changeInfo(String tableName,int id,String Keys,String MatchValues,String MatchValueTypes){
		boolean ret=false;
		String[] ValueList=MatchValues.split(",");
		String[] ValueUnknown= new String[ValueList.length];
		String[] KeysList=Keys.split(",");
		String[] TypeList=MatchValueTypes.split(",");
		for(int index=0;index<ValueUnknown.length;++index){
			ValueUnknown[index]= KeysList[index]+"=?";
			}	
		
		String sql="UPDATE "+tableName+" SET "+String.join(",", ValueUnknown)+" WHERE id=?";
		Connection conn = getConn(); 
		try{
		PreparedStatement ps = conn.prepareStatement(sql);
		int i=1;
		for(String type :TypeList){
			ToString.PrepareSql(ps, i, ValueList[i-1], type);
			++i;
			}
		ToString.PrepareSql(ps, i, ToString.int2str(id), "int");
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
