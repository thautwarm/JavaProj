
package entity;
import java.util.Map;
import java.util.HashMap;


public class User {
	private Long id;
	private String username;
	private String password;
	private Integer sex;
	private String email;
	private String phone;
	private Long pocketId;
	private String head;
	private Integer level;
	private Integer experience;
	private Integer access;
	
    public void setId(Long id){
        this.id=id;
    }
    
    public void setId(Integer id){
        this.id= Long.valueOf(id.toString());
    }
    

    public Long getId(){
        return id;
    }
    

    public void setUsername(String username){
        this.username=username;
    }
    

    public String getUsername(){
        return username;
    }
    

    public void setPassword(String password){
        this.password=password;
    }
    

    public String getPassword(){
        return password;
    }
    

    public void setSex(Integer sex){
        this.sex=sex;
    }
    

    public Integer getSex(){
        return sex;
    }
    

    public void setEmail(String email){
        this.email=email;
    }
    

    public String getEmail(){
        return email;
    }
    

    public void setPhone(String phone){
        this.phone=phone;
    }
    

    public String getPhone(){
        return phone;
    }
    

    public void setPocketid(Long pocketId){
        this.pocketId=pocketId;
    }
    
    public void setPocketid(Integer pocketId){
        this.pocketId= Long.valueOf(pocketId.toString());
    }
    

    public Long getPocketid(){
        return pocketId;
    }
    

    public void setHead(String head){
        this.head=head;
    }
    

    public String getHead(){
        return head;
    }
    

    public void setLevel(Integer level){
        this.level=level;
    }
    

    public Integer getLevel(){
        return level;
    }
    

    public void setExperience(Integer experience){
        this.experience=experience;
    }
    

    public Integer getExperience(){
        return experience;
    }
    

    public void setAccess(Integer access){
        this.access=access;
    }
    

    public Integer getAccess(){
        return access;
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


            case "username":
                this.setUsername( (String) _SWITCH_VALUE );
                break;


            case "password":
                this.setPassword( (String) _SWITCH_VALUE );
                break;


            case "sex":
                this.setSex( (Integer) _SWITCH_VALUE );
                break;


            case "email":
                this.setEmail( (String) _SWITCH_VALUE );
                break;


            case "phone":
                this.setPhone( (String) _SWITCH_VALUE );
                break;


            case "pocketId":
                this.setPocketid( (Long) _SWITCH_VALUE );
                break;


            case "head":
                this.setHead( (String) _SWITCH_VALUE );
                break;


            case "level":
                this.setLevel( (Integer) _SWITCH_VALUE );
                break;


            case "experience":
                this.setExperience( (Integer) _SWITCH_VALUE );
                break;


            case "access":
                this.setAccess( (Integer) _SWITCH_VALUE );
                break;


            default :
                System.out.println("setByKey-KeyNotFoundError");
                break;

            }
        
        
        return true;
    }

	
    public String toSQLValues(){
        return id+","+username+","+password+","+sex+","+email+","+phone+","+pocketId+","+head+","+level+","+experience+","+access;
    }


    public static String toSQLColumns(){
        return "id,username,password,sex,email,phone,pocketId,head,level,experience,access";
    }


    public static Map<String,String> getTypeMap(){
    Map<String,String> TypeMap=new HashMap<String,String>();
    
    TypeMap.put("id","Long");

    TypeMap.put("username","String");

    TypeMap.put("password","String");

    TypeMap.put("sex","Integer");

    TypeMap.put("email","String");

    TypeMap.put("phone","String");

    TypeMap.put("pocketId","Long");

    TypeMap.put("head","String");

    TypeMap.put("level","Integer");

    TypeMap.put("experience","Integer");

    TypeMap.put("access","Integer");
    return TypeMap;
    }

}
