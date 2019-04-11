package issue.test.controller;

import dubbo.test.api.DemoService;
import dubbo.test.domain.Student;
import issue.test.servlet.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private DemoService demoService;
    @Autowired
    private TestBean testBean;

    @RequestMapping(path = "/testController")
    public String hello() {
        System.out.println("hello");
        Student student = new Student();
        student.setName("hello");
        student.setSchool("test");
        return demoService.sayHello(student);
    }
}
