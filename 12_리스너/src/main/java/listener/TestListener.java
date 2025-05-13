package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import util.LoginManager;

@WebListener
public class TestListener implements ServletContextListener {

    public TestListener() {
    	System.out.println("ServletContextListener 객체 생성");
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	System.out.println("TestListener - 웹 애플리케이션 시작!");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("TestListener - 웹 애플리케이션 종료!");
    }
	
}
