package org.ts.spring.learn.fluxmongo;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ts.spring.learn.fluxmongo.model.FooDoc;
import org.ts.spring.learn.fluxmongo.repository.FooDocRepository;

@SpringBootApplication
public class FluxMongoApplication {

	CommandLineRunner documents(FooDocRepository fooDocRepository) {
		return args -> {
			fooDocRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(
						new FooDoc(UUID.randomUUID().toString(), "doc1", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()),
						new FooDoc(UUID.randomUUID().toString(), "doc2", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()),
						new FooDoc(UUID.randomUUID().toString(), "doc3", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()),
						new FooDoc(UUID.randomUUID().toString(), "doc4", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()),
						new FooDoc(UUID.randomUUID().toString(), "doc5", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()),
						new FooDoc(UUID.randomUUID().toString(), "doc6", LocalDateTime.now(),
								UUID.randomUUID().toString().getBytes()))
						.forEach(f -> {
							fooDocRepository.save(f).subscribe(System.out::println);
						});
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FluxMongoApplication.class, args);
	}

}
