package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.base.entity.BaseEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Film extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;
    private String description;
    private String language;
    @ManyToOne
    private Director director;
    private int rate;
    private int length;

}
