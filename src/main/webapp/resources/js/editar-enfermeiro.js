function toggleIco() {
	const senhaInput = document.getElementById('nova-senha-user');
	const olhoAberto = document.getElementById('olho-aberto-novo');
	const olhoFechado = document.getElementById('olho-fechado-novo');
	if (senhaInput.type === 'password') {
			senhaInput.type = 'text';
			olhoFechado.style.display = 'none';
			olhoAberto.style.display = 'inline';
		} else {
			senhaInput.type = 'password';
			olhoFechado.style.display = 'inline';
			olhoAberto.style.display = 'none';
			
		}
}
 
function toggleIcoConfirmarSenha() {
	 const senhaInput = document.getElementById('confirmar-senha-user');
	 const olhoAberto = document.getElementById('olho-aberto-confirmar');
	 const olhoFechado = document.getElementById('olho-fechado-confirmar');
	 if (senhaInput.type === 'password') {
			senhaInput.type = 'text';
			olhoFechado.style.display = 'none';
			olhoAberto.style.display = 'inline';
		} else {
			senhaInput.type = 'password';
			olhoFechado.style.display = 'inline';
			olhoAberto.style.display = 'none';
			
		}
}
 
function checkSenha() {
    const senha = document.getElementById('nova-senha-user').value;
    const confirmarSenha = document.getElementById('confirmar-senha-user').value;
 
    if (senha !== confirmarSenha) {
        alert("As senhas não são iguais, por favor, corrija sua senha.");
        return false;
    }
    return true;
}