package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
@Table(name = "grades") // Указываем имя таблицы в базе данных
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID грейда

    @Column(name = "description", nullable = false)
    private String description; // Описание грейда
}
