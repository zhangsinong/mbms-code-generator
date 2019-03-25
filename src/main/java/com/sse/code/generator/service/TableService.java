//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.generator.service;

import com.sse.code.connector.sql.Column;
import com.sse.code.connector.sql.Table;
import java.util.List;

public interface TableService {
  List<Table> findList(String var1);

  List<Column> findColumnList(String var1);
}
