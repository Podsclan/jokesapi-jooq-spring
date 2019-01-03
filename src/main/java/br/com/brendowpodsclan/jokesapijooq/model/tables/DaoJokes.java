package br.com.brendowpodsclan.jokesapijooq.model.tables;

import br.com.brendowpodsclan.jokesapijooq.model.DataBase;
import br.com.brendowpodsclan.jokesapijooq.model.Entity.Author;
import br.com.brendowpodsclan.jokesapijooq.model.Entity.Joke;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoJokes {

    public Joke read(int id) {
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(Tables.JOKE).join(Tables.AUTHOR).on(Tables.JOKE.JOKE_AUTHORID.eq(Tables.AUTHOR.AUTHOR_ID)).where(Tables.JOKE.JOKE_ID.eq(id)).fetch();
//      String sql = "SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID WHERE JOKE.JOKE_ID = ?";
        Joke joke = new Joke();
        for (Record r : result) {
            joke = getJokeFromResultSet(r);
        }
        return joke;
    }

    public List<Joke> readAllJokes(){

        //SELECT * FROM JOKE INNER JOIN AUTHOR ON JOKE.JOKE_AUTHORID = AUTHOR.AUTHOR_ID
        Connection conn = DataBase.getConnection();
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        Result<Record> result = create.select().from(Tables.JOKE).join(Tables.AUTHOR).on(Tables.JOKE.JOKE_AUTHORID.eq(Tables.AUTHOR.AUTHOR_ID)).fetch();
        List<Joke> list = new ArrayList<>();
        for (Record r : result) {
            list.add(getJokeFromResultSet(r));
        }
        return list;
    }


    public Joke getJokeFromResultSet(Record rs) {

        Joke aux = new Joke();
        Author author = new Author();
            aux.setId(rs.getValue(Tables.JOKE.JOKE_ID));
            aux.setType(rs.getValue(Tables.JOKE.JOKE_TYPE));
            aux.setJoke(rs.getValue(Tables.JOKE.JOKE_JOKE));
            author.setName(rs.getValue(Tables.AUTHOR.AUTHOR_NAME));
            author.setId(rs.getValue(Tables.AUTHOR.AUTHOR_ID));
            aux.setAuthor(author);
            return aux;
    }
}
