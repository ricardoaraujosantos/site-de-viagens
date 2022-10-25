import { useState} from "react";

const HostingSearch = () => {
    const [hospedagem, setHospedagem] = useState({
        local:"",
    })

    const [date, setDate] = useState({
        dataEntrada:"",
        dataSaida:"",
    })

   const [contCrianca, setContCrianca] = useState(0)
   const [contAdulto, setContAdulto] = useState(0)

   console.log("Adulto",contAdulto, "Criança", contCrianca)

    const {dataEntrada, dataSaida} = date;
    const {local} = hospedagem;
  
    const onChangeInput = (e) => {
        setHospedagem({ ...hospedagem, [e.target.name]: e.target.value });
        console.log(hospedagem)
    }

    const onChangeDate = (e) => {
        setDate({...date, [e.target.name]: e.target.value});
       console.log(date)
    }

    return (
        <main className="container-fuid">
            <header className="container py-1">
                <div className="row">
                    <div className="col">
                        <p className="fw-bold fs-5">As melhores hospedagens do mundo estão aqui no Viajar </p>
                    </div>
                </div>
            </header>

            <div className="container border border-secondary pt-4 mb-3 ">
                <div className="row ">
                    <div className="col-lg-3 col-sm-12">
                        <div className="input-group mb-4">
                            <label className="input-group-text ajust-capture-sm px-2"
                                htmlFor="dataEntrada"
                                >
                                Entrada
                            </label>
                            <input type="date" 
                                    aria-label="Check-in-user" 
                                    className="form-control"
                                    name="dataEntrada"
                                    value={dataEntrada}
                                    onChange={(e) => onChangeDate(e)}
                                    />
                        </div>
                    </div>

                    <div className="col-lg-3 col-sm-12">
                        <div className="input-group mb-4">
                            <label className="input-group-text ajust-capture-sm px-2"
                                    htmlFor="dataSaida"
                                >
                                Saida
                            </label>
                            <input type="date"
                                     aria-label="Check-out-user"
                                      className="form-control"
                                      name="dataSaida"
                                      value={dataSaida}
                                      onChange={(e) => onChangeDate(e)}
                                      />
                        </div>
                    </div>

                    <div className="col-lg-3 col-sm-12">
                        <div className="input-group mb-4">
                            <span className="input-group-text">Adultos</span>
                            <div>
                                <button className="btn btn-light border border-danger mx-2"
                                        type="number"
                                        onClick={() => {
                                            if(contAdulto > 0) setContAdulto(contAdulto - 1)
                                            }}
                                >
                                        <i className="ri-subtract-line"></i>
                                </button>
                                {contAdulto}
                                <button className="btn btn-light border border-success  mx-2"
                                        type="number" 
                                        onClick={() => {
                                            if(contAdulto >= 0) setContAdulto(contAdulto + 1)
                                            }}
                                >
                                        <i className="ri-add-fill"></i>
                                </button>
                            </div>   
                        </div>
                    </div>

                    <div className="col-lg-3 col-sm-12">
                        <div className="input-group mb-4">
                            <span className="input-group-text">Crianças</span>
                            <div>
                                <button className="btn btn-light border border-danger mx-2"
                                        type="number"
                                        onClick={ () => {
                                                    if(contCrianca > 0) setContCrianca(contCrianca - 1)
                                            } }
                                >
                                        <i className="ri-subtract-line"></i>
                                </button>
                                {contCrianca}
                                <button className="btn btn-light border border-success  mx-2"
                                        type="number" 
                                        onClick={ () => {
                                                    if(contCrianca >= 0) setContCrianca(contCrianca + 1)
                                            } }
                                >
                                        <i className="ri-add-fill"></i>
                                </button>
                            </div>    
                        </div>
                    </div>
                </div>

                <form>
                    <div className="row">
                        <div className="col-lg-6 col-sm-12">
                            <div className="input-group mb-4">
                                <label  className="input-group-text"
                                        htmlFor="local"
                                    >
                                    Cidade
                                </label>
                                <input type="text"
                                        aria-label="cidade-destino"
                                        className="form-control"
                                        placeholder="Para onde vai?"
                                        name="local"
                                        value={local}
                                        onChange={(e) => onChangeInput(e)}
                                    />
                            </div>
                        </div>
                        <div className="col-lg-6 col-sm-12">
                            <div className="d-grid gap-2 mb-4">
                                <input className="btn btn-primary" type="submit" value="Pequisar" />
                            </div>
                        </div>
                    </div>   
                </form>
            </div>
        </main>
      
    )
}

export default HostingSearch;