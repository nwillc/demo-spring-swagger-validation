package com.example.demo;

import javax.validation.constraints.Min;

public class Ping {
    @Min(value = 1, message = "Must be at least 1")
    private int ping;

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }
}
