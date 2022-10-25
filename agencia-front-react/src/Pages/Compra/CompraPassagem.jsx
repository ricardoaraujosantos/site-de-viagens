import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import Api from "../../Api";

const CompraPassagem = () => {

    const { id } = useParams();

    const [passagem, setPassagem] = useState({
        embarque: "",
        desembarque: "",
        valor_passagem: "",
        empresa: "",
    })

    useEffect(() => {
        const loadPassagem = async () => {
            const resposta = await Api.get(`/listar/passagem/${id}`);
            const data = resposta.data;
            console.log(data)
            setPassagem(data);
        };
        loadPassagem();
    }, []);

    return (

        <div className="container py-4">
        <table className="table">
            <thead>
                <th>Empresa</th>
                <th>Embarque</th>
                <th>Desembarque</th>
                <th>Valor da Passagem</th>
            </thead>
            <tbody>
            <tr className="border border-2">
                <td className="py-4">{passagem.empresa}</td>
                <td className="py-4">{passagem.embarque}</td>
                <td className="py-4">{passagem.desembarque}</td>
                <td className="py-4">R$ {passagem.valor_passagem}</td>
                <td className="py-4">
                    <Link
                        className="btn btn-success btn-sm me-2"
                        to={"/login"}
                    >
                        Pagamento
                    </Link>
                    <Link
                        className="btn btn-warning btn-sm"
                        to={"/passagem"}
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

export default CompraPassagem;