package ru.digitalleague.core.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@Slf4j
@EnableRetry
public class ApplicationConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public RabbitAdmin ampqAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    /**
     * Очередь для приема заказов.
     */
    @Bean
    public Queue myQueue1() {
        return new Queue("order");
    }

    /**
     * Очередь для приема результатов поездки.
     */
    @Bean
    public Queue myQueue2() {
        return new Queue("trip-result");
    }

    @Bean
    public Queue myQueue3() {
        return new Queue("moscow_queue");
    }

    @Bean
    public Queue myQueue4() {
        return new Queue("spb_queue");
    }

    @Bean
    public Queue myQueue5() {
        return new Queue("sar_queue");
    }

    @Bean
    public Queue myQueue6() {
        return new Queue("rost_queue");
    }

    @Bean
    public Queue myQueue7() {
        return new Queue("tag_queue");
    }

    @Bean
    public Queue myQueue8() {
        return new Queue("cher_queue");
    }

    @Bean
    public Queue myQueue9() {
        return new Queue("bar_queue");
    }

    @Bean
    public Queue myQueue10() {
        return new Queue("nef_queue");
    }

    @Bean
    public Queue myQueue11() {
        return new Queue("kem_queue");
    }

    @Bean
    public Queue myQueue12() {
        return new Queue("mag_queue");
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/taxidb?currentSchema=taxi-service");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("postgres");
        return dataSourceBuilder.build();
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setShouldRun(false);
        return liquibase;
    }
}
