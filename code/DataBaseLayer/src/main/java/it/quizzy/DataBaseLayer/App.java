package it.quizzy.DataBaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import it.quizzy.generated.tables.Docenti;
import it.quizzy.generated.tables.records.DocentiRecord;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:db");
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

	        DocentiRecord d = new DocentiRecord(null, "dodiwod", "mail@adwad.cw", "00000");
	        
	    	int result = create.insertInto(Docenti.DOCENTI).set(d).execute();
	    	System.out.println(result);
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
