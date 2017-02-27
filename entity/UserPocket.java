
package entity;
import java.util.Map;
import java.util.HashMap;


public class UserPocket {
	private Long id;
	private Integer total;
	
    public void setId(Long id){
        this.id=id;
    }
    
    public void setId(Integer id){
        this.id= Long.valueOf(id.toString());
    }
    

    public Long getId(){
        return id;
    }
    

    public void setTotal(Integer total){
        this.total=total;
    }
    

    public Integer getTotal(){
        return total;
    }
    

    public boolean setByKey(String ATTR_NAME, Object _SWITCH_VALUE){
        if (_SWITCH_VALUE==null) {
            System.out.println("setByKey-ValueNullError");
            return false;
            }
        
        switch(ATTR_NAME){

            case "id":
                this.setId( (Long) _SWITCH_VALUE );
                break;


            case "total":
                this.setTotal( (Integer) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return id+","+total;
    }


    public static String toSQLColumns(){
        return "id,total";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("id","Long");

    TypeMap.put("total","Integer");
    return TypeMap;
    }

}
