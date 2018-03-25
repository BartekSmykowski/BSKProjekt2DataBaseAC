package edu.bsk.database.entities;

import java.util.Collection;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "employees")
@Data
@EqualsAndHashCode(of = "PESEL")
public class Employee
{
	@Id
	@Column(name = "PESEL")
	private String PESEL;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "postCode")
	private String postCode;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "buildingNumber")
	private String buildingNumber;

	@Column(name = "houseNumber")
	private String houseNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "employmentDate")
	private Date employmentDate;

	@Column(name = "permanent")
	private Boolean permanent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "nickname")
	private Date employmentFinishedDate;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Collection<ProductionEvent> productionEvents;
}
