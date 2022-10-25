import Api from "../../Api";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const CadastroUser = () => {

    let navigate = useNavigate();

    const [user, setUser] = useState({
        nome: "",
        endereco: "",
        email: "",
        senha: "",
    });

    const { nome, endereco, email, senha } = user;

    const onInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
        console.log(user)
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await Api.post("/user/add", user);
        navigate("/login");
    };


    return (

        <form onSubmit={(e) => onSubmit(e)} id="modal" aria-labelledby="modalLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">

                    <div className="modal-header">
                        <p className="fw-bolder fs-5">Cadastre-se ou click acima em Entrar!</p>
                    </div>

                    <div className="modal-body">
                        <div className="mb-1">
                            <label htmlFor="userName" className="form-label mb-0 fw-bold">Nome</label>
                            <input type="text"
                                className="form-control"
                                id="userName"
                                placeholder="Nome completo"
                                name="nome"
                                value={nome}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-1">
                            <label htmlFor="userName" className="form-label mb-0 fw-bold">Endereço</label>
                            <input type="text"
                                className="form-control"
                                id="userEndereco"
                                placeholder="Endereço"
                                name="endereco"
                                value={endereco}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className="mb-1">
                            <label htmlFor="email" className="form-label mb-0 fw-bold">Email</label>
                            <input type="text"
                                className="form-control"
                                id="email"
                                placeholder="name@example.com"
                                name="email"
                                value={email}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className="mb-1">
                            <label htmlFor="password" className="col-sm-12 col-form-label mb-0 fw-bold">Senha</label>
                            <input type="password"
                                className="form-control"
                                id="password"
                                placeholder="********"
                                name="senha"
                                value={senha}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className="my-4">

                            <div>
                                <button id="btnCadastrarBd" className="btn btn-primary col-sm-12"
                                    type="submit">Cadastrar</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </form>

    )
}

export default CadastroUser;