import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DisplayCourses() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await axios.get('http://localhost:8080/courses'); // Replace '/courses' with your actual API endpoint
      setCourses(response.data);
    } catch (error) {
      // Handle error
      console.error('Error fetching courses:', error);
    }
  };

  return (
    <div>
      <h2>All Courses</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.cid}>
            {course.name} - ${course.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default DisplayCourses;
