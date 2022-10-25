
const  View = ( {children} ) => {

    return (
        <div className="container">
            <div className="py-4">
                <table className="table">
                    <thead >
                        <tr>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody className="d-flex flex-wrap justify-content-center">
                        {children}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default View;