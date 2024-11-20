package it.alessandro.test.transaction_propagation_test.service.crud;

import it.alessandro.test.transaction_propagation_test.model.MyNameEntity;
import it.alessandro.test.transaction_propagation_test.repository.MyNameEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyNameEntityService {

	private final MyNameEntityRepository myNameEntityRepository;

	public MyNameEntity save(String name, int schedulationNumber) {
		log.info("Saving MyNameEntity with name: [{}]", name);
		MyNameEntity myNameEntity = new MyNameEntity();
		myNameEntity.setName(name);
		myNameEntity.setSchedulationNumber(schedulationNumber);
		myNameEntityRepository.save(myNameEntity);
		log.info("Saved MyNameEntity with id: [{}]", myNameEntity.getId());
		return myNameEntity;
	}
}
