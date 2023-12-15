
import './App.css';
import Create from './Components/Create';
import Update from './Components/Update';
import Display from './Components/Display';
import Delete from './Components/Delete'

function App() {
  return (
    <div className="App">
      <Create/>
      <Update/>
      <Display/>
      <Delete/>
    </div>
  );
}

export default App;
