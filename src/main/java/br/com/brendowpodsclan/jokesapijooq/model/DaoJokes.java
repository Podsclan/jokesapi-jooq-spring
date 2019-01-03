package br.com.brendowpodsclan.jokesapijooq.model;

import br.com.brendowpodsclan.jokesapijooq.model.Entity.Author;
import br.com.brendowpodsclan.jokesapijooq.model.Entity.Joke;
import br.com.brendowpodsclan.jokesapijooq.model.tables.Tables;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static br.com.brendowpodsclan.jokesapijooq.model.tables.Tables.AUTHOR;
import static br.com.brendowpodsclan.jokesapijooq.model.tables.Tables.JOKE;

class DaoJokes {

    public Joke read(int id) {
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(Tables.JOKE).join(AUTHOR).on(Tables.JOKE.JOKE_AUTHORID.eq(AUTHOR.AUTHOR_ID)).where(Tables.JOKE.JOKE_ID.eq(id)).fetch();
//      String sql = "SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID WHERE JOKE.JOKE_ID = ?";
        Joke joke = new Joke();
        for (Record r : result) {
            joke = getJokeFromResult(r);
        }
        return joke;
    }

    public List<Joke> readAllJokes(){

        //SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(Tables.JOKE).join(AUTHOR).on(Tables.JOKE.JOKE_AUTHORID.eq(AUTHOR.AUTHOR_ID)).fetch();
        List<Joke> list = new ArrayList<>();
        for (Record r : result) {
            list.add(getJokeFromResult(r));
        }
        return list;
    }


    private Joke getJokeFromResult(Record rs) {

        Joke joke = new Joke();
        Author author = new Author();
            joke.setId(rs.getValue(Tables.JOKE.JOKE_ID));
            joke.setType(rs.getValue(Tables.JOKE.JOKE_TYPE));
            joke.setJoke(rs.getValue(Tables.JOKE.JOKE_JOKE));
            author.setName(rs.getValue(AUTHOR.AUTHOR_NAME));
            author.setId(rs.getValue(AUTHOR.AUTHOR_ID));
            joke.setAuthor(author);
            return joke;
    }

    public List<Author> readAllAuthors(){
    //SELECT * FROM AUTHOR
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(AUTHOR).fetch();
        List<Author> list = new ArrayList<>();
        for (Record r: result) {
            list.add(getAuthorFromResult(r));
        }
        return list;
    }

    private Author getAuthorFromResult(Record rs) {
        Author author = new Author();
        author.setId(rs.getValue(AUTHOR.AUTHOR_ID));
        author.setName(rs.getValue(AUTHOR.AUTHOR_NAME));
        return author;
    }

    public boolean updateJoke(Joke aux) {
        //UPDATE JOKE SET JOKE_TYPE = ?, JOKE_JOKE = ?, JOKE_AUTHORID = ?  WHERE JOKE_ID = ?
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        create.update(JOKE).set(JOKE.JOKE_TYPE, aux.getType()).set(JOKE.JOKE_JOKE, aux.getJoke()).set(JOKE.JOKE_AUTHORID, aux.getAuthor().getId()).where(JOKE.JOKE_ID.eq(JOKE.JOKE_ID)).execute();
        return true;
    }

    public boolean updateAuthor(Author aux) {
        //UPDATE AUTHOR SET AUTHOR_NAME = ? WHERE AUTHOR_ID = ?
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        create.update(AUTHOR).set(AUTHOR.AUTHOR_NAME, aux.getName()).where(AUTHOR.AUTHOR_ID.eq(aux.getId())).execute();
        return true;
    }
}
