package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Product")
@Table(name = "product")
@Data
@EqualsAndHashCode(of = "id")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private float price;

	@Column(name = "count")
	private int count;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<ProductionEvent> productionEvents = new ArrayList<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<ProductResource> productResources = new ArrayList<>();

	public Product(){

	}

	public Product(String name, float price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public void addResource(Resource resource, int count){
		ProductResource productResource = new ProductResource(this, resource, count);
		resource.getProductResources().add(productResource);
		this.getProductResources().add(productResource);
	}
}
