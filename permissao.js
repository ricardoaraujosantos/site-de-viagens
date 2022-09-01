const permissao = document.getElementById("permissao");
let spinner = document.getElementById("spinner")

const senhaAdm = "1234";

permissao.addEventListener('click', () => {
    const codAdm = prompt("Digite o codigo de autorização do administrador");

    if(codAdm == senhaAdm){
        spinner.innerHTML = `<div class="spinner-border text-light" role="status">
                                <span class="visually-hidden">Loading...</span>
                            </div>
                            `;
        setTimeout(() =>{
            location.href = "./cadastroProd.html";
        },3000);
    }else{
        alert("Codigo invalido")
    }
})
