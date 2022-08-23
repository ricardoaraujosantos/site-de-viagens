
const btnUserCadastrarBd = document.getElementById('btnCadastrarBd');
const btnUserEntrar = document.getElementById('btnEntrar');
let modalFooter = document.getElementById('modalFooter');
const CampoEmail = document.getElementById('email');
const CampoSenha = document.getElementById('password');
const sairCadastro = document.getElementById('sairCadastro');
let logado = false;

const user = [
    {
       email:'ricardo@recode',
       senha:'12345678'
    }
];

btnUserCadastrarBd.addEventListener('click', (ev) => {
    ev.preventDefault();
        user.map(elem => {
             elem.senha = CampoSenha.value, elem.email = CampoEmail.value;
    })
  
    modalFooter.innerHTML = ` <p class="text-success fw-bold">Cadastro realizado com sucesso!!!</p>
                             <a  href="./entrar.html" class="btn btn-success">Entrar</a>`;
     console.log(user);
});


btnUserEntrar.addEventListener('click', (ev) => {
    ev.preventDefault();

    user.map(elem => {
        if(elem.senha === CampoSenha.value && elem.email === CampoEmail.value){
            setTimeout(() =>{
                location.href = "./index.html"
            },3000);
            logado = true;
            console.log('Usuario logado', logado);
        }else{
            document.getElementById('erroSenha').innerHTML = "Erro, senha ou email invalidos!"
            logado = false;
            console.log('Usuario logado', logado);
        } 
        return logado;     })
});
console.log('Usuario logado',logado);
