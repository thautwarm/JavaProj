
package entity;
import java.util.Map;
import java.util.HashMap;


public class Activity {
	private String content;
	private Long courseId;
	private Long id;
	private String name;
	
    public void setContent(String content){
        this.content=content;
    }
    

    public String getContent(){
        return content;
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
    

    public void setId(Long id){
        this.id=id;
    }
    
    public void setId(Integer id){
        this.id= Long.valueOf(id.toString());
    }
    

    public Long getId(){
        return id;
    }
    

    public void setName(String name){
        this.name=name;
    }
    

    public String getName(){
        return name;
    }
    

    public boolean setByKey(String ATTR_NAME, Object _SWITCH_VALUE){
        if (_SWITCH_VALUE==null) {
            System.out.println("setByKey-ValueNullError");
            return false;
            }
        
        switch(ATTR_NAME){

            case "content":
                this.setContent( (String) _SWITCH_VALUE );
                break;


            case "courseId":
                this.setCourseid( (Long) _SWITCH_VALUE );
                break;


            case "id":
                this.setId( (Long) _SWITCH_VALUE );
                break;


            case "name":
                this.setName( (String) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return content+","+courseId+","+id+","+name;
    }


    public static String toSQLColumns(){
        return "content,courseId,id,name";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("content","String");

    TypeMap.put("courseId","Long");

    TypeMap.put("id","Long");

    TypeMap.put("name","String");
    return TypeMap;
    }

}
