package com.mysamples.ref.optym.vameork.validators.format;

public interface IUserInputsValidator {
    <T extends UserInputs> boolean validate(T input);
    ValidInputsTypeEnum getValidationType();
}

