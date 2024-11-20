package it.alessandro.test.transaction_propagation_test.scheduler;

import it.alessandro.test.transaction_propagation_test.service.CreateMyNameEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(value="scheduler.name.enabled", matchIfMissing=true)
public class MyNameEntityScheduler {
	private int schedulationOccurrence = 0;
	private final CreateMyNameEntityService createMyNameEntityService;

	@Scheduled(initialDelay=10000, fixedDelay=20000)
	public void saveEntity() {
		log.info("Start schedulation number: [{}]", schedulationOccurrence);
		try {
			createMyNameEntityService.createName(schedulationOccurrence);
		} catch (Exception e) {
			log.error("Exception during the schedulation: [{}]", schedulationOccurrence, e);
		} finally {
			log.info("End schedulation number: [{}]", schedulationOccurrence++);
		}
	}
}
