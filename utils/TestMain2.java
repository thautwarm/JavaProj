package utils;

import java.util.ArrayList;
import java.util.Map;

import dao.userDao;
import entity.User;
import entity.userCollection;

public class TestMain2 {
	public static void main(String[] args) {
		
//userCollection test
//		userCollection usrc= new userCollection();
//		usrc.setCollecteddate(GraceJava.str2date("1990-01-01 12:20:60"));
//		usrc.setCourseid(1);
//		usrc.setId(1);
//		usrc.setUserid(1);
//		System.out.println(usrc);
	
	//user_test: select more than one sample.
		userDao ud= new userDao();
		ArrayList<Map<String,String>> mappings= ud.SelectByKeys("username","level" ,"1");
		Map<String,String> map =ud.SelectById("username", 1);
		System.out.println(mappings);
		System.out.println(map);
	}

	public static void print(Object ...a){
		System.out.println(a);
	}

}
