/*
 * This file is generated by jOOQ.
 */
package it.quizzy.generated;


import it.quizzy.generated.tables.Docenti;
import it.quizzy.generated.tables.Domande;
import it.quizzy.generated.tables.Partite;
import it.quizzy.generated.tables.Quizs;
import it.quizzy.generated.tables.Utenti;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>docenti</code>.
     */
    public final Docenti DOCENTI = Docenti.DOCENTI;

    /**
     * The table <code>domande</code>.
     */
    public final Domande DOMANDE = Domande.DOMANDE;

    /**
     * The table <code>partite</code>.
     */
    public final Partite PARTITE = Partite.PARTITE;

    /**
     * The table <code>quizs</code>.
     */
    public final Quizs QUIZS = Quizs.QUIZS;

    /**
     * The table <code>utenti</code>.
     */
    public final Utenti UTENTI = Utenti.UTENTI;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Docenti.DOCENTI,
            Domande.DOMANDE,
            Partite.PARTITE,
            Quizs.QUIZS,
            Utenti.UTENTI
        );
    }
}
