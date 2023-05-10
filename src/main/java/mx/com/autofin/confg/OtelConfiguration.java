package mx.com.autofin.confg;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.context.annotation.Bean;

public class OtelConfiguration {

    @Bean
    SpanExporter otlpHttpSpanExporter() {
        return OtlpHttpSpanExporter
                .builder()
                .addHeader("Content-Type", "application/x-protobuf")
                .setEndpoint("http://10.14.102.132/enpoint/v1/trace")
                .build();
    }

}
