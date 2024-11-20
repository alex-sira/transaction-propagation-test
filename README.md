# transaction-propagation-test
Test case for transaction propagation Issue in Springboot 3.3.5

In this application a scheduler each 20 seconds will create two entity:
- the first entity is MyNumberEntity and contains only the number of the schedulation
- the second entity is MyNameEntity. This entity has a column (name) with a unique constraint

In a while loop, the name of the second entity is created with the timestamp in this format: yyyyMMddHHmm
Every time the Database constraint block the insert of the second entity, the loop must retry it a few second later.
The issue is that the catch instruction in it.alessandro.test.transaction_propagation_test.service.ValidationNameService#isValidName is not working and the exception is propagated to the method it.alessandro.test.transaction_propagation_test.service.CreateMyNameEntityService#createName causing the rollback of the transaction

Is it possible to check that the first entity is not saved by accessing the H2 console at the address: http://localhost:8080/h2-console
