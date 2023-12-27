/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables;


import it.quizzy.generated.DefaultSchema;
import it.quizzy.generated.Keys;
import it.quizzy.generated.tables.records.DomandeRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Domande extends TableImpl<DomandeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>domande</code>
     */
    public static final Domande DOMANDE = new Domande();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DomandeRecord> getRecordType() {
        return DomandeRecord.class;
    }

    /**
     * The column <code>domande.id</code>.
     */
    public final TableField<DomandeRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>domande.id_quiz</code>.
     */
    public final TableField<DomandeRecord, Integer> ID_QUIZ = createField(DSL.name("id_quiz"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>domande.numero_domanda</code>.
     */
    public final TableField<DomandeRecord, Integer> NUMERO_DOMANDA = createField(DSL.name("numero_domanda"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>domande.tipo</code>.
     */
    public final TableField<DomandeRecord, Integer> TIPO = createField(DSL.name("tipo"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>domande.obj</code>.
     */
    public final TableField<DomandeRecord, String> OBJ = createField(DSL.name("obj"), SQLDataType.CLOB.nullable(false), this, "");

    private Domande(Name alias, Table<DomandeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Domande(Name alias, Table<DomandeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>domande</code> table reference
     */
    public Domande(String alias) {
        this(DSL.name(alias), DOMANDE);
    }

    /**
     * Create an aliased <code>domande</code> table reference
     */
    public Domande(Name alias) {
        this(alias, DOMANDE);
    }

    /**
     * Create a <code>domande</code> table reference
     */
    public Domande() {
        this(DSL.name("domande"), null);
    }

    public <O extends Record> Domande(Table<O> child, ForeignKey<O, DomandeRecord> key) {
        super(child, key, DOMANDE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<DomandeRecord, Integer> getIdentity() {
        return (Identity<DomandeRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<DomandeRecord> getPrimaryKey() {
        return Keys.DOMANDE__PK_DOMANDE;
    }

    @Override
    public List<ForeignKey<DomandeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.DOMANDE__DOMANDE_QUIZ_FK);
    }

    private transient Quiz _quiz;

    /**
     * Get the implicit join path to the <code>quiz</code> table.
     */
    public Quiz quiz() {
        if (_quiz == null)
            _quiz = new Quiz(this, Keys.DOMANDE__DOMANDE_QUIZ_FK);

        return _quiz;
    }

    @Override
    public Domande as(String alias) {
        return new Domande(DSL.name(alias), this);
    }

    @Override
    public Domande as(Name alias) {
        return new Domande(alias, this);
    }

    @Override
    public Domande as(Table<?> alias) {
        return new Domande(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Domande rename(String name) {
        return new Domande(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Domande rename(Name name) {
        return new Domande(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Domande rename(Table<?> name) {
        return new Domande(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, Integer, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}