package com.projectph.workshopmongo.repository;

import com.projectph.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface PostRepository extends MongoRepository<Post, String> {

}
