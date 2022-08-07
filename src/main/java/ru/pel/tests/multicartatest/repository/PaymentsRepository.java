package ru.pel.tests.multicartatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pel.tests.multicartatest.entity.Payment;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {
}
