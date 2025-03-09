
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

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
public class Review extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String				alias;

	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	@Mandatory
	private Date				postedMoment;

	@ValidString(max = 50)
	@Mandatory
	@Automapped
	private String				subject;

	@ValidString(max = 255)
	@Mandatory
	@Automapped
	private String				text;

	@ValidNumber(min = 0, max = 10)
	@Optional
	@Automapped
	private Double				score;

	@Valid
	@Optional
	@Automapped
	private Boolean				recommended;
}
