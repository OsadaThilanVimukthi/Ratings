package com.example.Rating.Service;


import com.example.Rating.Entity.Rating;
import com.example.Rating.Repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

@Autowired
private RatingRepo ratingRepo;
    public void saveorUpdate(Rating rating) {
        ratingRepo.save(rating);
    }

    public Iterable<Rating> listAll() {

        return this.ratingRepo.findAll();
    }

    public void deleteRating(String id) {

        ratingRepo.deleteById(id);
    }

    public Rating getRatingByID(String ratingId) {

        return ratingRepo.findById(ratingId).get();
    }
}
