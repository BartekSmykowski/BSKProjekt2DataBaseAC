package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	private int count;

	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Resource resource;

	public ProductResource() {
	}

	public ProductResource(Product product, Resource resource, int count){
		this.product = product;
		this.resource = resource;
		this.count = count;
	}
}
