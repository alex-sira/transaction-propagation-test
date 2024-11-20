package it.alessandro.test.transaction_propagation_test.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="MY_NAME_ENTITY")
@Data
public class MyNameEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name", unique=true)
	private String name;
	@Column(name="schedulation_number")
	private int schedulationNumber;
}
