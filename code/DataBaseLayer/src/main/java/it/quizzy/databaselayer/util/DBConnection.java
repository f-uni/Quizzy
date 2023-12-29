package it.quizzy.databaselayer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 * Classe per la connessione al database mediante JOOQ
 */
public class DBConnection {
	
	/**
	 * Ritorna un DSLContext per la connessione al database
	 * @return DSLContext
	 */
	public static DSLContext getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DSL.using(conn, SQLDialect.SQLITE);
	}
}
