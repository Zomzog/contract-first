package org.openapitools.configuration;

import org.openapitools.model.Color;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.colorConverter")
    Converter<String, Color> colorConverter() {
        return new Converter<String, Color>() {
            @Override
            public Color convert(String source) {
                return Color.fromValue(source);
            }
        };
    }

}
