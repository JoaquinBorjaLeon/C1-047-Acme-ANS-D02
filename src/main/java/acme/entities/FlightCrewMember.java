
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMember extends AbstractRole {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@Column(unique = true)
	private String				employeeCode;

	@Mandatory
	@ValidString(pattern = "^+?/d{6,15}$")
	@Column(unique = true)
	private String				phoneNumber;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				languageSkills;


	private enum Availability {
		AVAILABLE, ON_VACATION, ON_LEAVE
	}


	@Mandatory
	@Valid
	@Enumerated(EnumType.STRING)
	private Availability	availabilityStatus;

	//	@Mandatory
	//	@ValidString
	//	@ManyToOne(optional = false)
	//	private String			airline;

	@Mandatory
	@ValidMoney(min = 0, max = 1000000)
	@Automapped
	private Money			salary;

	@Optional
	@ValidNumber(min = 0, max = 150)
	@Automapped
	private Integer			yearsOfExperience;

}
