
package acme.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Technichian extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ValidString(pattern = "^[A-Z]{2-3}[0-9]{6}$")
	@Mandatory
	@Column(unique = true)
	private String licenseNumber;
	
	@ValidString(pattern = "^[+]?[0-9]{6,15}$")
	@Mandatory
	@Automapped
	private String phoneNumber;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String specialisation;

	@Mandatory
	@Column(name = "passedHealthTest")
	private Boolean hasPassedAnnualHealthTest;

	@ValidNumber(min=0)
	@Mandatory
	@Automapped
	private Integer yearsOfExperience;
	
//	TO-DO: certifications should be an independent entity with a many to one relation with Technician
//	@ValidString(max = 255)
//	@Optional
//	@Automapped
//	private String certifications;

}
