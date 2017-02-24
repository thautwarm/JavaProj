package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class GraceJava {
public GraceJava(){
	}
	public static String int2str(int a){
		Integer x= (Integer) a;
		return x.toString();
	}
	public static int str2int(String a){
		
		return Integer.parseInt(a);
		
	}
	
	public static String date2str(Timestamp a){
		return a.toString();
	}
	
	public static Timestamp str2date(String a){
		return  Timestamp.valueOf(a);
	}
	
	public static String double2str(double a){
		return ((Double)a).toString();
	}
	public static double str2double(String a){
		return Double.parseDouble(a);
	}
	public static void PrepareSql(PreparedStatement ps,int index,String value,String type) throws SQLException{
		switch (type){
		
		case "String":
			ps.setString(index,value);
			break;
			
		case "int":
			ps.setInt(index,GraceJava.str2int(value));
			break;
			
		case "Timestamp" :
			ps.setTimestamp(index, GraceJava.str2date(value));
			break;
		
		case "double":
			ps.setDouble(index, GraceJava.str2double(value));
			break;
			
		default:
			System.out.println("SQLValueTypeError");
			return;
		}
	}
	
	
	public static Map<String,String> MapFill(ResultSet res,String[] Keys,Map<String,String> colMAPtype){
		boolean getNull=false;
		Map<String,String> map = new HashMap<String,String>();
		
		String type;
		try{
			
			for(String key : Keys){
				
				type=colMAPtype.get(key);
				switch (type){
					case "String":
						map.put(key, res.getString(key));
						break;
				
					case "int":
						
						map.put(key, int2str(res.getInt(key)));
						break;
				
					case "Timestamp" :
						map.put(key, date2str(res.getTimestamp(key)));
						break;
			
					case "double":
						map.put(key, double2str(res.getDouble(key)));
						break;
				
					default:
						System.out.println("SQLValueTypeError");
				}
			if (!getNull)
				getNull=true;
			
			}
		}
		catch(SQLException e){
			System.out.println("MapFillError");
			e.printStackTrace();
		}
		
		return (getNull==false)?null:map;
	}
	
	public static void p(Object ...a){
		System.out.println(a);
	}
	public static String repeat(String x,String format,int n){
		String ret="";
		for(int i=0;i<n-1;++i){
			ret+=x+format;
		}
		return ret+x;
	}
	public static void main(String[] args){
		System.out.println("a".split(",").length);
	}
}
