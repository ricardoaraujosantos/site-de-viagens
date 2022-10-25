import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import Api from "../../Api";
import "../../Styles/style.css"

import { ContainerMain } from "../Hosting/styles";
import { ImageCaption } from "../../Componets/Carousel/styles";
import Carousel from "../../Componets/Carousel";
import Salvador from "../../assets/image/salvador.jpg"
import Aside from "../../Componets/Aside";
import Title from "../../Componets/Title";
import View from "../../Componets/View";

import CidadesInternacionais from "../../assets/Constants/internacionais";
import PassagemNacional from "../../assets/Constants/passagemNacional";

const Passagem = () => {

    const [passagem, setPassagem] = useState([])

    //const { id } = useParams();

    useEffect(() => {
        const loadPassagem = async () => {
            const resposta = await Api.get("/list/passagem");
            const data = resposta.data;
            console.log(data)
            setPassagem(data);
        };
        loadPassagem();
    }, []);

    return (
        <div>

            <ContainerMain className="row">
                <Carousel title="Os Destinos mais procurados">
                
                        <div className="carousel-item active">
                            <img src={Salvador} className="d-block w-100 img-carousel" alt="Cidade Rio de Janeiro RJ" />
                            <ImageCaption className="carousel-caption d-md-block caption-img">
                                <h5>Salvador</h5>
                                <p>Voe para salvador</p>
                            </ImageCaption>
                        </div>

                        {/* Cosumindo um objeto Constants hospedagemNacional*/}

                        {PassagemNacional.map((h) => (
                            <div key={h.id} className="carousel-item">
                                <img src={h.foto} className="d-block w-100 img-carousel" alt="Cidade Gramado RS" />
                                <ImageCaption className="carousel-caption d-md-block">
                                    <h5>{h.nome}</h5>
                                    <p>{h.descricao}</p>
                                </ImageCaption>
                            </div>
                        ))}
                    
                </Carousel>
                <Aside title="Destinos internacionais">
                    <div className="row">
                        {CidadesInternacionais.map((h) => (
                            <div key={h.id} className="col-sm-12 col-md-6 img-container">
                                <img className="img-width" src={h.foto}  alt={h.descricao} />
                                <p>{h.nome}</p>
                            </div>
                        ))}
                    </div>
                </Aside>
            </ContainerMain>

            {/* Retornado dados da api tabela Passagem */}

            <Title name="Passagens" />
            <View>
                {passagem.map((p) => (
                    <tr key={p.id_passagem} className="mt-4 mb-1 me-2 border border-4 flex-wrap tr-width">
                        {/* <th scope="row" ></th> */}
                        <td >
                            <p>
                            <i className="ri-flight-takeoff-line border border-2 p-1 mx-1"></i>
                            <strong>Embarque</strong>  {p.desembarque}
                            </p>
                            <p>
                            <i className="ri-flight-land-line border border-2 p-1 mx-1"></i>
                            <strong>Desembarque</strong>  {p.embarque}
                            </p>
                            <p>
                            <i className="ri-plane-fill border border-2 p-1 mx-1"></i>
                            <strong>Empresa</strong>  {p.empresa}
                            </p>
                            <p>
                            <i className="ri-money-dollar-box-line border border-2 p-1 mx-1"></i>
                            <strong>Valor</strong>  R$ {p.valor_passagem}
                            </p>
                            <p className="mt-2">
                            <Link
                                className="btn btn-primary btn-sm"
                                to={`/listar/passagem/${p.id_passagem}`}
                            >
                                Comprar
                            </Link>
                            </p>
                        </td>
                        

                        
                           
                       
                    </tr>
                ))}
            </View>
        </div>

    )
}

export default Passagem;