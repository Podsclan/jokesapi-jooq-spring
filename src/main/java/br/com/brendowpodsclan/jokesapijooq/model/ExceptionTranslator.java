package br.com.brendowpodsclan.jokesapijooq.model;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

/**
 * This class transforms SQLException into a Spring specific
 * DataAccessException. The idea behind this is borrowed from Adam Zell's Gist
 *
 * @author Petri Kainulainen
 * @author Adam Zell
 * @author Lukas Eder
 * @see <a
 * href="http://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-configuration/">http://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-configuration/</a>
 * @see <a
 * href="https://gist.github.com/azell/5655888">https://gist.github.com/azell/5655888</a>
 */
public class ExceptionTranslator extends DefaultExecuteListener {
    public void exception(ExecuteContext context) {
        SQLDialect dialect = context.configuration().dialect();
        SQLExceptionTranslator translator
                = new SQLErrorCodeSQLExceptionTranslator(dialect.name());
        context.exception(translator
                .translate("Access database using jOOQ", context.sql(), context.sqlException()));
    }
}
