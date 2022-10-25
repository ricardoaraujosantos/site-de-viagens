import { useState} from "react";
import Api from "../../Api";
import { Link, useNavigate } from "react-router-dom";

const LoginUser = () => {

    let navigate = useNavigate();

    const [Login, setLogin] = useState({
        username: "",
        password: "",
      
    });

    const { username, password } = Login;

    const onInputChange = (e) => {
        setLogin({ ...Login, [e.target.name]: e.target.value });
        console.log(Login)
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await Api.post("/login");
        navigate('/hospedagem');
    };

    return (

        <form onSubmit={(e) => onSubmit(e)} id="modal" aria-labelledby="modalLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">

                    <div className="modal-header">
                        <p className="fw-bolder fs-5">Entrar</p>
                    </div>

                    <div className="modal-body">
                        <div className="mb-1">
                            <label htmlFor="userName" className="form-label mb-0 fw-bold">Email</label>
                            <input type="text"
                                className="form-control"
                                id="userName"
                                placeholder="User Email"
                                name="username"
                                value={username}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                       
                        <div className="mb-1">
                            <label htmlFor="password" className="col-sm-12 col-form-label mb-0 fw-bold">Senha</label>
                            <input type="password"
                                className="form-control"
                                id="password"
                                placeholder="********"
                                name="password"
                                value={password}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>

                        <div className="my-4">

                            <div>
                                <button id="btnCadastrarBd" className="btn btn-primary col-sm-12"
                                    type="submit">Entrar</button>
                            </div>
                        </div>
                        <div className="my-4">
                           <Link to={'/'}>Não tem cadastro? Cadastre-se</Link>
                        </div>
                    </div>
                </div>
            </div>
        </form>

    )
}

export default LoginUser;