import React, { useState } from 'react';
import axios from 'axios';

function Update() {
  const [course, setCourse] = useState({
    cid: 0, // Assuming you retrieve the course ID somehow
    name: '',
    price: 0,
  });
  // Run this effect only once on component mount


  const handleChange = (e) => {
    const { name, value } = e.target;
    setCourse({ ...course, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put('http://localhost:8080/course', course);
      // Handle success
      console.log('Course updated:', response.data);
      // Optionally, you can redirect or perform other actions upon successful update
    } catch (error) {
      // Handle error
      console.error('Error updating course:', error);
    }
  };

  return (
    <div>
      <h2>Update Course</h2>
      <form onSubmit={handleSubmit}>
        <label>
            Id:
            <input type="number" name="cid" value={course.cid} onChange={handleChange}/>
        </label>
        <label>
          Course Name:
          <input type="text" name="name" value={course.name} onChange={handleChange} />
        </label>
        <label>
          Price:
          <input type="number" name="price" value={course.price} onChange={handleChange} />
        </label>
        <button type="submit">Update Course</button>
      </form>
    </div>
  );
}

export default Update;
