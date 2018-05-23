package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users", uniqueConstraints =
@UniqueConstraint(columnNames = { "nickname", "password"}))
@Data
@EqualsAndHashCode(of = "id")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nickname", nullable = false)
	private String nickname;

	@Column(name = "password", nullable = false)
	private String password;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false)
	private Date creationDate = new Date();

	@ElementCollection
	@CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role", nullable = false)
	private Set<String> roles = new HashSet<>();

	protected User(){

	}

	public User(String nickname, String password, Set<String> roles){
		this.nickname = nickname;
		this.password = password;
		this.roles = roles;
	}
}
