
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Aircraft extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String				model;

	@ValidString(max = 50)
	@Mandatory
	@Column(unique = true)
	private String				regNumber;

	@ValidNumber(min = 0)
	@Mandatory
	@Automapped
	private Integer				capacity;

	@ValidNumber(min = 2000, max = 50000)
	@Mandatory
	@Automapped
	private Double				cargoWeight;

	@Enumerated(EnumType.STRING)
	@Mandatory
	@Automapped
	private Status				status;

	@ValidString(max = 255)
	@Optional
	@Automapped
	private String				notes;


	public enum Status {
		IN_SERVICE, UNDER_MAINTENANCE
	}


	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline airline;
}
