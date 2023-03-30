package com.advance.aurore_rh.utils;

import lombok.Getter;

@Getter
public enum StatutEmployer {

    ACTIF(0,"ACTIF"),
    INACTIF(1, "INACTIF");

    private int key ;
    private String value;

    StatutEmployer(int i, String s) {
        this.key = i;
        this.value = s;
    }
}
