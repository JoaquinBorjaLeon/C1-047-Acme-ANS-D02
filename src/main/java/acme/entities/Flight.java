
package acme.entities;

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
	private Boolean				requiresSelfTransfer;

	@Mandatory
	@Min(0)
	@Automapped
	private Integer				cost;

	@Optional
	@Size(max = 255)
	private String				description;

	@OneToMany(mappedBy = "flight")
	@Valid
	@Automapped
	private List<Legs>			legs;


	public Date getScheduledDeparture() {
		if (!this.legs.isEmpty())
			return this.legs.get(0).getScheduledDeparture();
		return null;
	}

	public Date getScheduledArrival() {
		if (!this.legs.isEmpty())
			return this.legs.get(this.legs.size() - 1).getScheduledArrival();
		return null;
	}

	public String getOriginCity() {
		if (this.legs != null && !this.legs.isEmpty())
			return this.legs.get(0).getDepartureAirport();
		return null;
	}

	public String getDestinationCity() {
		if (this.legs != null && !this.legs.isEmpty())
			return this.legs.get(this.legs.size() - 1).getArrivalAirport();
		return null;
	}

	public Integer getLayovers() {
		if (this.legs != null && this.legs.size() > 1)
			return this.legs.size() - 2;
		return 0;
	}

}
