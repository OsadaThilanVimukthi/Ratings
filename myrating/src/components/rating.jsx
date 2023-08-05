import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RatingForm = ({ handleRatingSubmit }) => {
    const [rating, setRating] = useState(0);
    const [comment, setComment] = useState('');
  
    const handleRatingChange = (event) => {
      setRating(Number(event.target.value)); // Convert the value to a number
    };
  
    const handleCommentChange = (event) => {
      setComment(event.target.value);
    };
  
    const handleSubmit = (event) => {
      event.preventDefault();
      handleRatingSubmit({ value: rating, comment });
      setRating(0);
      setComment('');
    };
  
    return (
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Rating:</label>
          <div>
            {[1, 2, 3, 4, 5, 6, 7, 8, 9, 10].map((value) => (
              <label key={value} className="radio-label">
                <input
                  type="radio"
                  value={value}
                  checked={rating === value}
                  onChange={handleRatingChange}
                  className="form-check-input"
                />
                {value}
              </label>
            ))}
          </div>
        </div>
        <div className="form-group">
          <label>Comment:</label>
          <textarea
            value={comment}
            onChange={handleCommentChange}
            className="form-control"
            rows="4"
          />
        </div>
        <button type="submit" className="btn btn-primary mt-4">
          Submit Rating
        </button>
      </form>
    );
  };
  

  const RatingList = ({ ratings }) => {
    return (
      <div>
        <h2>All Ratings:</h2>
        <ul className="list-group">
          {ratings.map((rating) => (
            <li key={rating.id} className="list-group-item">
              Rating: {rating.value}, Comment: {rating.comment}
            </li>
          ))}
        </ul>
      </div>
    );
  };
  

const App = () => {
  const [ratings, setRatings] = useState([]);

  useEffect(() => {
    fetchRatings();
  }, []);

  const fetchRatings = async () => {
    try {
      const response = await axios.get('http://localhost:8081/api/v1/rating/getAll');
      setRatings(response.data);
    } catch (error) {
      console.error('Error fetching ratings:', error);
    }
  };

  const handleRatingSubmit = async (newRating) => {
    try {
      const response = await axios.post('http://localhost:8081/api/v1/rating/save', newRating);
      fetchRatings();
      console.log('New rating ID:', response.data);
    } catch (error) {
      console.error('Error submitting rating:', error);
    }
  };

  return (
    <div>
      <h1>Rate and Comment</h1>
      <RatingForm handleRatingSubmit={handleRatingSubmit} />
      <RatingList ratings={ratings} />
    </div>
  );
};

export default App;
