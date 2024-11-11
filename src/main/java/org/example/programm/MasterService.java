package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@Table(name = "master_service")
@IdClass(MasterService.class)
public class MasterService {

    @Id
    @ManyToOne
    @JoinColumn(name = "master_id", nullable = false)
    private Master master;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
}
