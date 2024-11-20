package it.alessandro.test.transaction_propagation_test.service.crud;

import it.alessandro.test.transaction_propagation_test.model.MyNumberEntity;
import it.alessandro.test.transaction_propagation_test.repository.MyNumberEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyNumberEntityService {

	private final MyNumberEntityRepository myNumberEntityRepository;

	public MyNumberEntity save(MyNumberEntity myNumberEntity) {
		log.info("Saving MyNumberEntity with number: [{}]", myNumberEntity.getSchedulationNumber());
		myNumberEntity.setId(null);
		myNumberEntityRepository.save(myNumberEntity);
		log.info("Saved MyNumberEntity with id: [{}]", myNumberEntity.getId());
		return myNumberEntity;
	}
}
