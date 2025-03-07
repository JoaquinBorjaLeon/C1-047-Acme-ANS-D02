
package acme.realms;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	@ValidString(pattern = "^[A-Z]{2-3}'\'d{6}$")
	@Mandatory
	@Column(unique = true)
	private String				identifier;

	@ValidString(pattern = "^'\'+?'\'d{6,15}$")
	@Mandatory
	@Automapped
	private String				phoneNumber;

	@ValidString
	@Mandatory
	@Automapped
	private String				address;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String				city;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String				country;

	@ValidNumber(max = 500000)
	@Optional
	@Automapped
	private Integer				points;
}
