package it.alessandro.test.transaction_propagation_test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="MY_NUMBER_ENTITY")
@Data
public class MyNumberEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="schedulation_number")
	private int schedulationNumber;
}
