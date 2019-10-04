package com.example.sampleflux;

public class Action {
    public static final String GET_CURRENT_TIME = "GET_CURRENT_TIME";
    public static final String CLOSE_VIEW1 = "CLOSE_VIEW1";
    public static final String CLOSE_VIEW2 = "CLOSE_VIEW2";

    public Action(String name) {
        this(name, null);
    }

    public Action(String name, Object payload) {
        this.name = name;
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public Object getPayload() {
        return payload;
    }

    private final String name;
    private final Object payload;
}
