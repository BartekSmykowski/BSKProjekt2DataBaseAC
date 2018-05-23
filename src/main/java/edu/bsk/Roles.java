package edu.bsk;

import java.util.ArrayList;
import java.util.List;

public enum Roles {
    NO_ROLE, ADMIN, BRYGADZISTA, MAGAZYNIER, SPRZEDAWCA, MANAGER_ZATRUDNIENIA, PROJEKTANT_PRODUKTOW;

    public static List<String> getRoles(){
        List<String> result = new ArrayList<>();
        for (Roles role :
                values()) {
            result.add(role.toString().toLowerCase());
        }
        return result;
    }
}
