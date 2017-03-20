package com.mysamples.ref.optym.vameork.validators.format;

public enum UserInputsValidatorImpl implements IUserInputsValidator {

    ORIGIN (ValidInputsTypeEnum.ORIGIN) {
        public <T extends UserInputs> boolean validate(T input) {
            if(input.getOrigin().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    DESTINATION (ValidInputsTypeEnum.DESTINATION) {
        public <T extends UserInputs> boolean validate(T input) {
            if(input.getDestination().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    PICKUP_DATE (ValidInputsTypeEnum.PICKUP_DATE) {
        public <T extends UserInputs> boolean validate(T input) {
            if( input.getPickupDate().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    WEIGHT   (ValidInputsTypeEnum.WEIGHT) {
        public <T extends UserInputs> boolean validate(T input) {
            if(input.getWeight().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    CUBE (ValidInputsTypeEnum.CUBE) {
        public <T extends UserInputs> boolean validate(T input) {
            if(input.getCube() > 0 ) {
                return true;
            }
            return false;
        }
    },

    SERVICE_TYPE (ValidInputsTypeEnum.SERVICE_TYPE) {
        public <T extends UserInputs> boolean validate(T input) {
            if(input.getServiceType().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    INVALID (ValidInputsTypeEnum.INVALID) {
        public <T extends UserInputs> boolean validate(T input) {
            return false;
        }
    };

    private ValidInputsTypeEnum validationType;

    private UserInputsValidatorImpl(ValidInputsTypeEnum validationType) {
        this.validationType = validationType;
    }

    public ValidInputsTypeEnum getValidationType() {
        return validationType;
    }
}
