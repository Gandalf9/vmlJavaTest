package com.vml.test.exception;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VmlApplicationExceptionTest {

	@Test
	public void testSingleParameterConstructorVmlApplicationException() {
		VmlApplicationException exception = new VmlApplicationException("test message");
		assertThat(exception.getMessage(), containsString("test message"));
	}
	
	@Test
	public void testOtherParameterConstructorVmlApplicationException() {
		VmlApplicationException exception = new VmlApplicationException("test message");
		assertThat(exception.getMessage(), containsString("test message"));
	}
}
