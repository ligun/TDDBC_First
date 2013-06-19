package jp.tddbc.test1;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ZipCodeValidatorTest {
	private ZipCodeValidator sut;

	@Before
	public void setUp() throws Exception{
		sut = new ZipCodeValidator();
	}

	@Test
	public void 数字が3桁ならOK(){
		assertThat(sut.validate("123"), is(true));
	}

	@Test
	public void 英数字混じりならNG(){
		assertThat(sut.validate("1a2"), is(false));
	}

	@Test
	public void 空文字ならNG(){
		assertThat(sut.validate(""), is(false));
	}

	@Test
	public void 数字3桁ハイフン数字4桁ならOK(){
		assertThat(sut.validate("123-4567"), is(true));
	}

	@Test
	public void 数字4桁ハイフン数字3桁ならNG(){
		assertThat(sut.validate("1234-567"), is(false));
	}

	@Test
	public void 数字が7桁ならOK(){
		assertThat(sut.validate("1234567"), is(true));
	}

	@Test
	public void 数字が4から6桁ならOK(){
		assertThat(sut.validate("1234"), is(false));
		assertThat(sut.validate("12345"), is(false));
		assertThat(sut.validate("123456"), is(false));
	}

	@Test
	public void 数字が9桁以上ならNG(){
		assertThat(sut.validate("123456789"), is(false));
	}

	@Test
	public void 数字が０のみならNG(){
		assertThat(sut.validate("000"), is(false));
		assertThat(sut.validate("0000000"), is(false));
		assertThat(sut.validate("000-1234"), is(false));
		assertThat(sut.validate("123-0000"), is(true));
	}


}
