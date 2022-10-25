import { Route, Routes } from "react-router-dom"
import CadastroUser from "../Pages/CadastroUser";
import Contato from "../Pages/Contato";
import Hosting from "../Pages/Hosting";
import Passagem from "../Pages/Passagem";
import Promocao from "../Pages/Promocao";
import LoginUser from "../Pages/Login";
import CompraHospedagem from "../Pages/Compra/CompraHospedagem";
import CompraPassagem from "../Pages/Compra/CompraPassagem";

const Router = () => {
    return(
        <Routes> 
            <Route exact path="/" element={<CadastroUser/>}/>
            <Route exact path="/login" element={<LoginUser/>}/>
            <Route exact path="/hospedagem" element={<Hosting />} />
            <Route exact path="/listar/hospedagem/:id" element={<CompraHospedagem />}/>
            <Route exact path="/passagem" element={<Passagem />} />
            <Route exact path="/listar/passagem/:id" element={<CompraPassagem />}/>
            <Route exact path="/promocao"  element={<Promocao />}/>
            <Route exact path="/contato"  element={<Contato />}/>
        </Routes>
    )
   
}

export default Router;