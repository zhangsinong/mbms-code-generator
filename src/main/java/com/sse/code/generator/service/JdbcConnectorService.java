//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.service;

import com.sse.code.connector.JdbcConnector;

public interface JdbcConnectorService {
  JdbcConnector getConnector();

  void setConnector(JdbcConnector var1);

  void test(JdbcConnector var1);
}
