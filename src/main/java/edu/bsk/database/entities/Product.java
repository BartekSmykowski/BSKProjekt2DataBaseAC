package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Product")
@Table(name = "products")
@Data
@EqualsAndHashCode(of = "id")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private final String name;

	@Column(name = "price")
	private final float price;

	@Column(name = "count")
	private final int count;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ProductionEvent> productionEvents;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<ProductResource> productResources;
}
