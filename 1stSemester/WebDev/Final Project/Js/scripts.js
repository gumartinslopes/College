const API_KEY = '764d2979c37c4dd38d605ddd81aba550';
const likeId = 'like'  ;
$("#btn-pesquisa").hover(function(){
    $("#txtPesquisa").show();
});

function colocaNoticias(){
    let tela = document.getElementById('tela');
    
    let texto = '';

    let dados = JSON.parse (this.responseText);
    for (i=0; i < dados.articles.length; i++){
        let noticia = dados.articles[i];
        let data = new Date (noticia.publishedAt);

        

        texto = texto + `
        <article class="conteudo">
                <a href="${noticia.url}"><img src="${noticia.urlToImage}" alt="Imagem da notícia"></a>
                <div class="noticia">
                    <spam class="titulo-noticia" href="#">${noticia.title}<br></spam>
                    <span class="text">
                        ${noticia.content}
                        <a href="${noticia.url}">Leia mais ...</a>
                    </span>
                    <span class="creditos">${data.toLocaleDateString ()} - ${noticia.source.name} - ${noticia.author}</span><br>
                    </div>
            </article>
        `;
           
    };
    tela.innerHTML = texto;
    

}


function exibeNoticias(){
    let tela = document.getElementById('tela');
    let texto = '';

    let dados = JSON.parse (this.responseText);
    for (i=0; i < dados.articles.length; i++){
        let noticia = dados.articles[i];
        let data = new Date (noticia.publishedAt);

        texto = texto + `
        <article class="conteudo">
                <a href="${noticia.url}"><img src="${noticia.urlToImage}" alt="Imagem da notícia"></a>
                <div class="noticia">
                    <spam class="titulo-noticia" href="#">${noticia.title}<br></spam>
                    <span class="text">
                        ${noticia.content}
                        <a href="${noticia.url}">Leia mais ...</a>
                    </span>
                    <span class="creditos">${data.toLocaleDateString ()} - ${noticia.source.name} - ${noticia.author}</span><br>
                    <a href="#">Leia mais ...</a>
                    <span  id="like-btn"><i id = "${likeId}" class="far fa-heart"></i></span>
                </div>
                
            </article>
        `;
    };
    tela.innerHTML = texto;
}

function preparaSite(){
    let XHR = new XMLHttpRequest ();
    XHR.onload = colocaNoticias;
    XHR.open ('GET', `http://newsapi.org/v2/top-headlines?country=br&apiKey=764d2979c37c4dd38d605ddd81aba550`);
    XHR.send ();
}

function executaPesquisa () {
    let query = document.getElementById('txtPesquisa').value;
    
    let xhr = new XMLHttpRequest ();
    xhr.onload = exibeNoticias;
    xhr.open ('GET', `http://newsapi.org/v2/everything?q=${query}&apiKey=${API_KEY}`);
    xhr.send ();
}
function pesquisaFavorito() {
    let query2 = document.getElementById('').value;
    
    let xhr = new XMLHttpRequest ();
    xhr.onload = exibeNoticias;
    xhr.open ('GET', `http://newsapi.org/v2/everything?q=${query}&apiKey=${API_KEY}`);
    xhr.send ();
}

document.onload = preparaSite();
document.getElementById ('btn-pesquisa').addEventListener ('click', executaPesquisa);

//botão de like
let botaoDeLike = document.querySelector('#like');

function like(){
    if(botaoDeLike.classList.contains("far")){
        botaoDeLike.classList.remove("far");
        botaoDeLike.classList.add("fas");
    }
    botaoDeLike.style.color = "#f50057";
    alert ('clicou');
    
}

botaoDeLike.addEventListener('click', like);


function salva(){
    alert('Pesquisa salva com sucesso!');
    var favoritos = document.querySelector('.favoritos');
    let pesquisaSalva =  document.querySelector('#txtPesquisa').value;
    localStorage.setItem('pesquisaSalva', pesquisaSalva);
    
    let salvos = `<li><a class="salvo" href="https://www.google.com/search?q=${pesquisaSalva}&rlz=1C1NDCM_pt-BRBR841BR841&oq=${pesquisaSalva}&aqs=chrome..69i57j0l7.2880j0j7&sourceid=chrome&ie=UTF-8" id="${pesquisaSalva}">${pesquisaSalva}<span  id="like-btn"><i id = "like" class="far fa-heart"></i></span></li>`;

    favoritos.innerHTML = salvos + favoritos.innerHTML; 
}
var botaoDeSalvar = document.querySelector('.salvarPesquisa');

botaoDeSalvar.addEventListener('click', salva);









