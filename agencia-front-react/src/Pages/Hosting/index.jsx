import React, { useState, useEffect } from "react"
import { useParams, Link } from "react-router-dom";
import Api from "../../Api";
import "../../Styles/style.css"

import View from "../../Componets/View";
import Search from "../../Componets/Search";
import Carousel from "../../Componets/Carousel";
import { ImageCaption } from "../../Componets/Carousel/styles";
import image from "../../assets/image/rio.jpg"
import Title from "../../Componets/Title";
import Aside from "../../Componets/Aside";
import { ContainerMain } from "./styles";
import HospedagemNacional from "../../assets/Constants/hospedagemNacional";
import CidadesInternacionais from "../../assets/Constants/internacionais";

const Hosting = () => {

    const [hospedagem, setHospedagem] = useState([])

    //const { id } = useParams();

    useEffect(() => {
        const loadHosting = async () => {
            const resposta = await Api.get("/list/hospedagem");
            const data = resposta.data;
            console.log(data)
            setHospedagem(data);
        };
        loadHosting();
    }, []);

    return (
        <div>
            <Search />
            <ContainerMain className="row">
                <Carousel title="Os destinos mais procurados no Brasil">

                    <div className="carousel-item active">
                        <img style={{ height: 400 }} src={image} className="d-block w-100" alt="Cidade Rio de Janeiro RJ" />
                        <ImageCaption className="carousel-caption d-md-block caption-img">
                            <h5>Rio de Janeiro RJ</h5>
                            <p>Visite a cidade maravilhosa!</p>
                        </ImageCaption>
                    </div>

                    {/* Cosumindo um objeto Constants hospedagemNacional*/}

                    {HospedagemNacional.map((h) => (
                        <div key={h.id} className="carousel-item">
                            <img src={h.foto} className="d-block w-100 img-carousel" alt="Cidade Gramado RS" />
                            <ImageCaption className="carousel-caption d-md-block">
                                <h5>{h.nome}</h5>
                                <p>{h.descricao}</p>
                            </ImageCaption>
                        </div>
                    ))}

                    {/* Cosumindo um objeto Constants internacionais*/}

                </Carousel>
                <Aside title="Destinos internacionais">
                    <div className="row">
                        {CidadesInternacionais.map((h) => (
                            <div key={h.id} className="col img-container">
                                <img className="img-width border rounded" src={h.foto} alt={h.descricao} />
                                <p>{h.nome}</p>
                            </div>
                        ))}
                    </div>
                </Aside>
            </ContainerMain>

            {/* Retornando dados da api tabela hospedagens */}

            <Title name="Hospedagens" />
            <View>
                {hospedagem.map((h) => (
                    <tr key={h.id} className="m-4 border rounded border-2 border-dark tr-width">
                        {/* //<th scope="row" ></th> */}
                        <td>
                            <p className="my-0"><strong>Empresa: </strong>{h.empresa}</p>
                            <p className="my-0"><strong>Local: </strong>{h.endereco}</p>
                            <p className="my-0"><strong>Diaria: </strong>R$ {h.preco_diaria.toFixed(2)}</p>

                            <p className="mt-2 mx-auto">
                                <Link
                                    className="btn btn-primary btn-sm"
                                    to={`/listar/hospedagem/${h.id}`}
                                >
                                    Reservar
                                </Link>
                            </p>
                        </td>
                    </tr>
                ))}
            </View>
        </div>

    )
}

export default Hosting;