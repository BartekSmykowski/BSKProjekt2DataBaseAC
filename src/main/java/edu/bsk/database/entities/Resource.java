package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "Resource")
@Table(name = "resources")
@Data
@EqualsAndHashCode(of = "id")
public class Resource
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private final String name;

	@Column(name = "count")
	private final int count;
}
