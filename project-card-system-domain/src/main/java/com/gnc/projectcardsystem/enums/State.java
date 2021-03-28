package com.gnc.projectcardsystem.enums;

public enum State {
    ACTIVE(0), PASSIVE(1);

    int order;

    State(int order) {
        this.order = order;
    }
}
