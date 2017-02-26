
package entity;
import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Date;



public class UserCollection {
	private Long id;
	private Long userId;
	private Long courseId;
	private Date collectedDate;
	
    public void setId(Long id){
        this.id=id;
    }
    
    public void setId(Integer id){
        this.id= Long.valueOf(id.toString());
    }
    

    public Long getId(){
        return id;
    }
    

    public void setUserid(Long userId){
        this.userId=userId;
    }
    
    public void setUserid(Integer userId){
        this.userId= Long.valueOf(userId.toString());
    }
    

    public Long getUserid(){
        return userId;
    }
    

    public void setCourseid(Long courseId){
        this.courseId=courseId;
    }
    
    public void setCourseid(Integer courseId){
        this.courseId= Long.valueOf(courseId.toString());
    }
    

    public Long getCourseid(){
        return courseId;
    }
    

    public void setCollecteddate(Date collectedDate){
        this.collectedDate=collectedDate;
    }
    

    public Date getCollecteddate(){
        return collectedDate;
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


            case "userId":
                this.setUserid( (Long) _SWITCH_VALUE );
                break;


            case "courseId":
                this.setCourseid( (Long) _SWITCH_VALUE );
                break;


            case "collectedDate":
                this.setCollecteddate( (Date) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return id+","+userId+","+courseId+","+(new Timestamp (collectedDate.getTime()));
    }


    public static String toSQLColumns(){
        return "id,userId,courseId,collectedDate";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("id","Long");

    TypeMap.put("userId","Long");

    TypeMap.put("courseId","Long");

    TypeMap.put("collectedDate","Date");
    return TypeMap;
    }

}
