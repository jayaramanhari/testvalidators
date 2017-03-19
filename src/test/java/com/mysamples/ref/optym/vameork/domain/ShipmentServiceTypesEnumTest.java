package com.mysamples.ref.optym.vameork.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShipmentServiceTypesEnumTest {

	@Test
	public void test() {
		assert ( (ShipmentServiceTypesEnum.Standard) != null);
		assertEquals( ShipmentServiceTypesEnum.Standard, ShipmentServiceTypesEnum.Standard);
	}

}
