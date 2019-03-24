package sistema_de_ventas;

import org.junit.Test;

import com.christian.controllers.App;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

	@Test
	public void test() {
		App app = new App();
		String valorEsperado = "sample";
		String valorRegresado = app.sample();
		assertThat(valorRegresado).isEqualTo(valorEsperado);
		//fail("Not yet implemented");
	}

}
