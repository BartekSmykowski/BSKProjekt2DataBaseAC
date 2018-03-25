package edu.bsk.database.entities;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "ProductionEvent")
@Table(name = "production_events")
@Data
@EqualsAndHashCode(of = "id")
public class ProductionEvent
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn")
	private Date createdOn;

	@Column(name = "count")
	private int count;

	@Column(name = "productionLine")
	private int productionLine;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "productionTime")
	private Date productionTime;

	@Column(name = "workplace")
	private int workplace;

	@ManyToOne(fetch = FetchType.LAZY)
	private final Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	private final Employee employee;
}
