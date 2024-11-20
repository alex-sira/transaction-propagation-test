package it.alessandro.test.transaction_propagation_test.service;

import it.alessandro.test.transaction_propagation_test.model.MyNumberEntity;
import it.alessandro.test.transaction_propagation_test.service.crud.MyNumberEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateMyNameEntityService {

	private final MyNumberEntityService myNumberEntityService;
	private final ValidationNameService validationNameService;

	@Transactional
	public void createName(int schedulatioNumber) throws InterruptedException {
		MyNumberEntity myNumberEntity = new MyNumberEntity();
		myNumberEntity.setSchedulationNumber(schedulatioNumber);
		myNumberEntityService.save(myNumberEntity);
		boolean isValid;
		int attempt = 0;
		do {
			attempt++;
			String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
			isValid = validationNameService.isValidName(name, schedulatioNumber);

			if (isValid) {
				break;
			}
			Thread.sleep(20000);
		} while (attempt < 10);
	}
}