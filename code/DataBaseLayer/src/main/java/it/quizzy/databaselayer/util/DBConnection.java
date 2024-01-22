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

	public static String DB_URL = "jdbc:sqlite:../db";

	/**
	 * Ritorna un DSLContext per la connessione al database
	 * 
	 * @return DSLContext
	 */
	public static DSLContext getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBConnection.DB_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DSL.using(conn, SQLDialect.SQLITE);
	}
}
