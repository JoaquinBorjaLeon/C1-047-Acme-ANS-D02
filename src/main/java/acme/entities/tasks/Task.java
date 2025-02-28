
package acme.entities.tasks;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Task extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Enumerated(EnumType.STRING)
	@Mandatory
	@Automapped
	private Type type;

	@ValidString(max = 255)
	@Mandatory
	@Automapped
	private String description;
	
	@ValidNumber(min = 0, max =10)
	@Mandatory
	@Automapped
	private Integer	priority;

	@ValidNumber(min = 0)
	@Mandatory
	@Automapped
	private Integer	duration;

//	TO-DO: uncomment this when/if Technician class is accepted
//	@ManyToOne
//	@Mandatory
//	@Automapped
//	private Technician technician;
	
	public enum Type {
		MAINTENANCE, INSPECTION, REPAIR, SYSTEM_CHECK
	}
}
