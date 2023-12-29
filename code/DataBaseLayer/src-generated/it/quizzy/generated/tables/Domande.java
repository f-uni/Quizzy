/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables;


import it.quizzy.generated.DefaultSchema;
import it.quizzy.generated.Keys;
import it.quizzy.generated.tables.Quizzies.QuizziesPath;
import it.quizzy.generated.tables.records.DomandeRecord;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
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
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Domande(Name alias, Table<DomandeRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
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

    public <O extends Record> Domande(Table<O> path, ForeignKey<O, DomandeRecord> childPath, InverseForeignKey<O, DomandeRecord> parentPath) {
        super(path, childPath, parentPath, DOMANDE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class DomandePath extends Domande implements Path<DomandeRecord> {
        public <O extends Record> DomandePath(Table<O> path, ForeignKey<O, DomandeRecord> childPath, InverseForeignKey<O, DomandeRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private DomandePath(Name alias, Table<DomandeRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public DomandePath as(String alias) {
            return new DomandePath(DSL.name(alias), this);
        }

        @Override
        public DomandePath as(Name alias) {
            return new DomandePath(alias, this);
        }

        @Override
        public DomandePath as(Table<?> alias) {
            return new DomandePath(alias.getQualifiedName(), this);
        }
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

    private transient QuizziesPath _quizzies;

    /**
     * Get the implicit join path to the <code>quizzies</code> table.
     */
    public QuizziesPath quizzies() {
        if (_quizzies == null)
            _quizzies = new QuizziesPath(this, Keys.DOMANDE__DOMANDE_QUIZ_FK, null);

        return _quizzies;
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

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande where(Condition condition) {
        return new Domande(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Domande where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Domande where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Domande where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Domande where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Domande whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
