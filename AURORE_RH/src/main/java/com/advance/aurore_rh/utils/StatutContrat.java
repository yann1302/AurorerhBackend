package com.advance.aurore_rh.utils;

import lombok.Getter;

@Getter
public enum StatutContrat {
    EN_COURS(0,"EN COURS"),
    TERMINER(1, "TERMINER"),
    SUSPENDU(2, "SUSPENDU");


    private int key ;
    private String value;

    StatutContrat(int i, String s) {
        this.key = i;
        this.value = s;
    }
}
