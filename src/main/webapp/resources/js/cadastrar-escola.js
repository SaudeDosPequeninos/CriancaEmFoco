function validar(passo) {
    const camposObrigatorios = document.querySelectorAll(`#${passo} input[required]`);
    let todosPreenchidos = true;

    camposObrigatorios.forEach(campo => {
        if (!campo.value.trim()) {
            todosPreenchidos = false;
            campo.classList.add("campo-invalido");
        } else {
            campo.classList.remove("campo-invalido");
        }
    });

    return todosPreenchidos;
}

function mostrarProximo(passoAtual, proximoPasso) {
    if (validar(passoAtual)) {
        document.getElementById(passoAtual).style.display = 'none';
        document.getElementById(proximoPasso).style.display = 'block';
    }
}

function toggleIco() {
    const senhaInput = document.getElementById('senha-user');
    const olhoFechado = document.getElementById('olho-fechado');
    const olhoAberto = document.getElementById('olho-aberto');
    if (senhaInput.type === 'password') {
        senhaInput.type = 'text';
        olhoFechado.style.display = 'inline';
        olhoAberto.style.display = 'none';
    } else {
        senhaInput.type = 'password';
        olhoFechado.style.display = 'none';
        olhoAberto.style.display = 'inline';
    }
}

function toggleIcoConfirmarSenha() {
    const senhaInput = document.getElementById('confirmar-senha-user');
    const olhoFechado = document.getElementById('olho-fechado-confirmar');
    const olhoAberto = document.getElementById('olho-aberto-confirmar');
    if (senhaInput.type === 'password') {
        senhaInput.type = 'text';
        olhoFechado.style.display = 'inline';
        olhoAberto.style.display = 'none';
    } else {
        senhaInput.type = 'password';
        olhoFechado.style.display = 'none';
        olhoAberto.style.display = 'inline';
    }
}

function toggleIcoBaixo() {
    const setaBaixo = document.getElementById('tipos-procedimento-seta');
    const setaCima = document.getElementById('seta-cima');
    const tipoProcedimentoSelect = document.getElementById('tipos-procedimento-user');

    tipoProcedimentoSelect.addEventListener('focus', function() {
            setaBaixo.style.display = 'none';
            setaCima.style.display = 'inline';
    });

    tipoProcedimentoSelect.addEventListener('focusout', function() {
            setaBaixo.style.display = 'inline';
            setaCima.style.display = 'none';
    });
}

document.addEventListener('DOMContentLoaded', function() {
    toggleIcoBaixo();
});