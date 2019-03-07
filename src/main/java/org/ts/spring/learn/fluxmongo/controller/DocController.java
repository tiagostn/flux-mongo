package org.ts.spring.learn.fluxmongo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ts.spring.learn.fluxmongo.model.FooDoc;
import org.ts.spring.learn.fluxmongo.repository.FooDocRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/foo")
public class DocController {

	@Autowired
	private FooDocRepository fooDocRepository;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<FooDoc> getAll() {
		Flux<FooDoc> all = fooDocRepository.findAll();
		// all.subscribe(System.out::println);
		return all;
	}

	@GetMapping("/{id}")
	public Mono<FooDoc> getById(@PathVariable("id") final String id) {
		return fooDocRepository.findById(id);
	}

	@GetMapping("/{id}/update")
	public Mono<FooDoc> updateById(@PathVariable("id") final String id) {
		fooDocRepository.findById(id).subscribe(foo -> {
			foo.setData((new String(foo.getData()) + " updated asdfg").getBytes());
			foo.setLastUpdate(LocalDateTime.now());
			foo.setName("doc Alterado 4");
			fooDocRepository.save(foo).subscribe();
		});
		return fooDocRepository.findById(id);
	}

}
