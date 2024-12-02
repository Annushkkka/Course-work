package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MasterServiceRepository extends JpaRepository<MasterService, Integer> {
    @Query("SELECT ms FROM MasterService ms " +
            "WHERE CONCAT(ms.master.id, ' ', " +
            "ms.service.id, ' ', " +
            "ms.master.firstName, ' ', " +
            "ms.master.lastName, ' ', " +
            "ms.master.middleName, ' ', " +
            "ms.service.name, ' ', " +
            "ms.service.basePrice, ' ', " +
            "ms.master.category.priceMultiplier) LIKE %?1%")
    List<MasterService> search(String keyword);
}
