
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightAssignment extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private FlightCrewMember	allocatedFlightCrewMember;


	private enum Duty {
		PILOT, CO_PILOT, LEAD_ATTENDANT, CABIN_ATTENDANT
	}


	@Mandatory
	@Valid
	@Automapped
	@Enumerated(EnumType.STRING)
	private Duty	duty;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date	momentLastUpdate;


	private enum Status {
		CONFIRMED, PENDING, CANCELLED
	}


	@Mandatory
	@Valid
	@Automapped
	@Enumerated(EnumType.STRING)
	private Status	currentStatus;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String	remarks;
}
