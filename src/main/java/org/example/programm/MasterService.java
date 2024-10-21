package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name = "master_services") // Указываем имя таблицы в базе данных
public class MasterService {

    @Id
    @ManyToOne
    @JoinColumn(name = "master_id")
    private Masters masters; // Ссылка на мастера

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service; // Ссылка на услугу
}
