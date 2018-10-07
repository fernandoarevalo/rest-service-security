package co.edu.udistrital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends Auditable<String> {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	
	@Column(name = "NAME")
	private String name;

	
	@Column(name = "USERNAME")
	private String username;	

}
