
package acme.entities.legs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.constraints.ValidFlightNumber;
import acme.constraints.ValidLegs;
import acme.entities.aircraft.Aircraft;
import acme.entities.airport.Airport;
import acme.entities.flight.Flight;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidLegs
public class Legs extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidFlightNumber
	@Column(unique = true)
	private String				flightNumber;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledArrival;

	@Mandatory
	@Valid
	@Automapped
	private Airport				departureAirport;

	@Mandatory
	@Valid
	@Automapped
	private Airport				arrivalAirport;

	@Mandatory
	@Valid
	@Automapped
	private Double				duration;

	@Mandatory
	@Valid
	@Automapped
	private LegType				status;

	@Mandatory
	@Valid
	@ManyToOne
	private Aircraft			aircraft;
	
	@Mandatory
	@Valid
	@ManyToOne
	private Flight flight;

}
