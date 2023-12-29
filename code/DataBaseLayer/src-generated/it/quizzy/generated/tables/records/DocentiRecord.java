/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables.records;


import it.quizzy.generated.tables.Docenti;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DocentiRecord extends UpdatableRecordImpl<DocentiRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>docenti.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>docenti.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>docenti.nome_completo</code>.
     */
    public void setNomeCompleto(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>docenti.nome_completo</code>.
     */
    public String getNomeCompleto() {
        return (String) get(1);
    }

    /**
     * Setter for <code>docenti.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>docenti.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>docenti.password_hash</code>.
     */
    public void setPasswordHash(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>docenti.password_hash</code>.
     */
    public String getPasswordHash() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DocentiRecord
     */
    public DocentiRecord() {
        super(Docenti.DOCENTI);
    }

    /**
     * Create a detached, initialised DocentiRecord
     */
    public DocentiRecord(Integer id, String nomeCompleto, String email, String passwordHash) {
        super(Docenti.DOCENTI);

        setId(id);
        setNomeCompleto(nomeCompleto);
        setEmail(email);
        setPasswordHash(passwordHash);
        resetChangedOnNotNull();
    }
}
