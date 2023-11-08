package med.voll.api.infra.opentelemetry;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpConfiguration {
    @Bean
    OtlpHttpSpanExporter otlpHttpSpanExporter(){
        return OtlpHttpSpanExporter.builder()
                .setEndpoint("http://172.19.0.5:4318/v1/traces")
                .build();
    }

}
