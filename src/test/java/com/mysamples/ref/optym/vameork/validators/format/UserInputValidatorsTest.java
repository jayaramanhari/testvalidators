package com.mysamples.ref.optym.vameork.validators.format;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import com.mysamples.ref.optym.vameork.validators.format.IUserInputsValidator;
import com.mysamples.ref.optym.vameork.validators.format.UserInputs;
import com.mysamples.ref.optym.vameork.validators.format.UserInputsValidationContext;
import com.mysamples.ref.optym.vameork.validators.format.UserInputsValidatorImpl;
import com.mysamples.ref.optym.vameork.validators.format.ValidInputsTypeEnum;

public class UserInputValidatorsTest {

	@Test
	public void testForValidOrigin() {
		Set<IUserInputsValidator> strategies = new LinkedHashSet<IUserInputsValidator>();
		strategies.add(UserInputsValidatorImpl.ORIGIN);
		strategies.add(UserInputsValidatorImpl.DESTINATION);
		strategies.add(UserInputsValidatorImpl.PICKUP_DATE);
		strategies.add(UserInputsValidatorImpl.WEIGHT);
		strategies.add(UserInputsValidatorImpl.CUBE);
		strategies.add(UserInputsValidatorImpl.SERVICE_TYPE);
		
		UserInputs userInputs = new UserInputs();
		userInputs.setOrigin("");
		UserInputsValidationContext ctxUser = new UserInputsValidationContext(strategies);
		assertEquals(ValidInputsTypeEnum.ORIGIN, ctxUser.execute(userInputs));
		
	}

}
