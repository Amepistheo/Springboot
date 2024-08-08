package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Item {

    private String direcctor;

    private String actor;

    public String getDirecctor() {
        return direcctor;
    }

    public void setDirecctor(String direcctor) {
        this.direcctor = direcctor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
