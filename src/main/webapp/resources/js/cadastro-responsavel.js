let section

function goToSection(number){

  const titulo1 = document.getElementById('title-1');
  const titulo2 = document.getElementById('title-2');
  const titulo3 = document.getElementById('title-3');

  const section1 = document.getElementById('section1')
  const section2 = document.getElementById('section2')
  const section3 = document.getElementById('section3')

  const number1 = document.getElementById('number-1');
  const number2 = document.getElementById('number-2');
  const number3 = document.getElementById('number-3');

  const buttonSubmit = document.getElementById('submit');
  const buttonBack = document.getElementById('back');

  switch (number) {
    case 1:
        titulo1.style.display = 'flex'
        titulo2.style.display = 'none'
        titulo3.style.display = 'none'

        section1.style.display = 'flex'
        section2.style.display = 'none'
        section3.style.display = 'none'

        number1.style.backgroundColor = '#F2695C'
        number2.style.backgroundColor = 'transparent'
        number3.style.backgroundColor = 'transparent'
        buttonSubmit.innerText = "AVANÇAR";
        buttonBack.style.display = 'none'
        section = 1;
      break;
  
      case 2:
        titulo1.style.display = 'none'
        titulo2.style.display = 'flex'
        titulo3.style.display = 'none'

        section1.style.display = 'none'
        section2.style.display = 'flex'
        section3.style.display = 'none'

        number1.style.backgroundColor = 'transparent'
        number2.style.backgroundColor = '#F2695C'
        number3.style.backgroundColor = 'transparent'
        buttonSubmit.innerText = "AVANÇAR";
        buttonBack.style.display = 'block'
        section = 2;
        break;

        case 3:
          titulo1.style.display = 'none'
          titulo2.style.display = 'none'
          titulo3.style.display = 'flex'

          section1.style.display = 'none'
          section2.style.display = 'none'
          section3.style.display = 'flex'

          number1.style.backgroundColor = 'transparent'
          number2.style.backgroundColor = 'transparent'
          number3.style.backgroundColor = '#F2695C'

          buttonSubmit.innerText = "CONFIRMAR";
          buttonBack.style.display = 'block'
          section = 3;
          break;
        
    default:
      break;
  }

}

const inputCpf = document.getElementById("cpf-user");

    inputCpf.addEventListener("input", () => {
      let cpf = inputCpf.value.replace(/\D/g, ""); 
      if (cpf.length > 11) cpf = cpf.slice(0, 11); 

      if (cpf.length > 3 && cpf.length <= 6) {
        cpf = cpf.replace(/^(\d{3})(\d+)/, "$1.$2");
      } else if (cpf.length > 6 && cpf.length <= 9) {
        cpf = cpf.replace(/^(\d{3})(\d{3})(\d+)/, "$1.$2.$3");
      } else if (cpf.length > 9) {
        cpf = cpf.replace(/^(\d{3})(\d{3})(\d{3})(\d{1,2})/, "$1.$2.$3-$4");
      }

      inputCpf.value = cpf;
    });

    const inputTelefone = document.getElementById("telefone-user");

    inputTelefone.addEventListener("input", () => {
      let telefone = inputTelefone.value.replace(/\D/g, ""); 
      if (telefone.length > 11) telefone = telefone.slice(0, 11);

      if (telefone.length > 2 && telefone.length <= 7) {
        telefone = telefone.replace(/^(\d{2})(\d+)/, "($1) $2");
      } else if (telefone.length > 7) {
        telefone = telefone.replace(/^(\d{2})(\d{5})(\d+)/, "($1) $2-$3");
      }

      inputTelefone.value = telefone;
    });    

    document.addEventListener("DOMContentLoaded", () => {
      goToSection(1);
    });

    function voltar(){
      if(section > 1){
        section --;
        goToSection(section);
      }
    }

    function avancar(){
      if(section<3){
        section ++;
        goToSection(section);
      }
    }