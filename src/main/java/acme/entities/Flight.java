
package acme.entities;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.helpers.SpringHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Flight extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Size(max = 50)
	@Automapped
	private String				tag;

	@Mandatory
	@Automapped
	@Valid
	private Boolean				requiresSelfTransfer;

	@Mandatory
	@Min(0)
	@Automapped
	private Integer				cost;

	@Optional
	@Size(max = 255)
	@Automapped
	private String				description;

	@OneToMany(mappedBy = "flight")
	@Valid
	@Automapped
	private List<Legs>			legs;


	@Transient
	public Date getFlightDeparture() {
		FlightRepository repository = SpringHelper.getBean(FlightRepository.class);

		List<Legs> listOfLegs = repository.legsByFlightId(this.getId());
		Legs firstLegs = listOfLegs.stream().findFirst().orElse(null);
		return firstLegs != null ? firstLegs.getScheduledDeparture() : null;
	}

	@Transient
	public Date getFlightArrival() {
		FlightRepository repository = SpringHelper.getBean(FlightRepository.class);
		List<Legs> listOfLegss = repository.legsByFlightId(this.getId());
		Date scheduledArrival = null;
		if (!listOfLegss.isEmpty())
			scheduledArrival = listOfLegss.get(listOfLegss.size() - 1).getScheduledArrival();
		return scheduledArrival;
	}

	@Transient
	public Integer getLayovers() {
		FlightRepository repository = SpringHelper.getBean(FlightRepository.class);
		List<Legs> listOfLegss = repository.legsByFlightId(this.getId());
		return listOfLegss.size() - 1;
	}

	@Transient
	public Airport getDeparture() {
		FlightRepository repository = SpringHelper.getBean(FlightRepository.class);
		List<Legs> listOfLegs = repository.legsByFlightId(this.getId());
		Legs firstLegs = listOfLegs.stream().findFirst().orElse(null);
		return firstLegs != null ? firstLegs.getDepartureAirport() : null;
	}

	@Transient
	public Airport getArrival() {
		FlightRepository repository = SpringHelper.getBean(FlightRepository.class);
		List<Legs> listOfLegs = repository.legsByFlightId(this.getId());
		Airport destination = null;
		if (!listOfLegs.isEmpty())
			destination = listOfLegs.get(listOfLegs.size() - 1).getArrivalAirport();
		return destination;
	}

}
