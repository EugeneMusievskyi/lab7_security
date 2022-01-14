package com.security.lab7.user.entity;

import com.security.lab7.config.AttributeEncryptor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Accessors(chain = true)
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
	private UUID id;

	@Column(unique = true, updatable = false, nullable = false)
	private String username;

	private String password;

	@Convert(converter = AttributeEncryptor.class)
	private String phone;

}
