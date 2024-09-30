function editarTarefa(id){
    let card = document.getElementById(id);
    let titulo = card.querySelector('h2');
    let desc = card.querySelector('p');
    let data = card.querySelector('.dataTarefa');
    let priori = card.querySelector('.quadradoPrioridade');
    let tag = card.querySelector('.tag');
    let stts = card.querySelector('.status');


    card.innerHTML = `
                    <div class="infoTarefa">
                        <div class="descTarefa">
                            <div class="topoTarefa">
                                <input type="text" id="titu" value="${titulo.textContent}">
                                <input type="text" class="quadradoPrioridade" value="${priori.textContent}">
                            </div>
                            <textarea style="height: 70px;">${desc.textContent}</textarea>
                        </div>

                        <div class="baseTarefa">
                            <input class="dataTarefa" type="date" value="${data.value}">
                            <input type="text" class="tagTarefa inputTag tag" value="${tag.textContent}">
                            <input type="text" class="tagTarefa inputTag statusTodo status" value="${stts.textContent}">
                            <button class="botoes" onclick="salvarTarefa(${id})">Salvar</button>
                        </div>
                    </div>`;
}

function salvarTarefa(id){
    let card = document.getElementById(id);
    let titulo = card.querySelector('#titu').value;
    let priori = card.querySelector('.quadradoPrioridade').value;
    let desc = card.querySelector('textarea').value;
    let data = card.querySelector('.dataTarefa').value;
    let tag = card.querySelector('.tag').value;
    let stts = card.querySelector('.statusTodo').value;
    let clsStts = stts == 'To do' ? 'statusTodo' : stts == 'Doing' ? 'statusDoing' :  stts == 'Done' ? 'statusDone' : '';

    let divStts = stts == 'To do' ? 'todo' : stts == 'Doing' ? 'divDoing' :  stts == 'Done' ? 'divDone' : '';
    let cardStts = stts == 'To do' ? 'c-todo' : stts == 'Doing' ? 'doing' :  stts == 'Done' ? 'done' : '';
    
    card.innerHTML = `
                    <div class="infoTarefa">
                        <div class="descTarefa">
                            <div class="topoTarefa">
                                <h2>${titulo}</h2>
                                <h4 class="quadradoPrioridade">
${priori}
                                </h4>
                            </div>
                            <p>
${desc}
                            </p>
                        </div>

                        <div class="baseTarefa">
                            <input class="dataTarefa" type="date" value="${data}" readonly>
                            <div class="tagTarefa tag">${tag}</div>
                            <div class="tagTarefa tagTodo ${clsStts} status">${stts}</div>
                            <button type="button" class="botoes" onclick="editarTarefa(${id})">Editar</button>
                            <button class="botoes" onclick="apagarTarefa(${id})">Apagar</button>
                        </div>
                    </div>
    `;

    let divAtual = card.parentElement;
    if (divAtual.className != divStts){
        document.getElementsByClassName(divStts)[0].appendChild(card);
        card.className = `cardTarefa ${cardStts}`;
        divAtual.removeChild(card);
    }
}

function criarTarefa() {
    let nome = document.getElementById('nome').value;
    let descricao = document.getElementById('desc').value;
    let termino = document.getElementById('termino').value;
    let prioridade = document.getElementById('priori').value;
    let categoria = document.getElementById('categ').value;
    let stts = document.getElementById('opcoes').value;

    let tarefaId = Date.now();
    let cardStts = stts == 'To do' ? 'c-todo' : stts == 'Doing' ? 'doing' :  stts == 'Done' ? 'done' : '';
    let clsStts = stts == 'To do' ? 'statusTodo' : stts == 'Doing' ? 'statusDoing' :  stts == 'Done' ? 'statusDone' : '';


    console.log(clsStts);
    // Cria o HTML da nova tarefa
    novaTarefa = `
        <div class="cardTarefa ${cardStts}" id="${tarefaId}">
            <div class="infoTarefa">
                <div class="descTarefa">
                    <div class="topoTarefa">
                        <h2>${nome}</h2>
                        <h4 class="quadradoPrioridade">${prioridade}</h4>
                    </div>
                    <p>${descricao}</p>
                </div>

                <div class="baseTarefa">
                    <input class="dataTarefa" type="date" value="${termino}" readonly>
                    <div class="tagTarefa tag">${categoria}</div>
                    <div class="tagTarefa tagTodo ${clsStts} status">${stts}</div>
                    <button type="button" class="botoes" onclick="editarTarefa(${tarefaId})">Editar</button>
                    <button class="botoes" onclick="apagarTarefa(${tarefaId})">Apagar</button>
                </div>
            </div>
        </div>
    `;

    let divStts = stts == 'To do' ? 'todo' : stts == 'Doing' ? 'divDoing' :  stts == 'Done' ? 'divDone' : '';
    
    console.log(stts);
    console.log(divStts);
    document.getElementsByClassName(divStts)[0].innerHTML += novaTarefa;

    document.getElementById('nome').value = '';
    document.getElementById('desc').value = '';
    document.getElementById('termino').value = '';
    document.getElementById('priori').value = '';
    document.getElementById('categ').value = '';
    document.getElementById('opcoes').value = 'To do';
}

function apagarTarefa(id) {
    const tarefa = document.getElementById(id);
    tarefa.remove();
}