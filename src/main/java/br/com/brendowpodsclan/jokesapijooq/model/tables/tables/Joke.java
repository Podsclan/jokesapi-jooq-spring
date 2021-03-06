/*
 * This file is generated by jOOQ.
*/
package br.com.brendowpodsclan.jokesapijooq.model.tables.tables;


import br.com.brendowpodsclan.jokesapijooq.model.tables.Indexes;
import br.com.brendowpodsclan.jokesapijooq.model.tables.Keys;
import br.com.brendowpodsclan.jokesapijooq.model.tables.Libraryjokes;
import br.com.brendowpodsclan.jokesapijooq.model.tables.tables.records.JokeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Joke extends TableImpl<JokeRecord> {

    private static final long serialVersionUID = -729653215;

    /**
     * The reference instance of <code>libraryjokes.joke</code>
     */
    public static final Joke JOKE = new Joke();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JokeRecord> getRecordType() {
        return JokeRecord.class;
    }

    /**
     * The column <code>libraryjokes.joke.JOKE_ID</code>.
     */
    public final TableField<JokeRecord, Integer> JOKE_ID = createField("JOKE_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>libraryjokes.joke.JOKE_TYPE</code>.
     */
    public final TableField<JokeRecord, String> JOKE_TYPE = createField("JOKE_TYPE", org.jooq.impl.SQLDataType.VARCHAR(40), this, "");

    /**
     * The column <code>libraryjokes.joke.JOKE_JOKE</code>.
     */
    public final TableField<JokeRecord, String> JOKE_JOKE = createField("JOKE_JOKE", org.jooq.impl.SQLDataType.VARCHAR(1000), this, "");

    /**
     * The column <code>libraryjokes.joke.JOKE_AUTHORID</code>.
     */
    public final TableField<JokeRecord, Integer> JOKE_AUTHORID = createField("JOKE_AUTHORID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>libraryjokes.joke</code> table reference
     */
    public Joke() {
        this(DSL.name("joke"), null);
    }

    /**
     * Create an aliased <code>libraryjokes.joke</code> table reference
     */
    public Joke(String alias) {
        this(DSL.name(alias), JOKE);
    }

    /**
     * Create an aliased <code>libraryjokes.joke</code> table reference
     */
    public Joke(Name alias) {
        this(alias, JOKE);
    }

    private Joke(Name alias, Table<JokeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Joke(Name alias, Table<JokeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Libraryjokes.LIBRARYJOKES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.JOKE_JOKE_AUTHORID, Indexes.JOKE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JokeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_JOKE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JokeRecord> getPrimaryKey() {
        return Keys.KEY_JOKE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JokeRecord>> getKeys() {
        return Arrays.<UniqueKey<JokeRecord>>asList(Keys.KEY_JOKE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<JokeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JokeRecord, ?>>asList(Keys.JOKE_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Joke as(String alias) {
        return new Joke(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Joke as(Name alias) {
        return new Joke(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Joke rename(String name) {
        return new Joke(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Joke rename(Name name) {
        return new Joke(name, null);
    }
}
