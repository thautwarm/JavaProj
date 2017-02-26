package GraceJava;
import java.sql.Timestamp;
import java.util.Date;

public class ToStr {
		public ToStr(){
		}
	public static Long str2long(String a){
		if (a==null||a.equals("null")) return null;
		return Long.valueOf(a);
		
	}
	public static Integer str2int(String a){
		if (a==null||a.equals("null")) return null;
		return Integer.valueOf(a);
	}
	
	
	
	public static String date2sqldate(Date a){
		if (a==null) return null;
		return  new Timestamp(a.getTime()).toString();
	}
	
	public static Date sqldate2date(Timestamp a){
		if (a==null) return null;
		return  new Date(a.getTime());
	}
	
	public static Timestamp str2Timestamp(String a){
		if (a==null||a.equals("null")) return null;
		return Timestamp.valueOf(a);
		
	}
	public static Date Timestamp2Date(Timestamp date){
		if (date==null) return null;
		return  new Date(date.getTime());
	}
	public static Timestamp Date2Timestamp(Date date){
		if (date==null) return null;
		return  new Timestamp(date.getTime());
	}
	
	
	public static String double2str(Double a){
		if (a==null) return null;
		return a.toString();
	}
	public static Double str2double(String a){
		if (a==null) return null;
		return Double.valueOf(a);
	}
	
	public static String[] ExceptNull(String columns,String values){
		String[] columnsList=columns.split(",");
		String[] valuesList=values.split(",");
		columns="";
		values="";
		int index=0;
		int num=valuesList.length;
		for(;index<num;++index){
			String value=valuesList[index];
			if (!value.equals(null)&&(!value.equals("null"))){
			columns=columns+columnsList[index]+",";
			values=values+value+",";
			}
		}
		columns=String.join(",",columns.split(",") );
		values=String.join(",", values.split(","));
		String []ret=new String[]{columns,values};
		return ret;
	}
	public static void main(String[] args){
		Long a= null;
		
		System.out.println(((Object) a));
	}
}
