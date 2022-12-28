import { useState } from "react";
import { Link } from "react-router-dom";
import { ContainerIcon, FooterWrapper, Icon } from "./styles";

const Footer = () => {

    const [email, setEmail] = useState('')

    const onInputChange = (e) => {
        setEmail(e.target.value);
        console.log(email)
    }

    return (


        <FooterWrapper className="container-fluid bg-footer py-4 ">

            <div className="container bg-footer-fluid px-4">

                <div className="row sm-footer-row">
                    <div className="col-lg-2 col-md-4 ">
                        <h5>Sobre</h5>
                        <Link className="text-white" to={""}>
                            <p>Quem somos</p>
                        </Link>
                    </div>

                    <div className="col-lg-2  col-md-4">
                        <h5>Aluguel</h5>
                        <Link className="text-white"  to={""}>
                            <p>Carros</p>
                        </Link>
                    </div>

                    <div className="col-lg-2  col-md-4">
                        <h5>Conta</h5>
                        <Link className="text-white" to={""} id="permissao" >
                            <p>Permissões</p>
                        </Link>

                    </div>

                    <div className="col-lg-6  col-md-12 ">
                        <h5>Assine a nossa newsletter</h5>
                        <p>Cadastre seu email e receba ofetas exclusivas!</p>
                        <div className={"input-group input-group-sm mb-3 mb-3"}>
                            <input type="text"
                                value={email}
                                className={"form-control"}
                                placeholder="usuario@email"
                                aria-label="user e-mail"
                                aria-describedby="user e-mail"
                                onChange={(e) => onInputChange(e)}
                            />
                            <button type="button" className="btn btn-outline-dark fw-bolder btn-sm">Inscrever-me</button>
                        </div>
                    </div>

                </div>

                <div className="row sm-footer-row">
                    <div className="col">
                        <p>&copy; Viajar. Todos os direitos reservados</p>
                    </div>
                    <ContainerIcon className="col">
                        <Link to={""}><Icon><i className="ri-twitter-fill"></i></Icon></Link>
                        <Link to={""}><Icon><i className="ri-instagram-fill"></i></Icon></Link>
                        <Link to={""}><Icon><i className="ri-facebook-circle-fill"></i></Icon></Link>
                    </ContainerIcon>
                </div>

            </div>
        </FooterWrapper>
    )
};

export default Footer;
