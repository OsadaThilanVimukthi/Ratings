package com.example.Rating.Repo;

import com.example.Rating.Entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepo extends MongoRepository<Rating,String> {



}
