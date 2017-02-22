package utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
	public static Object getBean(String springid){
		@SuppressWarnings("resource")  
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		return apc.getBean(springid);
	}
}
