package com.itb.sms.enums;

public enum StudentType {

    GENERAL((byte) 1, "General"),
    SSC_VOC((byte) 2, "SSC(VOC)"),
    HSC_VOC((byte) 3, "HSC(VOC)"),
    HSC_BM((byte) 4, "HSC(BM)");

    private final Byte key;
    private final String value;

    StudentType(Byte key, String value) {
        this.key = key;
        this.value = value;
    }

    public static StudentType get(Byte id) {
        for (StudentType type : StudentType.values()) {
            if (type.key.equals(id)) return type;
        }
        return GENERAL;
    }
    public static String getValue(Byte id) {
        if (id == null) return GENERAL.getValue();
        StudentType status = get(id);
        if (status != null) return status.getValue();
        return GENERAL.getValue();
    }

    public Byte getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
