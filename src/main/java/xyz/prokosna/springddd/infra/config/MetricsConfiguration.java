package xyz.prokosna.springddd.infra.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableMetrics
public class MetricsConfiguration extends MetricsConfigurerAdapter {
  @Override
  public void configureReporters(MetricRegistry metricRegistry) {
    registerReporter(ConsoleReporter.forRegistry(metricRegistry).build())
        .start(30, TimeUnit.SECONDS);
  }
}
