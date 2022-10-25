import { AsideCarousel } from "./styles";


const Carousel = ( {children, title}) => {
    return (
       

            <AsideCarousel className="container carousel-aside bg-theme mx-4 col">

                <div className="row">
                    <div className="col">
                        <h5 className="pt-2">{title}</h5>
                    </div>
                </div>

                <div className="row rounded">
                    <div className="col">
                        <div id="carouselCaptions" className="carousel slide " data-bs-ride="carousel">
                            <div className="carousel-indicators">
                                <button type="button" data-bs-target="#carouselCaptions" data-bs-slide-to="0" className="active"
                                    aria-current="true" aria-label="Slide 1">
                                </button>
                                <button type="button" data-bs-target="#carouselCaptions" data-bs-slide-to="1"
                                    aria-label="Slide 2">
                                </button>
                                <button type="button" data-bs-target="#carouselCaptions" data-bs-slide-to="2"
                                    aria-label="Slide 3">
                                </button>
                                <button type="button" data-bs-target="#carouselCaptions" data-bs-slide-to="3"
                                    aria-label="Slide 3">
                                </button>
                                <button type="button" data-bs-target="#carouselCaptions" data-bs-slide-to="4"
                                    aria-label="Slide 3">
                                </button>
                            </div>
                            <div className="carousel-inner">
                                {children}
                            </div>
                            <button className="carousel-control-prev" type="button" data-bs-target="#carouselCaptions"
                                data-bs-slide="prev">
                                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span className="visually-hidden">Previous</span>
                            </button>
                            <button className="carousel-control-next" type="button" data-bs-target="#carouselCaptions"
                                data-bs-slide="next">
                                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                                <span className="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </AsideCarousel>

           
       

    )
}

export default Carousel;