
package acme.entities.tasks;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AircraftTask extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

//	TO-DO: uncomment this when/if Aircraft class is accepted
//	@ManyToOne
//	@Mandatory
//	@Automapped
//	private Aircraft aircraft;
	
	@ManyToOne
	@Mandatory
	@Automapped
	private Task task;
	
}
