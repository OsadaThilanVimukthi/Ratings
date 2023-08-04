package com.example.Rating.Controller;



import com.example.Rating.Entity.Rating;
import com.example.Rating.Repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/getall")
    public String showRatingForm(Model model) {
        model.addAttribute("rating", new Rating());
        return "rating_form";
    }

    @PostMapping("/")
    public String submitRatingForm(@ModelAttribute Rating rating) {
        ratingRepository.save(rating);
        return "redirect:/ratings/";
    }

    @GetMapping("/list")
    public String listRatings(Model model) {
        model.addAttribute("ratings", ratingRepository.findAll());
        return "rating_list";
    }
}
