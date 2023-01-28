package com.example.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name="crud", schema = "los")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CRUDmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String phone;

    private String email;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> details;
}
