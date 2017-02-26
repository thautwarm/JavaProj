package Test;

import dao.UserDao;
import entity.User;
public class Arg {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		UserCollection usrc= new UserCollection();
//		usrc.setCollecteddate(GraceJava.ToStr.str2Timestamp("1999-01-01 12:20:60"));
//		usrc.setId(7);
//		UserCollectionDao usd = new UserCollectionDao();
//		System.out.println(usd.add(usrc));
		User user=new User();
		user.setAccess(3);
		user.setEmail("a@qq.com");
		user.setExperience(100);
		user.setHead("head");
		user.setId(200);
		user.setUsername("Saber");
		user.setPassword("iris");
		user.setLevel(1);
		user.setPhone("233666");
		user.setPocketid(1);
		user.setSex(0);
		UserDao usd = new UserDao();
		System.out.println(usd.add(user));
		System.out.println(usd.selectEntity("id,username",Long.valueOf("200"),"Saber"));
		System.out.println(usd.deleteByKeys("id", "200"));
		System.out.println(usd.selectEntity(user).get(0).toSQLValues());
//	String a= "null,null,null,null";
//	String c=",,";
////	String[] b=ToStr.ExceptNull(c,a);
//		System.out.println(String.join(",",c.split(",")));
////	
	}

}
