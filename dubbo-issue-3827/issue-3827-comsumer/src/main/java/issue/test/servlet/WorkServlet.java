package issue.test.servlet;

import dubbo.test.api.DemoService;
import dubbo.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class WorkServlet extends HttpServletBean {
    @Autowired
    private DemoService demoService;
    @Autowired
    private TestBean testBean;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("hello");
        Student student = new Student();
        student.setName("hello");
        student.setSchool("test");
        String sayHello = demoService.sayHello(student);
        res.getWriter().println(sayHello);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContextUtils
                .getWebApplicationContext(getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }
}
