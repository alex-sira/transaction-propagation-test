package it.alessandro.test.transaction_propagation_test.service;

import it.alessandro.test.transaction_propagation_test.service.crud.MyNameEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidationNameService {

	private final MyNameEntityService myNameEntityService;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean isValidName(String name, int schedulationNumber) {
		boolean isValid = true;
		try {
			myNameEntityService.save(name, schedulationNumber);
		} catch (Exception e) {
			log.warn("Name: [{}] cannot be used because it already exists", name);
			isValid = false;
		}
		return isValid;
	}
}