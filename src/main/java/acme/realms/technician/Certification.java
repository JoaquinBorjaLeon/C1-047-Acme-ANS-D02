
package acme.realms.technician;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Certification extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ValidString(max = 255)
	@Mandatory
	@Automapped
	private String certification;
	
	@ManyToOne
	@Mandatory
	@Automapped
	private Technichian technician;

}
