package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Employees {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;
    private String nik;
    private String type;
    private String lastPosition;
    private int divisionId;
    private int positionId;
    @CreatedDate
    private Date createdDate;

    @PrePersist
    protected void prePersist() {
        if (this.createdDate == null) {
            createdDate = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(String lastPosition) {
        this.lastPosition = lastPosition;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
