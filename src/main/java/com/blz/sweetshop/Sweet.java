package com.blz.sweetshop;

import java.util.Objects;

public class Sweet {
    enum Colour {
        YELLOW, RED, WHITE, BROWN,;
    }
    enum Category {
        SUGAR, SUGARLESS, GHEE,JAGGERY,MILK,SWEET;
    }
    enum PropertyType{
        DIET, NORMAL
    }
    String name;
    Colour colour;
    Category category;
    PropertyType propertyType;
    int price;
    String id;

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + name + '\'' +
                ", colour=" + colour +
                ", category=" + category +
                ", propertyType=" + propertyType +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return id.equals(sweet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
