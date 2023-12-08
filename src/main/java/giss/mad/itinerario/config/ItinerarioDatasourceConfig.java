package giss.mad.itinerario.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "itinerarioEntityManagerFactory",
        transactionManagerRef = "itinerarioTransactionManager",
        basePackages = {"giss.mad.itinerario.repository.itinerario"}
)
public class ItinerarioDatasourceConfig {
    /**
     *
     * @return
     */
    @Primary
    @Bean(name = "itinerarioProperties")
    @ConfigurationProperties("spring.datasource.itinerario")
    public DataSourceProperties itinerarioDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     *
     * @param properties
     * @return
     */
    @Primary
    @Bean(name = "itinerarioDatasource")
    @ConfigurationProperties("spring.datasource.itinerario")
    public DataSource dataSource(final @Qualifier("itinerarioProperties") DataSourceProperties properties) {
        return itinerarioDataSourceProperties().initializeDataSourceBuilder().build();
    }

    /**
     *
     * @param builder
     * @param dataSource
     * @return
     */
    @Primary
    @Bean(name = "itinerarioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final EntityManagerFactoryBuilder builder,
                                                                       final @Qualifier("itinerarioDatasource")
                                                                       DataSource dataSource) {
        return builder.dataSource(dataSource).packages("giss.mad.itinerario.model.itinerario")
                .persistenceUnit("itinerario").build();
    }

    /**
     *
     * @param itinerarioEntityManagerFactory
     * @return
     */
    @Primary
    @Bean(name = "itinerarioTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(final @Qualifier("itinerarioEntityManagerFactory")
                                                             EntityManagerFactory itinerarioEntityManagerFactory) {
        return new JpaTransactionManager(itinerarioEntityManagerFactory);
    }
}
