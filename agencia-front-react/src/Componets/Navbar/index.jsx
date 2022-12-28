import { Link } from "react-router-dom";
import Logo from "../Logo";
import { Wrapper } from "./style";

const Navbar = () => {

    return (
        <Wrapper className="container-fluid bg-nav-container py-2">
            <div className="background-plane"></div>
            <header className="container">

                <nav className="navbar-nav navbar-dark">

                    <div className="row mt-0">

                        <Logo className={"col"} />

                        <div id="spinner" className="col">
                            <ul className="list-group list-group-horizontal justify-content-center mb-1 pt-3">

                                <Link className="link" to={'/login'}>
                                    <li className="list-group-item list-group-horizontal  border rounded">
                                        <i className="ri-user-shared-2-line"> </i>
                                        Entrar
                                    </li>
                                </Link>

                                <Link className="link" to={''}>
                                    <li className="list-group-item list-group-horizontal  border rounded">
                                        <i className="ri-suitcase-line"> </i>
                                        Reservas
                                    </li>
                                </Link>


                                <Link className="link" to={''}>
                                    <li className="list-group-item list-group-horizontal border rounded">
                                        <i className="ri-customer-service-line"> </i>
                                        Ajuda
                                    </li>
                                </Link>

                            </ul>
                        </div>
                    </div>
                    <div className="row mt-0">
                        <div className="col">
                            <ul className="list-group list-group-horizontal ajust-nav-sm">
                                <Link className="link" to="/hospedagem" >
                                    <li className="list-group-item  border rounded">Home</li>
                                </Link>
                                <Link className="link" to="/passagem">
                                    <li className="list-group-item  border rounded" >Passagens</li>
                                </Link>
                                <Link className="link" to="/promocao" >
                                    <li className="list-group-item  border rounded">Promoções</li>
                                </Link>
                                <Link className="link" to="/contato" >
                                    <li className="list-group-item  border rounded">Contato</li>
                                </Link>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
        </Wrapper>

    )
}

export default Navbar;