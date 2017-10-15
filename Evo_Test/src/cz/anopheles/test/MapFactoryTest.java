package cz.anopheles.test;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cz.anopheles.util.MapFactory;

public class MapFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int midX = 5;
		int midY = 5;
		int radius = 5;
		int pointX1 = 10;
		int pointY1 = 5;
		int pointX2 = 7;
		int pointY2 = 7;
		int pointX3 = 9;
		int pointY3 = 8;
		int pointX4 = -4;
		int pointY4 = 1;
		
		Assert.assertTrue("Test 1 of isInCircle", MapFactory.isInCircle(midX, midY, radius, pointX1, pointY1));
		Assert.assertTrue("Test 2 of isInCircle", MapFactory.isInCircle(midX, midY, radius, pointX2, pointY2));
		Assert.assertTrue("Test 3 of isInCircle", MapFactory.isInCircle(midX, midY, radius, pointX3, pointY3));
		Assert.assertTrue("Test 4 of isInCircle", !MapFactory.isInCircle(midX, midY, radius, pointX4, pointY4));
	}

}
