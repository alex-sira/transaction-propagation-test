package it.alessandro.test.transaction_propagation_test.repository;

import it.alessandro.test.transaction_propagation_test.model.MyNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyNumberEntityRepository extends JpaRepository<MyNumberEntity,Long> {
}
