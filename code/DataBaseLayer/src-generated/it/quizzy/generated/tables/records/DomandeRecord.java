/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables.records;


import it.quizzy.generated.tables.Domande;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DomandeRecord extends UpdatableRecordImpl<DomandeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>domande.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>domande.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>domande.id_quiz</code>.
     */
    public void setIdQuiz(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>domande.id_quiz</code>.
     */
    public Integer getIdQuiz() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>domande.numero_domanda</code>.
     */
    public void setNumeroDomanda(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>domande.numero_domanda</code>.
     */
    public Integer getNumeroDomanda() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>domande.tipo</code>.
     */
    public void setTipo(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>domande.tipo</code>.
     */
    public Integer getTipo() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>domande.obj</code>.
     */
    public void setObj(byte[] value) {
        set(4, value);
    }

    /**
     * Getter for <code>domande.obj</code>.
     */
    public byte[] getObj() {
        return (byte[]) get(4);
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
     * Create a detached DomandeRecord
     */
    public DomandeRecord() {
        super(Domande.DOMANDE);
    }

    /**
     * Create a detached, initialised DomandeRecord
     */
    public DomandeRecord(Integer id, Integer idQuiz, Integer numeroDomanda, Integer tipo, byte[] obj) {
        super(Domande.DOMANDE);

        setId(id);
        setIdQuiz(idQuiz);
        setNumeroDomanda(numeroDomanda);
        setTipo(tipo);
        setObj(obj);
        resetChangedOnNotNull();
    }
}
