package com.dawes.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.UsuarioVO;
import com.dawes.util.MySqlDAOFactory;
import com.mysql.cj.jdbc.MysqlDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuarioDAO {

	// instanciamos la factoria y se realiza la conexión a la base de datos
	MySqlDAOFactory factoria= MySqlDAOFactory.getCon();
	
	// obtenemos a través de la factoria un objeto para acceder a la tabla de usuarios
	UsuarioDAO u=factoria.getUsuarioDAO();
	
	@Test
	public void test1Insertar() {
		// tengo que llamar al método que realiza la inserción en la tabla de usuarios
		assertEquals(1,u.insertar(new UsuarioVO("Diego",LocalDate.now(),1000)));
	}
	
	@Test
	public void test2BuscarPorNombre() {
		assertNotNull(u.findByNombre("Ruben"));
	}
}
