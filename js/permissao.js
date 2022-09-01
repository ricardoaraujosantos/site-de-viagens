const permissao = document.getElementById("permissao");
let divSpinner = document.getElementById("spinner");

const senhaAdm = "1234";
let spinner =  `  <div class="spinner-border text-light" role="status">
                    <span class="visually-hidden">Loading...</span>
                  </div>
                `;

permissao.addEventListener('click', () => {
    const codAdm = prompt("Digite o codigo de autorização do administrador");

    divSpinner.innerHTML= spinner;
    
    if(codAdm == senhaAdm){
       setTimeout(() =>{ 
            location.href = "./cadastroProd.html";
        },3000); 
    }else{
        alert("Codigo invalido");
    }
});