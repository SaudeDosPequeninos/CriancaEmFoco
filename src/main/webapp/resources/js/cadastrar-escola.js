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

function checkSenha() {
    const senha = document.getElementById('senha-user').value;
    const confirmarSenha = document.getElementById('confirmar-senha-user').value;

    if (senha !== confirmarSenha) {
        alert("As senhas não são iguais, por favor, corrija sua senha.");
        return false; 
    }
    return true; 
}

function mostrarProximo(passoAtual, proximoPasso) {
    if (!validar(passoAtual)) {
        return;
    }

    if (!checkSenha()) {
        return;
    }

    document.getElementById(passoAtual).style.display = 'none';
    document.getElementById(proximoPasso).style.display = 'block';
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