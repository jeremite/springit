package com.travis.springit;

import com.travis.springit.config.SpringitProperties;
import com.travis.springit.domain.Comment;
import com.travis.springit.domain.Link;
import com.travis.springit.repository.CommentRepository;
import com.travis.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

	@Autowired
	private SpringitProperties springitProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);

	}

	@Bean
	//@Profile("devs")
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
		return args -> {
			Link link = new Link("Getting started with Sprint boot2","https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);

			Comment comment = new Comment("This Spring boot 2 link is awesome",link);
			commentRepository.save(comment);

			link.addComment(comment);

			System.out.println("We just inserted a link and a comment");
			System.out.println("======================================");


			//Link firstLink = linkRepository.findByTitle("Getting started with Sprint boot2");
			//System.out.println(firstLink.getTitle());
		};
	}
}
