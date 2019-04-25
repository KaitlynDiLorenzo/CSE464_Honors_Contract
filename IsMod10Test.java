import static org.junit.Assert.*;

import org.junit.Test;

public class IsMod10Test {
	@Test
	public void test1() {
		assertEquals(false, IsMod10.IsValidMod10Number(""));
	}
	@Test
	public void test2() {
		assertEquals(true, IsMod10.IsValidMod10Number("0"));
	}
	@Test
	public void test3() {
		assertEquals(false, IsMod10.IsValidMod10Number("21"));
	}
	@Test
	public void test4() {
		assertEquals(false, IsMod10.IsValidMod10Number("53"));
	}
}