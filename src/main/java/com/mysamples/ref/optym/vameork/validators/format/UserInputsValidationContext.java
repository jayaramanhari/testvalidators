package com.mysamples.ref.optym.vameork.validators.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserInputsValidationContext {
	private Set<IUserInputsValidator> userValidationStrategies;

	public UserInputsValidationContext(Set<IUserInputsValidator> userValidationStrategies) {
		this.userValidationStrategies = userValidationStrategies;
	}

	public ValidInputsTypeEnum execute(UserInputs userInput) {
		IUserInputsValidator userValidation = UserInputsValidatorImpl.INVALID;
		for (Iterator<IUserInputsValidator> iterator = userValidationStrategies.iterator(); iterator.hasNext();) {
			userValidation = iterator.next();
			if (userValidation.validate(userInput)) {
				return userValidation.getValidationType();
			}
		}
		return null;
	}

	public List<ValidInputsTypeEnum> executeAndGetList(UserInputs userInput) {
		IUserInputsValidator userValidation = UserInputsValidatorImpl.INVALID;
		List<ValidInputsTypeEnum> validatedTypes = new ArrayList<ValidInputsTypeEnum>();
		for (Iterator<IUserInputsValidator> iterator = userValidationStrategies.iterator(); iterator.hasNext();) {
			userValidation = iterator.next();
			if (userValidation.validate(userInput)) {
				validatedTypes.add(userValidation.getValidationType());
			}
		}
		return validatedTypes;
	}
}
