package com.test.app.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
   private static SqlSessionFactory sessionFactory=null;
   // "按眉客 公包窍霸"
   static {
      try {
         if(sessionFactory == null) {
            Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
            sessionFactory=new SqlSessionFactoryBuilder().build(reader);
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public static SqlSession getSqlSessionInstance() {
	      return sessionFactory.openSession();
   }

   
}
