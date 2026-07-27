package com.example.demo.test;

import com.example.demo.mapping.UserInfo;
import com.example.demo.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class SelectById {

  public static void main(String[] args) throws IOException {
    SqlSession session = DBTools.getSqlSession();
    UserInfo userinfo = session.selectOne("selectById", 1000L);
    System.out.println(userinfo);
    session.commit();
    session.close();
  }
}
