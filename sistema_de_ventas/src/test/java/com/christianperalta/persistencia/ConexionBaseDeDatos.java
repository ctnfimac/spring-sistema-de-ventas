package com.christianperalta.persistencia;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import sistema_de_ventas.SpringTest;

public class ConexionBaseDeDatos extends SpringTest{

	@Test
	@Transactional
	@Rollback(true)
	public void prueboConexionALaBaseDeDatos(){
		assertThat(getSession().isConnected()).isTrue();
	}
}
