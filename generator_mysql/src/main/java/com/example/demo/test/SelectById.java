package com.example.demo.test;

import java.io.IOException;

import com.example.demo.mapping.UserInfo;
import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class SelectById {

  public static void main(String[] args) throws IOException {
    SqlSession session = DBTools.getSqlSession();
    UserInfo userinfo = session.selectOne("selectById", 1000L);
    System.out.println(userinfo);
    session.commit();
    session.close();
  }
}
