/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables.records;


import it.quizzy.generated.tables.Partite;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PartiteRecord extends UpdatableRecordImpl<PartiteRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>partite.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>partite.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>partite.timestamp</code>.
     */
    public void setTimestamp(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>partite.timestamp</code>.
     */
    public LocalDateTime getTimestamp() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>partite.id_docente</code>.
     */
    public void setIdDocente(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>partite.id_docente</code>.
     */
    public Integer getIdDocente() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>partite.id_quiz</code>.
     */
    public void setIdQuiz(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>partite.id_quiz</code>.
     */
    public Integer getIdQuiz() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>partite.port</code>.
     */
    public void setPort(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>partite.port</code>.
     */
    public Integer getPort() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>partite.pin</code>.
     */
    public void setPin(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>partite.pin</code>.
     */
    public String getPin() {
        return (String) get(5);
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
     * Create a detached PartiteRecord
     */
    public PartiteRecord() {
        super(Partite.PARTITE);
    }

    /**
     * Create a detached, initialised PartiteRecord
     */
    public PartiteRecord(Integer id, LocalDateTime timestamp, Integer idDocente, Integer idQuiz, Integer port, String pin) {
        super(Partite.PARTITE);

        setId(id);
        setTimestamp(timestamp);
        setIdDocente(idDocente);
        setIdQuiz(idQuiz);
        setPort(port);
        setPin(pin);
        resetChangedOnNotNull();
    }
}
