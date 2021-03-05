package br.com.estanislau.bestbuy.config;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author GSW
 * @since 25 de set de 2019
 * @version v1
 */
@Configuration
public class SqlFunctionsMetadataBuilderContributor implements MetadataBuilderContributor {
	@Override
	public void contribute(final MetadataBuilder metadataBuilder) {
		metadataBuilder.applySqlFunction("date_trunc",
				new SQLFunctionTemplate(StandardBasicTypes.TIMESTAMP, "date_trunc('day', (?1 AT TIME ZONE ?2))"));
		metadataBuilder.applySqlFunction("date_part",
				new SQLFunctionTemplate(StandardBasicTypes.DOUBLE, "date_part(?1, (?2 - ?3))"));
		metadataBuilder.applySqlFunction("string_agg",
				new SQLFunctionTemplate(StandardBasicTypes.STRING, "string_agg(distinct ?1, ?2)"));

	}
}
