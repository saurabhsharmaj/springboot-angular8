package com.sample.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IMApplication extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IMApplication.class);
    }

	public static void main(String[] args) {
		
		SpringApplication.run(IMApplication.class, args);
		
//		  Config config = new Config(); 
//		 config.setConfigId(new ConfigKey("a", "b"));
//		  System.out.println(new Gson().toJson(config));
		 
	}

	/*
	 * @Bean CommandLineRunner init(ContactRepository repository) { return args -> {
	 * repository.deleteAll(); LongStream.range(1, 11) .mapToObj(i -> new Contact(i,
	 * "Contact " + i, "contact" + i + "@email.com", "(111) 111-1111")) .map(v ->
	 * repository.save(v)) .forEach(System.out::println); };
	 * 
	 * }
	 */
}
