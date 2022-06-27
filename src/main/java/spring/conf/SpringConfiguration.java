package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:oracleMyBatis/db.properties")
@EnableTransactionManagement
public class SpringConfiguration {
	 @Value("${jdbc.driver}") 
	 private String driver;

	 @Value("${jdbc.url}")
	 private  String url;
	
	 @Value("${jdbc.username}")
	 private String username;
	
	 @Value("${jdbc.password}") 
	 private String pwd;
	 
	 @Bean
	 public BasicDataSource dataSource() {
		 BasicDataSource basicDataSource = new BasicDataSource();
		 basicDataSource.setDriverClassName(driver);
		 basicDataSource.setUrl(url);
		 basicDataSource.setUsername(username);
		 basicDataSource.setPassword(pwd);

		 return basicDataSource;
	 }
	 
	 @Bean
	 public SqlSessionFactory  sqlSessionFactory() throws Exception{
		 SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		 sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("oracleMyBatis/mybatis-config.xml"));
		 //calsspath를 넣어줘야하는 string을 넣으면 error가 발생함 객체가 들어오기로 되었기 떄문에
		 //적당한 객체를 사용한다. 
		 sqlSessionFactoryBean.setDataSource(this.dataSource());
		 sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("member/dao/memberMapper.xml"));
		 
		 return sqlSessionFactoryBean.getObject();
		 	
		 //내가 원하는건 FactoryBean이 아니라 Factory 객체를 원한다. 그래서 getObject() method를 사용한다.
	 }
	 
	 @Bean 
	 public SqlSessionTemplate sqlSession() throws Exception {
		 SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(this.sqlSessionFactory());
		 //SqlSessionTemplate는 setter 주입이 아니라 생성자 주입을 하기 때문에 new와 param을 전달한다. 
		 return sqlSessionTemplate;
	 }
	 
	@Bean
	public DataSourceTransactionManager transactionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(this.dataSource());
		
		return dataSourceTransactionManager;
	}
	
	
}
