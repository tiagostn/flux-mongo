package org.ts.spring.learn.fluxmongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.ts.spring.learn.fluxmongo.model.FooDoc;

@Repository
public interface FooDocRepository extends ReactiveMongoRepository<FooDoc, String>{

}
