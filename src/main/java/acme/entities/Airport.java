
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Airport extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Size(max = 50)
	private String				name;

	@Mandatory
	@ValidString(pattern = "^[A-Z]{3}$")
	@Column(unique = true)
	private String				iataCode;

	@Mandatory
	@ValidString(pattern = "^(INTERNATIONAL|DOMESTIC|REGIONAL)$")
	private String				operationalScope;

	@Mandatory
	@Size(max = 50)
	private String				city;

	@Mandatory
	@Size(max = 50)
	private String				country;

	@Optional
	private String				website;

	@Optional
	@Pattern(regexp = "^.+@.+\\..+$")
	private String				email;

	@Optional
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	private String				contactPhone;
}
