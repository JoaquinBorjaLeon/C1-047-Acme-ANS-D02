
package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Mandatory
	@ValidMoment(past = true)
	private Date				purchaseMoment;

	@Enumerated(EnumType.STRING)
	@Mandatory
	@Automapped
	private TravelClass			travelClass;

	@ValidMoney
	@Mandatory
	@Automapped
	private Money				price;

	@ValidString(pattern = "^\\d{4}$")
	@Optional
	@Automapped
	private String				lastCardNibble;

	@ManyToOne
	@Mandatory
	@Automapped
	private Customer			customer;

	@ManyToOne
	@Mandatory
	@Automapped
	private Flight				flight;


	public enum TravelClass {
		ECONOMY, BUSINESS
	}
}
