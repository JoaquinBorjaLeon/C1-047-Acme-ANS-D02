
package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ValidString
	@Mandatory
	@Automapped
	private String				fullName;

	@ValidEmail
	@Mandatory
	@Column(unique = true)
	private String				email;

	@ValidString(pattern = "^[A-Z0-9]{6,9}$")
	@Mandatory
	@Column(unique = true)
	private String				passport;

	@ValidMoment(past = true)
	@Mandatory
	@Automapped
	private Date				birthDate;

	@ValidString(max = 50)
	@Optional
	@Automapped
	private String				specialNeeds;

	@ManyToOne
	@Mandatory
	@Automapped
	private Booking				booking;
}
