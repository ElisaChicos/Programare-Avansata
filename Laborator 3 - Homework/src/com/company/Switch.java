package com.company;

public class Switch extends Node {
    private boolean configurable;

    public Switch(boolean configurable) {
        this.configurable = configurable;
    }

    public Switch(String name, String MACAddress, String MAPlocation, boolean configurable) {
        super(name, MACAddress, MAPlocation);
        this.configurable = configurable;
    }

    public boolean isConfigurable() {
        return configurable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "configurable=" + configurable +
                '}';
    }
}
