package vip.fairy.demo;


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import vip.fairy.demo.config.AppConfig;


public class DemoServletContainerInitializer implements WebApplicationInitializer {

  public static final String MSG = "Starting Demo Web Application";

  private final String TMP_FOLDER = "/tmp";
  private final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

  @Override
  public void onStartup(ServletContext servletContext) {

    //https://www.baeldung.com/spring-file-upload
    servletContext.log(MSG);

    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(AppConfig.class);

    DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

    ServletRegistration.Dynamic courtRegistration = servletContext.addServlet("demo", dispatcherServlet);
    courtRegistration.addMapping("/");
    courtRegistration.setLoadOnStartup(1);

//		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
//				MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//		courtRegistration.setMultipartConfig(multipartConfigElement);
  }
}
