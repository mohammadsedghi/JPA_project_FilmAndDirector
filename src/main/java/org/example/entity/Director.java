package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.base.entity.BaseEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Director extends BaseEntity<Long> {
    String name;
    String family;
}
