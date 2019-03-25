//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.api;

import java.util.List;
import java.util.Map;

public interface Select {
  <T> T get(String var1);

  <T> T get(String var1, Map<Integer, Object> var2);

  <T> List<T> select(String var1);

  <T> List<T> list(String var1, Map<Integer, Object> var2);
}
