package org.collector.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.collector.common.validation.CycleCountValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CycleCountValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CycleCount {
	String message() default "cCnt(주기정보 개수)와 cList(주기정보리스트)의 개수가 일치해야합니다.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
