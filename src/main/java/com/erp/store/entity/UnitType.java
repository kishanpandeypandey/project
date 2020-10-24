package com.erp.store.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "unit_type")
public class UnitType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_type_id")
    private long id;

    @Column(unique = true)
    private String name;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate localDate) {
        this.createdOn = localDate;
    }
}
