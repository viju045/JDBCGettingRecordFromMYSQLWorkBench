package org.example;

import org.example.dao.GettingRecordDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBCWithGettingRecordFromDB {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        GettingRecordDao gettingRecordDao = applicationContext.getBean("JDBCGettingDao",GettingRecordDao.class);
        gettingRecordDao.getAllRecord();
    }
}