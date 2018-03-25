package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;

@Entity(name = "ProductResource")
@Table(name = "product_resources")
@Data
@EqualsAndHashCode(of = "id")
public class ProductResource
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "count")
	private final int count;

	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	private Resource resource;
}
