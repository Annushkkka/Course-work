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
@Table(name = "services") // Указываем имя таблицы в базе данных
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID услуги

    @Column(name = "name", nullable = false)
    private String name; // Название услуги

    @Column(name = "description")
    private String description; // Описание услуги

    @Column(name = "cost", nullable = false)
    private Integer cost; // Стоимость услуги

    @Column(name = "duration", nullable = false)
    private String duration; // Длительность услуги (можно использовать типы данных, соответствующие вашей схеме)
}