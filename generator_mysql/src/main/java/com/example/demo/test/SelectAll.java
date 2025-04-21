package com.example.demo.test;

import java.io.IOException;
import java.util.List;

import com.example.demo.mapping.UserInfo;
import org.apache.ibatis.session.SqlSession;

import com.example.demo.tools.DBTools;

public class SelectAll {

  public static void main(String[] args) throws IOException {
    SqlSession session = DBTools.getSqlSession();
    List<UserInfo> listUserinfo = session.selectList("selectAll");
    for (UserInfo userinfo : listUserinfo) {
      System.out.println(userinfo);
    }
    session.commit();
    session.close();
  }
}
