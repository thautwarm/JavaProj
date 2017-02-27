
package entity;
import java.util.Map;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Date;



public class Course {
	private Long id;
	private String name;
	private String info;
	private Long categoryId;
	private Date createdDate;
	private Integer mode;
	private String image;
	private Long teacherId;
	
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
    

    public void setInfo(String info){
        this.info=info;
    }
    

    public String getInfo(){
        return info;
    }
    

    public void setCategoryid(Long categoryId){
        this.categoryId=categoryId;
    }
    
    public void setCategoryid(Integer categoryId){
        this.categoryId= Long.valueOf(categoryId.toString());
    }
    

    public Long getCategoryid(){
        return categoryId;
    }
    

    public void setCreateddate(Date createdDate){
        this.createdDate=createdDate;
    }
    

    public Date getCreateddate(){
        return createdDate;
    }
    

    public void setMode(Integer mode){
        this.mode=mode;
    }
    

    public Integer getMode(){
        return mode;
    }
    

    public void setImage(String image){
        this.image=image;
    }
    

    public String getImage(){
        return image;
    }
    

    public void setTeacherid(Long teacherId){
        this.teacherId=teacherId;
    }
    
    public void setTeacherid(Integer teacherId){
        this.teacherId= Long.valueOf(teacherId.toString());
    }
    

    public Long getTeacherid(){
        return teacherId;
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


            case "info":
                this.setInfo( (String) _SWITCH_VALUE );
                break;


            case "categoryId":
                this.setCategoryid( (Long) _SWITCH_VALUE );
                break;


            case "createdDate":
                this.setCreateddate( (Date) _SWITCH_VALUE );
                break;


            case "mode":
                this.setMode( (Integer) _SWITCH_VALUE );
                break;


            case "image":
                this.setImage( (String) _SWITCH_VALUE );
                break;


            case "teacherId":
                this.setTeacherid( (Long) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return id+","+name+","+info+","+categoryId+","+(new Timestamp (createdDate.getTime()))+","+mode+","+image+","+teacherId;
    }


    public static String toSQLColumns(){
        return "id,name,info,categoryId,createdDate,mode,image,teacherId";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("id","Long");

    TypeMap.put("name","String");

    TypeMap.put("info","String");

    TypeMap.put("categoryId","Long");

    TypeMap.put("createdDate","Date");

    TypeMap.put("mode","Integer");

    TypeMap.put("image","String");

    TypeMap.put("teacherId","Long");
    return TypeMap;
    }

}
