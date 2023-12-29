/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated.tables;


import it.quizzy.generated.DefaultSchema;
import it.quizzy.generated.Keys;
import it.quizzy.generated.tables.Docenti.DocentiPath;
import it.quizzy.generated.tables.Quiz.QuizPath;
import it.quizzy.generated.tables.Utenti.UtentiPath;
import it.quizzy.generated.tables.records.PartiteRecord;

import java.time.LocalDateTime;
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
public class Partite extends TableImpl<PartiteRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>partite</code>
     */
    public static final Partite PARTITE = new Partite();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PartiteRecord> getRecordType() {
        return PartiteRecord.class;
    }

    /**
     * The column <code>partite.id</code>.
     */
    public final TableField<PartiteRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>partite.timestamp</code>.
     */
    public final TableField<PartiteRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>partite.id_docente</code>.
     */
    public final TableField<PartiteRecord, Integer> ID_DOCENTE = createField(DSL.name("id_docente"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>partite.id_quiz</code>.
     */
    public final TableField<PartiteRecord, Integer> ID_QUIZ = createField(DSL.name("id_quiz"), SQLDataType.INTEGER.nullable(false), this, "");

    private Partite(Name alias, Table<PartiteRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Partite(Name alias, Table<PartiteRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>partite</code> table reference
     */
    public Partite(String alias) {
        this(DSL.name(alias), PARTITE);
    }

    /**
     * Create an aliased <code>partite</code> table reference
     */
    public Partite(Name alias) {
        this(alias, PARTITE);
    }

    /**
     * Create a <code>partite</code> table reference
     */
    public Partite() {
        this(DSL.name("partite"), null);
    }

    public <O extends Record> Partite(Table<O> path, ForeignKey<O, PartiteRecord> childPath, InverseForeignKey<O, PartiteRecord> parentPath) {
        super(path, childPath, parentPath, PARTITE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PartitePath extends Partite implements Path<PartiteRecord> {
        public <O extends Record> PartitePath(Table<O> path, ForeignKey<O, PartiteRecord> childPath, InverseForeignKey<O, PartiteRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PartitePath(Name alias, Table<PartiteRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PartitePath as(String alias) {
            return new PartitePath(DSL.name(alias), this);
        }

        @Override
        public PartitePath as(Name alias) {
            return new PartitePath(alias, this);
        }

        @Override
        public PartitePath as(Table<?> alias) {
            return new PartitePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<PartiteRecord, Integer> getIdentity() {
        return (Identity<PartiteRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<PartiteRecord> getPrimaryKey() {
        return Keys.PARTITE__PK_PARTITE;
    }

    @Override
    public List<ForeignKey<PartiteRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PARTITE__PARTITE_DOCENTI_FK, Keys.PARTITE__PARTITE_QUIZ_FK);
    }

    private transient DocentiPath _docenti;

    /**
     * Get the implicit join path to the <code>docenti</code> table.
     */
    public DocentiPath docenti() {
        if (_docenti == null)
            _docenti = new DocentiPath(this, Keys.PARTITE__PARTITE_DOCENTI_FK, null);

        return _docenti;
    }

    private transient QuizPath _quiz;

    /**
     * Get the implicit join path to the <code>quiz</code> table.
     */
    public QuizPath quiz() {
        if (_quiz == null)
            _quiz = new QuizPath(this, Keys.PARTITE__PARTITE_QUIZ_FK, null);

        return _quiz;
    }

    private transient UtentiPath _utenti;

    /**
     * Get the implicit to-many join path to the <code>utenti</code> table
     */
    public UtentiPath utenti() {
        if (_utenti == null)
            _utenti = new UtentiPath(this, null, Keys.UTENTI__UTENTI_PARTITE_FK.getInverseKey());

        return _utenti;
    }

    @Override
    public Partite as(String alias) {
        return new Partite(DSL.name(alias), this);
    }

    @Override
    public Partite as(Name alias) {
        return new Partite(alias, this);
    }

    @Override
    public Partite as(Table<?> alias) {
        return new Partite(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Partite rename(String name) {
        return new Partite(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Partite rename(Name name) {
        return new Partite(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Partite rename(Table<?> name) {
        return new Partite(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite where(Condition condition) {
        return new Partite(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Partite where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Partite where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Partite where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Partite where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Partite whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
