function daySelection(number){
    const seg = document.getElementById('seg');
    const ter = document.getElementById('ter');
    const qua = document.getElementById('qua');
    const qui = document.getElementById('qui');
    const sex = document.getElementById('sex');

    switch(number){
        case 1:
            seg.style.backgroundColor = '#F2695C'
            ter.style.backgroundColor = '#203A40'
            qua.style.backgroundColor = '#203A40'
            qui.style.backgroundColor = '#203A40'
            sex.style.backgroundColor = '#203A40'
        break;
        case 2:
            ter.style.backgroundColor = '#F2695C'
            seg.style.backgroundColor = '#203A40'
            qua.style.backgroundColor = '#203A40'
            qui.style.backgroundColor = '#203A40'
            sex.style.backgroundColor = '#203A40'
        break;
        case 3:
            qua.style.backgroundColor = '#F2695C'
            ter.style.backgroundColor = '#203A40'
            seg.style.backgroundColor = '#203A40'
            qui.style.backgroundColor = '#203A40'
            sex.style.backgroundColor = '#203A40'
        break;
        case 4:
            qui.style.backgroundColor = '#F2695C'
            qua.style.backgroundColor = '#203A40'
            ter.style.backgroundColor = '#203A40'
            seg.style.backgroundColor = '#203A40'
            sex.style.backgroundColor = '#203A40'
        break;
        case 5:
            sex.style.backgroundColor = '#F2695C'
            qui.style.backgroundColor = '#203A40'
            qua.style.backgroundColor = '#203A40'
            ter.style.backgroundColor = '#203A40'
            seg.style.backgroundColor = '#203A40'
        break;
    }
}

function timeSelection(number){
    const mes = document.getElementById('mes');
    const semana = document.getElementById('semana-day');
    const hoje = document.getElementById('hoje');

    switch(number){
        case 1:
            mes.style.color = '#F2695C'
            semana.style.color = '#203A40'
            hoje.style.color = '#203A40'
        break;
        case 2:
            semana.style.color = '#F2695C'
            mes.style.color = '#203A40'
            hoje.style.color = '#203A40'
        break;
        case 3:
            hoje.style.color = '#F2695C'
            semana.style.color = '#203A40'
            mes.style.color = '#203A40'
        break;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    daySelection(1)
    timeSelection(3)
  });