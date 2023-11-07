import Header from './components/Header/Header.jsx';
import Examples from './components/Examples/Examples.jsx';
import CoreConcepts from './components/CoreConsepts/CoreConsepts.jsx';

function App() {

  return (
    <>
      <Header />
      <main>
        <CoreConcepts />
        <Examples />
      </main>
    </>
  );
}

export default App;
