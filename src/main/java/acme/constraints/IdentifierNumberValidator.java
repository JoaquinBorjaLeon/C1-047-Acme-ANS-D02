//
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.principals.DefaultUserIdentity;
import acme.client.components.validation.AbstractValidator;
import acme.client.helpers.StringHelper;
import acme.entities.AirlineManagers;

public class IdentifierNumberValidator extends AbstractValidator<ValidIdentifierNumber, AirlineManagers> {

	@Override
	public void initialise(final ValidIdentifierNumber annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final AirlineManagers airlineManagers, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (airlineManagers == null || airlineManagers.getIdentifierNumber() == null || airlineManagers.getIdentity() == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else if (StringHelper.isBlank(airlineManagers.getIdentifierNumber()))
			super.state(context, false, "identifier", "javax.validation.constraints.NotBlank.message");
		else {
			boolean containsInitials;
			DefaultUserIdentity identity = airlineManagers.getIdentity();
			char nameFirstLetter = identity.getName().charAt(0);
			char surnameFirstLetter = identity.getSurname().charAt(0);
			String initials = "" + nameFirstLetter + surnameFirstLetter;
			containsInitials = StringHelper.startsWith(airlineManagers.getIdentifierNumber(), initials, false);
			super.state(context, containsInitials, "identifier", "acme.validation.airlinemanagers.identifier.message");
		}

		result = !super.hasErrors(context);
		return result;
	}
}
