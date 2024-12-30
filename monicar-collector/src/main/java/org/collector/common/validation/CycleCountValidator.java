package org.collector.common.validation;

import org.collector.common.annotation.CycleCount;
import org.collector.presentation.dto.CycleInfoRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CycleCountValidator implements ConstraintValidator<CycleCount, CycleInfoRequest> {
	@Override
	public boolean isValid(CycleInfoRequest request, ConstraintValidatorContext context) {
		if (request == null || request.cCnt() == null || request.cList() == null) {
			return false;
		}
		return request.cCnt().equals(request.cList().size());
	}
}
