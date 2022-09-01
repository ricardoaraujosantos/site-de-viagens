// variaveis recebe elementos Formularios Passagem
const btnCadastrarPassagem = document.getElementById('btnCadastrar');
const btnAtualizarPassagem = document.getElementById('btnAtualizar');
const btnVisualizarPassagem = document.getElementById('btnVisualizar');
const btnDeletarPassagem = document.getElementById('btnDeletar');
let inputIdPassagem = document.getElementById('idPassagem');
let inputLabelPassagem = document.getElementById('labelPassagem');

//Eventos de click
btnCadastrarPassagem.addEventListener('click', () => {
    inputLabelPassagem.style.opacity= 0;
    inputIdPassagem.disabled = true;
})

btnAtualizarPassagem.addEventListener('click', () => {
    inputLabelPassagem.style.opacity= 1;
    inputIdPassagem.disabled = false;
})

btnVisualizarPassagem.addEventListener('click', () => {
    inputLabelPassagem.style.opacity= 1;
    inputIdPassagem.disabled = false;
})

btnDeletarPassagem.addEventListener('click', () => {
    inputLabelPassagem.style.opacity= 1;
    inputIdPassagem.disabled = false;
})

//variaveis recebe elementos Formularios hospedagem
const btnCadastrarHospedagem = document.getElementById('btnCadastrarHospedagem');
const btnAtualizarHospedagem = document.getElementById('btnAtualizarHospedagem');
const btnVisualizarHospedagem = document.getElementById('btnVisualizarHospedagem');
const btnDeletarHospedagem = document.getElementById('btnDeletarHospedagem');
let inputIdHospedagem = document.getElementById('idHospedagem');
let inputLabelHospedagem = document.getElementById('labelIdHospedagem');

//Eventos de click
btnCadastrarHospedagem.addEventListener('click', () => {
    inputLabelHospedagem.style.opacity= 0;
    inputIdHospedagem.disabled = true;
})

btnAtualizarHospedagem.addEventListener('click', () => {
    inputLabelHospedagem.style.opacity= 1;
    inputIdHospedagem.disabled = false;
})

btnVisualizarHospedagem.addEventListener('click', () => {
    inputLabelHospedagem.style.opacity= 1;
    inputIdHospedagem.disabled = false;
})

btnDeletarHospedagem.addEventListener('click', () => {
    inputLabelHospedagem.style.opacity= 1;
    inputIdHospedagem.disabled = false;
})