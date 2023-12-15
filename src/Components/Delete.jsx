import React, { useState } from 'react';
import axios from 'axios';

function Delete() {
  const [deletedCourse, setDeletedCourse] = useState(null);
  const [courseId, setCourseId] = useState('');

  const handleInputChange = (e) => {
    setCourseId(e.target.value);
  };

  const handleDelete = async () => {
    try {
      const response = await axios.delete(`http://localhost:8080/course/${courseId}`); // Replace '/course/${courseId}' with your delete endpoint
      console.log('Course deleted:', response.data);
      setDeletedCourse(response.data); // Save the deleted course record
    } catch (error) {
      // Handle error
      console.error('Error deleting course:', error);
      setDeletedCourse(null); // Clear deletedCourse state if deletion fails
    }
  };

  return (
    <div>
      <h2>Delete Course by ID</h2>
      <label>
        Enter Course ID:
        <input type="text" value={courseId} onChange={handleInputChange} />
      </label>
      <button onClick={handleDelete}>Delete</button>

      {deletedCourse && (
        <div>
          <h3>Course Deleted </h3>
        </div>
      )}
    </div>
  );
}

export default Delete;
