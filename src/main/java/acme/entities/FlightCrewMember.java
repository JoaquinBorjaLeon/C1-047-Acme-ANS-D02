
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUuid;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMembers {

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@ValidUuid
	private String	employerCode;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	@Column(unique = true)
	private String	phoneNumber;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String	languageSkills;


	private enum Availability {
		AVAILABLE, ON_VACATION, ON_LEAVE
	}


	@Mandatory
	@Valid
	@Automapped
	private Availability	availabilityStatus;

	@Mandatory
	@ValidString
	@Automapped
	private String			airline;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money			salary;

	@Optional
	@ValidNumber
	@Automapped
	private Integer			yearsOfExperience;

}
