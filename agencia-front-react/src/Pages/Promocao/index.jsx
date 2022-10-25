import { Link } from "react-router-dom";
import { Span } from "./styles";

const Promocao = () => {

    return(
        <main className="container-fluid bg-theme pt-2 my-4">
        <div className="container">
            <div className="row bg-success text-light rounded-pill text-center py-2">
                <div className="col">
                    <h5 className="title-logo">Vem de Promoção!</h5>
                </div>

                <div className="col">
                    <h5 className="title-logo">Descontão de ate 30%  &#x1F911;</h5>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <div className="card my-3 border border-3"> 
                        <div className="card-body">
                            <h5 className="card-title fs-6 fw-bolder">Porto Seguro</h5>
                            <p className="card-text">4 dias de <strike><Span>R$1099.00</Span></strike></p>
                            <p className="card-text">Por <span className="text-success fs-4 fw-bolder">R$845,22</span></p>
                            <Link to="#" className="btn-sm btn-primary">Comprar</Link>
                        </div>
                    </div>
                </div>

                <div className="col">
                    <div className="card my-3 border border-3">
                        <div className="card-body">
                            <h5 className="card-title fs-6 fw-bolder">Jericoacoara</h5>
                            <p className="card-text">3 dias de <strike><Span>R$1149.00</Span></strike></p>
                            <p className="card-text">Por <span className="text-success fs-4 fw-bolder">R$824,30</span></p>
                            <Link to="#" className="btn-sm btn-primary">Comprar</Link>
                        </div>
                    </div>
                </div>

                <div className="col">
                    <div className="card my-3 border border-3">
                        <div className="card-body">
                            <h5 className="card-title fs-6 fw-bolder">Porto de Galinhas</h5>
                            <p className="card-text">7 dias de <strike><Span>R$1199.00</Span></strike></p>
                            <p className="card-text">Por <span className="text-success fs-4 fw-bolder">R$974,25</span></p>
                            <Link to="#" className="btn-sm btn-primary">Comprar</Link>
                        </div>
                    </div>
                </div>

                <div className="col">
                    <div className="card my-3 border border-3">
                        <div className="card-body">
                            <h5 className="card-title fs-6 fw-bolder">Rio de Janeiro</h5>
                            <p className="card-text">5 dias de <strike><Span>R$1149.00</Span></strike></p>
                            <p className="card-text">Por <span className="text-success fs-4 fw-bolder">R$886,75</span></p>
                            <Link to="#" className="btn-sm btn-primary">Comprar</Link>
                        </div>
                    </div>
                </div>

                <div className="col">
                    <div className="card my-3 border border-3">
                        <div className="card-body">
                            <h5 className="card-title fs-6 fw-bolder">Foz do Iguaçu</h5>
                            <p className="card-text">6 dias de <strike><Span>R$1299.00</Span></strike></p>
                            <p className="card-text">Por <span className="text-success fs-4 fw-bolder">R$959,30</span></p>
                            <Link to="#" className="btn-sm btn-primary">Comprar</Link>
                        </div>
                    </div>
                </div>

                
            </div>

        </div>
    </main>
    )
}

export default Promocao;