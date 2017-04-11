package ru.rtlabs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.rtlabs.service.Service;
import ru.rtlabs.service.XlsParse;


public class Parser {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      //  Service service = context.getBean(Service.class);
        XlsParse  xlsParse = context.getBean(XlsParse.class);
        xlsParse.parse(args[0], args[1]);
    }
}
