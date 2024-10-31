package com.itb.sms.enums;

public enum Shit {

    MORNING((byte) 1, "Morning"),
    DAY((byte) 2, "Day"),
    EVENING((byte) 3, "HSC(VOC)"),
    HSC_BM((byte) 4, "HSC(BM)");

    private final Byte key;
    private final String value;

    Shit(Byte key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Shit get(Byte id) {
        for (Shit type : Shit.values()) {
            if (type.key.equals(id)) return type;
        }
        return DAY;
    }
    public static String getValue(Byte id) {
        if (id == null) return DAY.getValue();
        Shit status = get(id);
        if (status != null) return status.getValue();
        return DAY.getValue();
    }

    public Byte getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
