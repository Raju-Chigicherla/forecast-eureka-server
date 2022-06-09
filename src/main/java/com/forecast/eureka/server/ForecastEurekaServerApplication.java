package com.forecast.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * The Class ForecastEurekaServerApplication.
 */
@SpringBootApplication
@EnableEurekaServer
public class ForecastEurekaServerApplication {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(ForecastEurekaServerApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(ForecastEurekaServerApplication.class, args);
	}

	/**
	 * Default sampler.
	 *
	 * @return the sampler
	 */
	@Bean
	public Sampler defaultSampler() {
		LOG.info("Inside ForecastEurekaServerApplication: Default Sampler method!!!");
		return Sampler.ALWAYS_SAMPLE;
	}

}
