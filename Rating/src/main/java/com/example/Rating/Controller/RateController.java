package com.example.Rating.Controller;

import com.example.Rating.Entity.Rating;
import com.example.Rating.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/rating")
public class RateController {


    @Autowired
    private RatingService ratingService;

    @PostMapping(value = "/save")
    private String  saveRating(@RequestBody Rating rating){


        ratingService.saveorUpdate(rating);
        return rating.getId();
    }
    @GetMapping(value = "/getAll")
 private Iterable<Rating>getRating()

    {
        return ratingService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Rating update(@RequestBody Rating rating,@PathVariable(name="id")String id){
        rating.setId(id);
        ratingService.saveorUpdate(rating);
        return rating;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteRating(@PathVariable("id")String id){
        ratingService.deleteRating(id);
    }

    @RequestMapping(value = "rating/{id}")
    private Rating getRating(@PathVariable(name="id")String ratingId){
        return ratingService.getRatingByID(ratingId);
    }


}
