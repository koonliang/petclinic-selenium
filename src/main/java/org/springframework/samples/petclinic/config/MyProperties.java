package org.springframework.samples.petclinic.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
@Data
@ConfigurationProperties("my.properties")
@Component
public class MyProperties {
	private String browser;
	private Duration explicitTimeout;
	private String gridUrl;
	private String gridToken;
	private String username;
	private String password;
	private String grid;
	private String demoUrl;	
}
