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
    document.getElementById(passoAtual).style.display = 'none';
    document.getElementById(proximoPasso).style.display = 'block';
}

function toggleIco() {
    const senhaInput = document.getElementById('senha');
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
    const senhaInput = document.getElementById('confirmar-senha');
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