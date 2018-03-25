package edu.bsk.database.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "User")
@Table(name = "users", uniqueConstraints =
@UniqueConstraint(columnNames = { "nickname", "password", "role"}))
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

	@Column(name = "role", nullable = false)
	private String role;
}
