package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query("SELECT a FROM Appointment a " +
            "where concat(a.id, a.client, a.master, a.service, a.appointmentDate, a.endTime) LIKE %?1%")
    List<Appointment> search(String keyword);
}
