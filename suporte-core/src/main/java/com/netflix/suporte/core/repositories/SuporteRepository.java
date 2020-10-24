package com.netflix.suporte.core.repositories;

import com.netflix.suporte.core.repositories.entities.SuporteEntiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuporteRepository extends JpaRepository<SuporteEntiy, Long> {
}
