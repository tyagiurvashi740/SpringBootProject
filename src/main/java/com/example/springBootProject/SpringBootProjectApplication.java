package com.example.springBootProject;


import com.example.springBootProject.filter.MyFilter;
//import com.example.springBootProject.interceptor.MyInterceptor;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//@Configuration
//@PropertySource("application.properties")
@SpringBootApplication
@EnableEncryptableProperties
public class SpringBootProjectApplication implements WebMvcConfigurer {
	
//	private static final String PASSWORD = "yourSecretPassword";
//	private static final String SALT = "yourRandomSalt";

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootProjectApplication.class, args);





	}
	@Bean
	public FilterRegistrationBean<MyFilter> registrationBean() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/hello");
		return registrationBean;
	}

	/* to add the custom interceptor
	in the registry to tell spring that this
	is the interceptor
	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new MyInterceptor())
//				.addPathPatterns("/hello"); // Specify the URL patterns for which the interceptor should be applied
//	}





//	@Bean
//	public TextEncryptor textEncryptor() {
//		return Encryptors.text(PASSWORD, SALT);
//	}
}
//	@Bean(name= "encryptorBean")
//	public StringEncryptor passwordEncryptor(){
//		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//		config.setPassword("the password"); // encryptor's private key config.setAlgorithm("PBEWithMD5AndDES")
//		config.setKeyObtentionIterations("1000");
//		config.setPoolSize("1");
//		config.setProviderName("'SunJCE");
////        config.setAlgorithm("PBEWithMD5AndDES");
//		config.setSaltGeneratorClassName("prg-jasypt.salt.RandomSaltGenerator");
////        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
//		config.setStringOutputType("base64");
//		encryptor.setConfig(config);
//		return encryptor;
//	}


