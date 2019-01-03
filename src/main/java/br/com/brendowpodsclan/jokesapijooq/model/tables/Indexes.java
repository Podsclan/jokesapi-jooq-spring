/*
 * This file is generated by jOOQ.
*/
package br.com.brendowpodsclan.jokesapijooq.model.tables;


import br.com.brendowpodsclan.jokesapijooq.model.tables.tables.Joke;
import br.com.brendowpodsclan.jokesapijooq.model.tables.tables.Author;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>libraryjokes</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTHOR_PRIMARY = Indexes0.AUTHOR_PRIMARY;
    public static final Index JOKE_JOKE_AUTHORID = Indexes0.JOKE_JOKE_AUTHORID;
    public static final Index JOKE_PRIMARY = Indexes0.JOKE_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index AUTHOR_PRIMARY = createIndex("PRIMARY", Author.AUTHOR, new OrderField[] { Author.AUTHOR.AUTHOR_ID }, true);
        public static Index JOKE_JOKE_AUTHORID = createIndex("JOKE_AUTHORID", Joke.JOKE, new OrderField[] { Joke.JOKE.JOKE_AUTHORID }, false);
        public static Index JOKE_PRIMARY = createIndex("PRIMARY", Joke.JOKE, new OrderField[] { Joke.JOKE.JOKE_ID }, true);
    }
}