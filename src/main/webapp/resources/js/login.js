function verSenha(){
    const input = document.getElementById("senha-user");
    const botao = document.getElementById("olhos");

    if(input.type === "password"){
        input.type = "text";
        botao.src = "/CriancaEmFoco/resources/imagens/login/main/form/olho-aberto.svg"
    }else{
        input.type = "password";
        botao.src = "/CriancaEmFoco/resources/imagens/login/main/form/olho-fechado.svg"
    }
}