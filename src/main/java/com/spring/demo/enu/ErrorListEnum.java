package com.spring.demo.enu;

/**
 * 返回码
 * @author  milo
 * @date 2018-09-26
 */
public enum ErrorListEnum {

    ERROR_LIST_SUCCESS(200,"操作成功"),
    ERROR_LIST_FAIL(201,"操作失败");


    private final int key;
    private final String value;

    private ErrorListEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public static String getValue(int key) {
        ErrorListEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorListEnum e = var1[var3];
            if (e.getKey() == key) {
                return e.value;
            }
        }
        return null;
    }
}
