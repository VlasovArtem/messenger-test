package org.avlasov.messenger.config.datasource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Configuration
@Profile("dev")
public class DevDataSource {

    @Bean
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("scripts/schema.sql")
                .addScripts("scripts/data.sql")
                .build();
    }

    @Bean
    public Server webServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
    }

    @Bean
    public Server server() throws SQLException {
        return Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort","9092").start();
    }

}
