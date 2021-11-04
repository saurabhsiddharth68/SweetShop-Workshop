package com.blz.sweetshop;

import java.util.HashSet;
import java.util.Set;

public class SweetRepository {

    private Set<Sweet> sweetList = new HashSet();
    private static SweetRepository instance;

    SweetRepository() {

    }

    public static synchronized SweetRepository getInstance() {
        if (instance == null) {
            instance = new SweetRepository();
        }
        return instance;
    }

    public Set getSweetList() {

        return sweetList;
    }

    public void add(Sweet sweet) {
        sweetList.add(sweet);
    }

    public void delete(Sweet sweet) {

        sweetList.remove(sweet);
    }
    public Sweet getSweet(String sweetName) {
        for (Sweet sweet : sweetList) {
            if (sweet.name.equalsIgnoreCase(sweetName)) {
                return sweet;
            }
        }
        return null;
    }
}
