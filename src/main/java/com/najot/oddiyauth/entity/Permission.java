package com.najot.oddiyauth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "my_permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String permissionName;
}
