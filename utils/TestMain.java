package utils;

import java.sql.Timestamp;
import dao.categoryDao;
import dao.courseDao;
import entity.Category;
import entity.Course;


public class TestMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User user=new User();
//		user.setAccess(3);
//		user.setEmail("a@qq.com");
//		user.setExperience(100);
//		user.setHead("head");
//		user.setId(1);
//		user.setUsername("SaberLily");
//		user.setPassword("iris");
//		user.setLevel(1);
//		user.setPhone("233666");
//		user.setPocketid(5);
//		user.setSex(0);
		Course course=new Course();
		{
		course.setId(3);
		course.setInfo("blibli!");
		course.setMode(1);
		course.setName("高等哲学");
		course.setCreateddate(Timestamp.valueOf("1990-01-01 12:20:60"));
		course.setImage("niconiconi");
		course.setCategoryid(5);
		course.setTeacherid(2);
		}
		Course course2=new Course();
		{
		course2.setId(7);
		course2.setInfo("blibli!");
		course2.setMode(1);
		course2.setName("哲♂学");
		course2.setCreateddate(Timestamp.valueOf("1990-01-01 12:20:60"));
		course2.setImage("niconiconi");
		course2.setCategoryid(5);
		course2.setTeacherid(2);
		}
		Category cate= new Category();
		{
			cate.setId(2);
			cate.setName("数学");
		}
		System.out.println(cate);
		
		courseDao cd= new courseDao();
		System.out.println(cd.add(course));
		System.out.println(cd.add(course2));
		
		categoryDao cgd= new categoryDao();
		System.out.println(cgd.add(cate));
//		String selectedkeys="username,id,email";
//		userDao usrd= new userDao();
//		System.out.println(usrd.updateById(user.getId(), user));
//		SQL sql =new SQL();
//		sql.setObj(User.toSQL());
//		Map<String,String> map=sql.Select("user", selectedkeys,"username", "Caster", "String");
//		if (map!=null){
//		for(String arg:selectedkeys.split(","))
//		{
//			ToString.p (arg+":"+map.get(arg));
//		}
//		}
//		String ret= sql.isDuplicatedByKey("user", "username", "Assasin", "String");
//		System.out.println(ret);
	}

}
