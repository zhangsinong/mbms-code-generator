//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sse.code.connector.util;

public class StringUtils extends org.springframework.util.StringUtils {
    public StringUtils() {
    }

    public static String underlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        String[] a = para.toLowerCase().split("_");
        String[] var3 = a;
        int var4 = a.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(capitalize(s));
            }
        }

        return result.toString();
    }

    public static String humpToUnderLine(String para) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < para.length(); ++i) {
            builder.append(Character.toLowerCase(para.charAt(i)));
            if (Character.isUpperCase(para.charAt(i)) && i != para.length() - 1) {
                builder.append("_");
            }
        }

        return builder.toString();
    }

    public static String getJdbcType(String columnType) {
        byte var2 = -1;
        switch(columnType.hashCode()) {
            case -2135304102:
                if (columnType.equals("mediumint")) {
                    var2 = 7;
                }
                break;
            case -2073465431:
                if (columnType.equals("longtext")) {
                    var2 = 2;
                }
                break;
            case -1389167889:
                if (columnType.equals("bigint")) {
                    var2 = 8;
                }
                break;
            case -1312398097:
                if (columnType.equals("tinyint")) {
                    var2 = 5;
                }
                break;
            case -1254919979:
                if (columnType.equals("varchar2")) {
                    var2 = 3;
                }
                break;
            case -606531192:
                if (columnType.equals("smallint")) {
                    var2 = 6;
                }
                break;
            case 104431:
                if (columnType.equals("int")) {
                    var2 = 9;
                }
                break;
            case 3052374:
                if (columnType.equals("char")) {
                    var2 = 4;
                }
                break;
            case 3076014:
                if (columnType.equals("date")) {
                    var2 = 13;
                }
                break;
            case 3556653:
                if (columnType.equals("text")) {
                    var2 = 1;
                }
                break;
            case 55126294:
                if (columnType.equals("timestamp")) {
                    var2 = 12;
                }
                break;
            case 236613373:
                if (columnType.equals("varchar")) {
                    var2 = 0;
                }
                break;
            case 1542263633:
                if (columnType.equals("decimal")) {
                    var2 = 10;
                }
                break;
            case 1793702779:
                if (columnType.equals("datetime")) {
                    var2 = 11;
                }
        }

        switch(var2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "VARCHAR";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "INTEGER";
            case 10:
                return "DECIMAL";
            case 11:
            case 12:
                return "TIMESTAMP";
            case 13:
                return "DATE";
            default:
                return "VARCHAR";
        }
    }

    public static String getJavaType(String columnType) {
        byte var2 = -1;
        switch(columnType.hashCode()) {
            case -2135304102:
                if (columnType.equals("mediumint")) {
                    var2 = 7;
                }
                break;
            case -2073465431:
                if (columnType.equals("longtext")) {
                    var2 = 2;
                }
                break;
            case -1389167889:
                if (columnType.equals("bigint")) {
                    var2 = 8;
                }
                break;
            case -1312398097:
                if (columnType.equals("tinyint")) {
                    var2 = 5;
                }
                break;
            case -1254919979:
                if (columnType.equals("varchar2")) {
                    var2 = 3;
                }
                break;
            case -606531192:
                if (columnType.equals("smallint")) {
                    var2 = 6;
                }
                break;
            case 104431:
                if (columnType.equals("int")) {
                    var2 = 9;
                }
                break;
            case 3052374:
                if (columnType.equals("char")) {
                    var2 = 4;
                }
                break;
            case 3076014:
                if (columnType.equals("date")) {
                    var2 = 13;
                }
                break;
            case 3556653:
                if (columnType.equals("text")) {
                    var2 = 1;
                }
                break;
            case 55126294:
                if (columnType.equals("timestamp")) {
                    var2 = 12;
                }
                break;
            case 236613373:
                if (columnType.equals("varchar")) {
                    var2 = 0;
                }
                break;
            case 1542263633:
                if (columnType.equals("decimal")) {
                    var2 = 10;
                }
                break;
            case 1793702779:
                if (columnType.equals("datetime")) {
                    var2 = 11;
                }
        }

        switch(var2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "String";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "Integer";
            case 10:
                return "BigDecimal";
            case 11:
            case 12:
            case 13:
                return "Date";
            default:
                return "String";
        }
    }

    public static void main(String[] args) {
        System.out.println("1 = " + underlineToHump("b_sdf_qqqq"));
        System.out.println("1 = " + humpToUnderLine("aBcD"));
    }
}
