package librarypackage;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Runspringapp {  
public static void main(String[] args) {  
	//create container
    Resource resource=new ClassPathResource("applicationContext.xml");  
    //create bean factory
    BeanFactory factory=new XmlBeanFactory(resource);  
      
    //get bean from container
     Student student=(Student)factory.getBean("studentbean");  
     
     //call the method of bean
    student.displayInfo();  
}  
}  