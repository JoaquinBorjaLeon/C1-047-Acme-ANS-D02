
package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ValidString(pattern = "^[A-Z0-9]{6,8}$")
	@Mandatory
	@Column(unique = true)
	private String				locatorCode;

	@ValidMoment(past = true)
	@Mandatory
	@Automapped
	private Date				purchaseMoment;

	@Enumerated(EnumType.STRING)
	@Mandatory
	@Automapped
	private TravelClass			travelClass;

	@ValidNumber(min = 0)
	@Mandatory
	@Automapped
	private Double				price;

	@ValidString(pattern = "^\\d{4}$")
	@Optional
	@Automapped
	private String				lastNibble;

	@ManyToOne
	@Mandatory
	@Automapped
	private Customer			customer;


	public enum TravelClass {
		ECONOMY, BUSINESS
	}
}
