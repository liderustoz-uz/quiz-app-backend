package uz.bakhromjon.ustoztalim.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.bakhromjon.ustoztalim.annotations.CollectionSize;
import uz.bakhromjon.ustoztalim.consts.Constants;

import java.util.Collection;

public class CollectionSizeValidator implements ConstraintValidator<CollectionSize, Collection<Object>> {

    @Override
    public boolean isValid(Collection<Object> ts, ConstraintValidatorContext constraintValidatorContext) {
        return ts.size() == Constants.VARIANT_SIZE;
    }
}
