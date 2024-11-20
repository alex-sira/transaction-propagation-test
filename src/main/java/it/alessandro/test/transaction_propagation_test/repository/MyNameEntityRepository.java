package it.alessandro.test.transaction_propagation_test.repository;

import it.alessandro.test.transaction_propagation_test.model.MyNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyNameEntityRepository extends JpaRepository<MyNameEntity,Long> {
}
