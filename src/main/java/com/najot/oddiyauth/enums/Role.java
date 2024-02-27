package com.najot.oddiyauth.enums;

import java.util.List;

import static com.najot.oddiyauth.enums.Permission.*;

public enum Role {
    ADMIN(List.of(CREATE_PRODUCT,UPDATE_PRODUCT,DELETE_PRODUCT,READ_PRODUCT)),
    USER(List.of(READ_PRODUCT));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
