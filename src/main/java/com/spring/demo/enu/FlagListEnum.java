package com.spring.demo.enu;

/**
 * 返回码
 * @author  milo
 * @date 2018-09-26
 */
public enum FlagListEnum {

    FLG_LIST_NOT_DELETE(0,"未删除"),
    FLG_LIST_DELETED(1,"已删除");
    private final int key;
    private final String value;

    private FlagListEnum(int key, String value) {
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
        FlagListEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            FlagListEnum e = var1[var3];
            if (e.getKey() == key) {
                return e.value;
            }
        }
        return null;
    }
}
