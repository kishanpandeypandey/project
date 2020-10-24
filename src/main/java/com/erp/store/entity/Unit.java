package com.erp.store.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "unit")
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private long id;

    private String name;

    private boolean status;

    private String description;

    
    @Column(name = "unit_type_id")
    private Long unitType;

    private LocalDate createdOn;

    private String type;
    private LocalDate updatedOn;

    private long createdBy;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUnitType() {
        return unitType;
    }

    public void setUnitType(Long unitType) {
        this.unitType = unitType;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
}
