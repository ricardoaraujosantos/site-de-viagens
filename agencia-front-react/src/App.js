

import { BrowserRouter } from 'react-router-dom';
import Footer from './Componets/Footer';
import Navbar from './Componets/Navbar';
import Routes from './Routes';
import GlobalStyles from './Styles/GlobalStyles';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <GlobalStyles/>
        <Navbar />
        <Routes />
        <Footer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
