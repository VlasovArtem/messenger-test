package org.avlasov.messenger.config;

import org.avlasov.messenger.config.datasource.DevDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Configuration
@Import(value = {DevDataSource.class})
public class AppConfig {
}
