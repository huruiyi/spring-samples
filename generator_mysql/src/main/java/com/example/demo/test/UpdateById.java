package com.example.demo.test;

import java.io.IOException;

import com.example.demo.mapping.UserInfo;
import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class UpdateById {

  public static void main(String[] args) throws IOException {
    SqlSession session = DBTools.getSqlSession();
    UserInfo userinfo = session.selectOne("selectById", 1000L);
    userinfo.setUsername("u1");
    userinfo.setPassword("pwd1");
    userinfo.setAge(5005);
    session.update("updateById", userinfo);
    session.commit();
    session.close();
  }
}
