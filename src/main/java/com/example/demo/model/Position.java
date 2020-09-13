package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Position {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int level;
    private @NonNull String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
