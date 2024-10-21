package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "masters") // Указываем имя таблицы в базе данных
public class Masters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Используем camelCase для переменных

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "grade_id")
    private Integer gradeId; // Используем camelCase для переменных

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;
}
