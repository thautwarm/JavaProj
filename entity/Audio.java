
package entity;
import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Date;



public class Audio {
	private Long id;
	private String name;
	private Long courseId;
	private Date uploadDate;
	private Integer order;
	private String src;
	private Integer inteval;
	private Integer click;
	
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
    

    public void setCourseid(Long courseId){
        this.courseId=courseId;
    }
    
    public void setCourseid(Integer courseId){
        this.courseId= Long.valueOf(courseId.toString());
    }
    

    public Long getCourseid(){
        return courseId;
    }
    

    public void setUploaddate(Date uploadDate){
        this.uploadDate=uploadDate;
    }
    

    public Date getUploaddate(){
        return uploadDate;
    }
    

    public void setOrder(Integer order){
        this.order=order;
    }
    

    public Integer getOrder(){
        return order;
    }
    

    public void setSrc(String src){
        this.src=src;
    }
    

    public String getSrc(){
        return src;
    }
    

    public void setInteval(Integer inteval){
        this.inteval=inteval;
    }
    

    public Integer getInteval(){
        return inteval;
    }
    

    public void setClick(Integer click){
        this.click=click;
    }
    

    public Integer getClick(){
        return click;
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


            case "name":
                this.setName( (String) _SWITCH_VALUE );
                break;


            case "courseId":
                this.setCourseid( (Long) _SWITCH_VALUE );
                break;


            case "uploadDate":
                this.setUploaddate( (Date) _SWITCH_VALUE );
                break;


            case "order":
                this.setOrder( (Integer) _SWITCH_VALUE );
                break;


            case "src":
                this.setSrc( (String) _SWITCH_VALUE );
                break;


            case "inteval":
                this.setInteval( (Integer) _SWITCH_VALUE );
                break;


            case "click":
                this.setClick( (Integer) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return id+","+name+","+courseId+","+(new Timestamp (uploadDate.getTime()))+","+order+","+src+","+inteval+","+click;
    }


    public static String toSQLColumns(){
        return "id,name,courseId,uploadDate,order,src,inteval,click";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("id","Long");

    TypeMap.put("name","String");

    TypeMap.put("courseId","Long");

    TypeMap.put("uploadDate","Date");

    TypeMap.put("order","Integer");

    TypeMap.put("src","String");

    TypeMap.put("inteval","Integer");

    TypeMap.put("click","Integer");
    return TypeMap;
    }

}
