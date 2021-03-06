/*
* JBoss, Home of Professional Open Source
* Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.validator.test.internal.constraintvalidators.bv.past;

import java.time.YearMonth;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForYearMonth;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Tests for {@link org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForYearMonth}.
 *
 * @author Khalid Alqinyah
 */
public class PastValidatorForYearMonthTest {

	private PastValidatorForYearMonth constraint;

	@BeforeClass
	public void init() {
		constraint = new PastValidatorForYearMonth();
	}

	@Test
	public void testIsValid() {
		YearMonth future = YearMonth.now().plusYears( 1 );
		YearMonth past = YearMonth.now().minusYears( 1 );

		assertTrue( constraint.isValid( null, null ), "null fails validation." );
		assertTrue( constraint.isValid( past, null ), "Past YearMonth '" + past + "' fails validation.");
		assertFalse( constraint.isValid( future, null ), "Future YearMonth '" + future + "' validated as past.");
	}
}
