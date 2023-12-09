package giss.mad.itinerario.config;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ItinerarioDatasourceConfigDiffblueTest {
    @Autowired
    private ItinerarioDatasourceConfig itinerarioDatasourceConfig;

    /**
     * Method under test:
     * {@link ItinerarioDatasourceConfig#dataSource(DataSourceProperties)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDataSource() {
        // TODO: Complete this test.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        itinerarioDatasourceConfig.dataSource(new DataSourceProperties());
    }
}
