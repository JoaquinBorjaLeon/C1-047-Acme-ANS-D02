
package acme.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = FlightNumberValidator.class)
@Target({
	ElementType.FIELD, ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFlightNumber {

	String message() default "Invalid flight number format. It must be IATA code (2-3 uppercase letters) followed by 4 digits.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
