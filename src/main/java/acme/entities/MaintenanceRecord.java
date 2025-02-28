
package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MaintenanceRecord extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ValidMoment
	@Mandatory
	@Automapped
	private Date maintenaceMoment;

	@Enumerated(EnumType.STRING)
	@Mandatory
	@Automapped
	private Status status;
	
	@ValidMoment(past = false)
	@Mandatory
	@Automapped
	private Date nextInspectionDate;

	@ValidMoney(min = 0)
	@Mandatory
	@Automapped
	private Money estimatedCost;

	@ValidString(max = 255)
	@Optional
	@Automapped
	private String notes;

//	TO-DO: link with aircraft when aircraft is accepted
//	@ManyToOne
//	@Mandatory
//	@Automapped
//	private Aircraft aircraft;


	public enum Status {
		PENDING, IN_PROGRESS, COMPLETED
	}
}
