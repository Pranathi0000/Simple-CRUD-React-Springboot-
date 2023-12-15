import React, { useState } from 'react';
import axios from 'axios';

function Create() {
  const [course, setCourse] = useState({
    name: '',
    price: 0,
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCourse({ ...course, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/course', course);
      // Handle success
      console.log('Course created:', response.data);
      // Optionally, you can redirect or perform other actions upon successful creation
    } catch (error) {
      // Handle error
      console.error('Error creating course:', error);
    }
  };

  return (
    <div>
      <h2>Create a Course</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Course Name:
          <input type="text" name="name" value={course.name} onChange={handleChange} />
        </label>
        <label>
          Price:
          <input type="number" name="price" value={course.price} onChange={handleChange} />
        </label>
        <button type="submit">Add Course</button>
      </form>
    </div>
  );
}

export default Create;
