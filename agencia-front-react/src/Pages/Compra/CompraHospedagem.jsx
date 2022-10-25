import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import Api from "../../Api";
import "../../Styles/style.css"

const CompraHospedagem = () => {

    const { id } = useParams();

    const [hospedagem, setHospedagem] = useState({
        empresa: "",
        endereco: "",
        valor_diaria: "",
        imagem: "",
    })

    useEffect(() => {
        const loadHosting = async () => {
            const resposta = await Api.get(`/listar/hospedagem/${id}`);
            const data = resposta.data;
            console.log(data)
            setHospedagem(data);
        };
        loadHosting();
    }, []);

    return (

        <div className="container py-4">
            <table className="table">
                <thead>
                    <th width="25%">Empresa</th>
                    <th width="25%">Endereço</th>
                    <th width="25%">Valor</th>
                    <th width="25%">Fotos</th>
                </thead>
                <tbody>
                    <tr className="border border-2">
                        <td className="py-4">{hospedagem.empresa}</td>
                        <td className="py-4">{hospedagem.endereco}</td>
                        <td className="py-4">R$ {hospedagem.preco_diaria}</td>
                        <td className="py-4">{hospedagem.imagem}</td>
                    </tr>
                    <tr>
                        <td className="py-4">
                            <Link
                                className="btn btn-success btn-sm me-2"
                                to={"/login"}
                            >
                                Pagamento
                            </Link>
                            <Link
                                className="btn btn-warning btn-sm my-2"
                                to={"/hospedagem"}
                            >
                                Voltar
                            </Link>
                        </td>

                    </tr>
                </tbody>
            </table>
        </div>


    )
}

export default CompraHospedagem;