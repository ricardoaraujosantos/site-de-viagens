const Contato = () => {
    return(

        <main className="container-fluid my-4">

        <form method="post" action="mailto:ricardoaraujo3713@gmail.com" className="form-control container p-4">
            <div className="row">
                <div className="col">
                    <div className="input-group mb-3">
                        <span className="input-group-text" id="inputName">Nome :</span>
                        <input type="text" className="form-control" placeholder="Digite seu nome completo"
                            aria-label="Username" aria-describedby="inputName"/>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <div className="input-group mb-3">
                        <span className="input-group-text" id="inputEmail">E-mail :</span>
                        <input type="text" className="form-control" placeholder="Digite seu email" aria-label="Username"
                            aria-describedby="inputEmail"/>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <div className="input-group mb-3">
                        <span className="input-group-text" id="inputCidade">Cidade:</span>
                        <input type="text" className="form-control" placeholder="Digite sua cidade" aria-label="Username"
                            aria-describedby="inputCidade"/>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <div className="input-group">
                        <div className="input-group-text mb-2 ">
                            <input className="form-check-input mt-0" type="radio" value="#" aria-label="Radio button input"/>
                        </div>
                        <label className="mx-2" htmlFor="Prioridade">Assunto urgente</label>
                    </div>
                </div>
            </div>

            <div className="row mb-2 ">
                <div className="col">
                    <div className="form-floating">
                        <textarea className="form-control" placeholder="Comentarios" id="areaForm" style={{height: 200}}></textarea>
                        <label htmlFor="areaForm">Escreva sobre o assunto aqui!</label>
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col">
                    <button className="btn btn-sm btn-primary" type="submit">Enviar</button>
                </div>
                <div className="col">
                    <input className=" btn btn-sm btn-primary" type="reset" value="Limpar"/>
                </div>
            </div>

        </form>

    </main>

    )
}

export default Contato;