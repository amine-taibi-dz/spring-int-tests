package dz.acs.si.demo1;

import javax.jms.Message;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;

import dz.acs.si.demo1.model.TypeFacture;

@SpringBootApplication
@ImportResource({
	/*"classpath:integration/db2jms.xml"*/
	/*	,"classpath:integration/jms2db.xml",*/
 "classpath:integration/file2db.xml"})
@PropertySource(value = {"classpath:params.properties","classpath:paths.properties","classpath:db.properties"})
public class DemoFileDbApplication {

	@Bean("datasource1")
	public DataSource getDataSource1(
			@Value("${db1.driver}")String driver,
			@Value("${db1.url}")String url,
			@Value("${db1.username}")String username,
			@Value("${db1.password}")String password) { 
		DataSourceBuilder<?> dataSourceBuilder =  DataSourceBuilder.create(); 
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return (DataSource)dataSourceBuilder.build(); 
	}

	@Bean("datasource2")
	public DataSource getDataSource2(
			@Value("${db2.driver}")String driver,
			@Value("${db2.url}")String url,
			@Value("${db2.username}")String username,
			@Value("${db2.password}")String password) { 
		DataSourceBuilder<?> dataSourceBuilder =  DataSourceBuilder.create(); 
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return (DataSource)dataSourceBuilder.build(); 
	}
	@Bean("jdbcTemplate1")
	public JdbcTemplate jdbcTemplate1( @Qualifier("datasource1") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	@Bean("jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2( @Qualifier("datasource2") DataSource datasource) {
		return new JdbcTemplate(datasource);
	}


	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(DemoFileDbApplication.class, args);
//
//		//Arrays.asList( ctx.getBeanDefinitionNames()).forEach(System.out::println);
//		JmsTemplate jt = ctx.getBean("jmsTemplate",JmsTemplate.class);
//		//jt.convertAndSend("typeFacture", "FAC_REM:Facture remboursement");
//		System.out.println(jt);		
	}

//	@Bean 
//	public CommandLineRunner demo1(JmsTemplate jmsTemplate) {
//		return arg ->
//		{
//			Message msg = jmsTemplate.receive("typeFacture2");
//			TypeFacture tf = msg.getBody(TypeFacture.class);
//			System.out.println(tf);
//		};
	}

}
