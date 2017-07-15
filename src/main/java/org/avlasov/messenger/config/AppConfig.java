package org.avlasov.messenger.config;

import org.avlasov.messenger.config.datasource.DevDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Configuration
@Import(value = {DevDataSource.class})
@EnableJpaRepositories(basePackages = "org.avlasov.messenger.repository")
public class AppConfig {}
