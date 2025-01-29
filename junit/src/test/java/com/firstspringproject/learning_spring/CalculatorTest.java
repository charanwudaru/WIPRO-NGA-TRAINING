package com.firstspringproject.learning_spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@Order(1)
	void testAddition() {
		System.out.println("Running testAddition...");
		assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
		assertEquals(0, calculator.add(-2, 2), "-2 + 2 should be 0");
		System.out.println("passed testAddition...");
	}

	@Test
	@Order(3)
	void testSubtraction() {
		System.out.println("Running testSubtraction...");
		assertEquals(3, calculator.subtract(5, 2), "5 - 2 should be 3");
		assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should be -1");
	}

	@Test
	@Order(2)
	void testMultiplication() {
		System.out.println("Running testMultiplication...");
		assertEquals(6, calculator.multiply(2, 3), "2 * 3 should be 6");
		
	}

	@Test
	@Order(4)
	void testDivision() {
		System.out.println("Running testDivision...");
		assertEquals(2, calculator.divide(6, 3), "6 / 3 should be 2");
		assertEquals(5, calculator.divide(10, 2), "10 / 2 should be 5");
	}

	// @Test
	// @Order(5)
	// void testDivisionByZero() {
	// 	System.out.println("Running testDivisionByZero...");
	// 	assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0),
	// 			"Division by zero should throw ArithmeticException");
	// }

	@ParameterizedTest
	@Order(6)
	@CsvSource({
			"2, 3, 5",
			"10, 5, 15",
			"-2, 4, 2",
			"7, 3, 10"
	})
	void testAdditionParameterized(int a, int b, int expected) {
		System.out.println("Running testAdditionParameterized with values: " + a + " and " + b);
		assertEquals(expected, calculator.add(a, b), a + " + " + b + " should be " + expected);
	}
}
