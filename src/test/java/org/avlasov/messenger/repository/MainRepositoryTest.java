package org.avlasov.messenger.repository;

import org.avlasov.messenger.MessengerMatcherTestCase;
import org.avlasov.messenger.config.TestDataSource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by artemvlasov on 15/07/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = TestDataSource.class)
@SqlGroup({
        @Sql("/scripts/drop-data.sql"),
        @Sql("/scripts/data.sql")
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class MainRepositoryTest<T> extends MessengerMatcherTestCase<T> {
}
