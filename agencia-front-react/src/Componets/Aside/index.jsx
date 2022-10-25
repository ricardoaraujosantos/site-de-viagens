

const Aside = ( {children, title}) => {

    return(
    <aside className="container aside-right bg-theme col-md-12 col-lg-6">
        <div className="row">
            <div className="col">
                <h5 className="pt-2 ms-4">{title}</h5>
            </div>
        </div>
        {children}
    </aside>
    )
}

export default Aside;