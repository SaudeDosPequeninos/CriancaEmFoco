<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-BR">

<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Cadastrar Aluno</title>

    <link ref="stylesheet" href="CadastrarAluno.css">
</head>

<body>

    <header>
        <nav>
            <div class="nav-counteiner">
                <div class="header-form">
                    <a href="" class="hamburguer-sidebar">
                        <svg width="53" height="36" viewBox="0 0 53 36" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M1.27083 0.00011251C1.12112 -0.00199578 0.972491 0.025545 0.833569 0.0811351C0.694648 0.136725 0.568206 0.219256 0.461594 
                                0.32393C0.354981 0.428605 0.270323 0.553335 0.21254 0.690874C0.154756 0.828412 0.125 0.976016 0.125 1.12511C0.125 1.2742 0.154756 
                                1.4218 0.21254 1.55934C0.270323 1.69688 0.354981 1.82161 0.461594 1.92628C0.568206 2.03096 0.694648 2.11349 0.833569 2.16908C0.972491 
                                2.22467 1.12112 2.25221 1.27083 2.2501H50.9792C51.1289 2.25221 51.2775 2.22467 51.4164 2.16908C51.5553 2.11349 51.6818 2.03096 51.7884 
                                1.92628C51.895 1.82161 51.9797 1.69688 52.0375 1.55934C52.0952 1.4218 52.125 1.2742 52.125 1.12511C52.125 0.976016 52.0952 0.828412 
                                52.0375 0.690874C51.9797 0.553335 51.895 0.428605 51.7884 0.32393C51.6818 0.219256 51.5553 0.136725 51.4164 0.0811351C51.2775 0.025545 
                                51.1289 -0.00199578 50.9792 0.00011251H1.27083ZM1.27083 16.875C1.12112 16.8729 0.972491 16.9004 0.833569 16.956C0.694648 17.0116 
                                0.568206 17.0942 0.461594 17.1988C0.354981 17.3035 0.270323 17.4282 0.21254 17.5658C0.154756 17.7033 0.125 17.8509 0.125 18C0.125 
                                18.1491 0.154756 18.2967 0.21254 18.4342C0.270323 18.5718 0.354981 18.6965 0.461594 18.8012C0.568206 18.9058 0.694648 18.9884 0.833569 
                                19.044C0.972491 19.0996 1.12112 19.1271 1.27083 19.125H50.9792C51.1289 19.1271 51.2775 19.0996 51.4164 19.044C51.5553 18.9884 51.6818 
                                18.9058 51.7884 18.8012C51.895 18.6965 51.9797 18.5718 52.0375 18.4342C52.0952 18.2967 52.125 18.1491 52.125 18C52.125 17.8509 52.0952 
                                17.7033 52.0375 17.5658C51.9797 17.4282 51.895 17.3035 51.7884 17.1988C51.6818 17.0942 51.5553 17.0116 51.4164 16.956C51.2775 16.9004 
                                51.1289 16.8729 50.9792 16.875H1.27083ZM1.27083 33.7499C1.12112 33.7478 0.972491 33.7753 0.833569 33.8309C0.694648 33.8865 0.568206 33.969 
                                0.461594 34.0737C0.354981 34.1784 0.270323 34.3031 0.21254 34.4407C0.154756 34.5782 0.125 34.7258 0.125 34.8749C0.125 35.024 0.154756 35.1716 
                                0.21254 35.3091C0.270323 35.4467 0.354981 35.5714 0.461594 35.6761C0.568206 35.7807 0.694648 35.8633 0.833569 35.9189C0.972491 35.9744 1.12112 
                                36.002 1.27083 35.9999H50.9792C51.1289 36.002 51.2775 35.9744 51.4164 35.9189C51.5553 35.8633 51.6818 35.7807 51.7884 35.6761C51.895 35.5714 
                                51.9797 35.4467 52.0375 35.3091C52.0952 35.1716 52.125 35.024 52.125 34.8749C52.125 34.7258 52.0952 34.5782 52.0375 34.4407C51.9797 34.3031 
                                51.895 34.1784 51.7884 34.0737C51.6818 33.969 51.5553 33.8865 51.4164 33.8309C51.2775 33.7753 51.1289 33.7478 50.9792 33.7499H1.27083Z"
                                fill="#F2695C" />
                        </svg>
                    </a>
                        <a href="" id="home-button">
                            <svg width="53" height="50" viewBox="0 0 53 50" fill="none"
                                xmlns="http://www.w3.org/2000/svg">
                                <path d="M26.086 0.000846104C25.8587 0.00868961 25.6395 0.0879047 25.4597 0.227246L0.542501 19.6706C0.0703849 20.0387 -0.013922 20.7198 0.354181 
                                    21.1919C0.722284 21.664 1.40342 21.7483 1.87554 21.3802L3.37574 20.2101V48.6927C3.37581 49.291 3.8608 49.776 4.4591 49.7761H19.4441C19.5611 
                                    49.7954 19.6805 49.7954 19.7975 49.7761H32.4444C32.5614 49.7954 32.6808 49.7954 32.7978 49.7761H47.7934C48.3917 49.776 48.8767 49.291 48.8768 
                                    48.6927V20.2101L50.377 21.3802C50.6824 21.6184 51.0916 21.6755 51.4506 21.5301C51.8095 21.3847 52.0636 21.0588 52.1171 20.6752C52.1706 20.2916 
                                    52.0154 19.9087 51.71 19.6706L43.46 13.2339V5.35838H36.9598V8.15988L26.7928 0.227246C26.5912 0.0709393 26.3409 -0.00922912 26.086 
                                    0.000846104ZM26.1262 2.45745L46.71 18.5195V47.6093H33.7097V27.0255H18.5427V47.6093H5.54244V18.5195L26.1262 2.45745ZM39.1265 7.5251H41.2932V11.5433L39.1265 
                                    9.8505V7.5251ZM20.7094 29.1922H31.543V47.6093H20.7094V29.1922Z" fill="#F2695C" />
                            </svg>

                        </a>
                        <script src="CadastrarAlunoScript.js"></script>

                        <h1>Passo 1 - Informações Básicas</h1>

        </nav>
    </header>

    <main>

        <form action="inserir-aluno" method="post">

            <div>

                <div class="form user">
                    <div class="separator-form">
                        <div id="left-side-form" class="side-form">
                            <div class="div-form">
                                <label for="nome-user">Nome</label>
                                <div class="element-form">
                                    <svg width="31" height="30" viewBox="0 0 31 30" fill="none"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M30.3753 27.6407C28.174 23.8351 24.7819 21.1064 20.8232 19.8128C22.7813 18.6471 24.3027 16.8709 25.1537 
                                            14.7568C26.0046 12.6428 26.1381 10.3079 25.5335 8.11066C24.929 5.91343 23.62 3.97538 21.8074 2.59414C19.9948 
                                            1.2129 17.779 0.464844 15.5001 0.464844C13.2212 0.464844 11.0054 1.2129 9.19279 2.59414C7.38022 3.97538 6.07117 
                                            5.91343 5.46666 8.11066C4.86215 10.3079 4.99561 12.6428 5.84655 14.7568C6.69749 16.8709 8.21886 18.6471 10.177 
                                            19.8128C6.2183 21.1049 2.82616 23.8337 0.624945 27.6407C0.544223 27.7723 0.49068 27.9187 0.467477 28.0714C0.444273 
                                            28.224 0.451878 28.3798 0.489844 28.5294C0.527809 28.6791 0.595365 28.8197 0.688527 28.9428C0.781689 29.0659 0.898568 
                                            29.1691 1.03227 29.2464C1.16597 29.3236 1.31379 29.3733 1.467 29.3924C1.6202 29.4116 1.7757 29.3999 1.92431 29.358C2.07292 
                                            29.3161 2.21164 29.2449 2.33227 29.1485C2.45291 29.0521 2.55302 28.9326 2.6267 28.7969C5.34967 24.091 10.1626 21.2813 
                                            15.5001 21.2813C20.8376 21.2813 25.6505 24.091 28.3735 28.7969C28.4472 28.9326 28.5473 29.0521 28.6679 29.1485C28.7886 
                                            29.2449 28.9273 29.3161 29.0759 29.358C29.2245 29.3999 29.38 29.4116 29.5332 29.3924C29.6864 29.3733 29.8342 29.3236 
                                            29.9679 29.2464C30.1016 29.1691 30.2185 29.0659 30.3117 28.9428C30.4048 28.8197 30.4724 28.6791 30.5104 28.5294C30.5483 
                                            28.3798 30.5559 28.224 30.5327 28.0714C30.5095 27.9187 30.456 27.7723 30.3753 27.6407ZM7.40635 10.875C7.40635 9.27423 
                                            7.88104 7.70939 8.77039 6.37838C9.65975 5.04737 10.9238 4.00997 12.4028 3.39738C13.8817 2.78478 15.5091 2.6245 17.0791 
                                            2.93679C18.6491 3.24909 20.0913 4.01995 21.2232 5.15188C22.3552 6.28381 23.126 7.72598 23.4383 9.29601C23.7506 10.866 
                                            23.5903 12.4934 22.9778 13.9724C22.3652 15.4513 21.3278 16.7154 19.9967 17.6047C18.6657 18.4941 17.1009 18.9688 15.5001 
                                            18.9688C13.3542 18.9665 11.2969 18.113 9.77949 16.5956C8.26212 15.0783 7.40865 13.0209 7.40635 10.875Z"
                                            fill="#F2695C" />
                                    </svg>
                                    <input type="text" id="nome-user" name="nome-user" placeholder="Nome">
                                </div>
                            </div>
                            <div class="div-form">
                                <label for="cpf-user">CPF</label>
                                <div class="element-form">
                                    <svg width="33" height="27" viewBox="0 0 33 27" fill="none"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M26.9062 10.8906C26.9062 11.0605 26.8388 11.2235 26.7186 11.3436C26.5985 11.4638 26.4355 11.5312 26.2656 11.5312H19.8594C19.6895 
                                            11.5312 19.5265 11.4638 19.4064 11.3436C19.2862 11.2235 19.2188 11.0605 19.2188 10.8906C19.2188 10.7207 19.2862 10.5578 19.4064 
                                            10.4376C19.5265 10.3175 19.6895 10.25 19.8594 10.25H26.2656C26.4355 10.25 26.5985 10.3175 26.7186 10.4376C26.8388 10.5578 26.9062 
                                            10.7207 26.9062 10.8906ZM26.2656 15.375H19.8594C19.6895 15.375 19.5265 15.4425 19.4064 15.5626C19.2862 15.6828 19.2188 15.8457 
                                            19.2188 16.0156C19.2188 16.1855 19.2862 16.3485 19.4064 16.4686C19.5265 16.5888 19.6895 16.6562 19.8594 16.6562H26.2656C26.4355 
                                            16.6562 26.5985 16.5888 26.7186 16.4686C26.8388 16.3485 26.9062 16.1855 26.9062 16.0156C26.9062 15.8457 26.8388 15.6828 26.7186 
                                            15.5626C26.5985 15.4425 26.4355 15.375 26.2656 15.375ZM32.0312 1.92188V24.9844C32.0312 25.4941 31.8288 25.9829 31.4683 26.3433C31.1079 
                                            26.7038 30.6191 26.9062 30.1094 26.9062H1.92188C1.41216 26.9062 0.923326 26.7038 0.562904 26.3433C0.202483 25.9829 0 25.4941 0 
                                            24.9844V1.92188C0 1.41216 0.202483 0.923325 0.562904 0.562904C0.923326 0.202482 1.41216 0 1.92188 0H30.1094C30.6191 0 31.1079 
                                            0.202482 31.4683 0.562904C31.8288 0.923325 32.0312 1.41216 32.0312 1.92188ZM30.75 1.92188C30.75 1.75197 30.6825 1.58903 30.5624 
                                            1.46888C30.4422 1.34874 30.2793 1.28125 30.1094 1.28125H1.92188C1.75197 1.28125 1.58903 1.34874 1.46888 1.46888C1.34874 1.58903 
                                            1.28125 1.75197 1.28125 1.92188V24.9844C1.28125 25.1543 1.34874 25.3172 1.46888 25.4374C1.58903 25.5575 1.75197 25.625 1.92188 
                                            25.625H30.1094C30.2793 25.625 30.4422 25.5575 30.5624 25.4374C30.6825 25.3172 30.75 25.1543 30.75 24.9844V1.92188ZM16.6354 
                                            19.6992C16.6601 19.7818 16.6679 19.8685 16.6584 19.9541C16.6488 20.0398 16.622 20.1226 16.5797 20.1977C16.5374 20.2727 16.4803 
                                            20.3385 16.412 20.391C16.3437 20.4435 16.2654 20.4816 16.182 20.5032C16.0985 20.5248 16.0116 20.5293 15.9264 20.5164C15.8412 
                                            20.5036 15.7594 20.4737 15.686 20.4286C15.6126 20.3834 15.5491 20.3239 15.4992 20.2536C15.4494 20.1833 15.4142 20.1037 15.3958 
                                            20.0195C14.9041 18.0977 12.9727 16.6562 10.8906 16.6562C8.80859 16.6562 6.88672 18.0977 6.38543 20.0195C6.34994 20.157 6.26982 
                                            20.2787 6.15764 20.3657C6.04545 20.4527 5.90757 20.4999 5.76562 20.5C5.71158 20.4998 5.65776 20.4928 5.60547 20.4792C5.44115 
                                            20.4366 5.30046 20.3305 5.21427 20.1843C5.12809 20.0381 5.10347 19.8636 5.14582 19.6992C5.37426 18.8636 5.78664 18.0897 6.35277 
                                            17.4341C6.9189 16.7785 7.62446 16.2577 8.41781 15.9099C7.61365 15.3784 7.00218 14.6018 6.67405 13.6954C6.34592 12.789 6.31859 11.801 
                                            6.59612 10.8779C6.87365 9.95474 7.44126 9.14559 8.21481 8.5704C8.98836 7.9952 9.92666 7.68458 10.8906 7.68458C11.8546 7.68458 12.7929 
                                            7.9952 13.5664 8.5704C14.34 9.14559 14.9076 9.95474 15.1851 10.8779C15.4627 11.801 15.4353 12.789 15.1072 13.6954C14.7791 14.6018 
                                            14.1676 15.3784 13.3634 15.9099C14.1573 16.2569 14.8633 16.7774 15.4295 17.4332C15.9958 18.0889 16.4078 18.8633 16.6354 19.6992ZM10.8906 
                                            15.375C11.5241 15.375 12.1434 15.1871 12.6702 14.8352C13.1969 14.4832 13.6075 13.983 13.8499 13.3977C14.0924 12.8124 14.1558 12.1683 
                                            14.0322 11.547C13.9086 10.9256 13.6035 10.3549 13.1556 9.90692C12.7076 9.45896 12.1369 9.15389 11.5155 9.0303C10.8942 8.9067 10.2501 
                                            8.97014 9.66484 9.21257C9.07955 9.45501 8.57929 9.86556 8.22732 10.3923C7.87536 10.9191 7.6875 11.5384 7.6875 12.1719C7.6875 13.0214 
                                            8.02497 13.8361 8.62567 14.4368C9.22638 15.0375 10.0411 15.375 10.8906 15.375Z"
                                            fill="#F2695C" />
                                    </svg>
                                    <input type="text" id="cpf-user" name="cpf-user" placeholder="Insira o CPF">
                                </div>
                            </div>
                        </div>
                        <div id="right-side-form" class="side-form">
                            <div class="div-form">
                                <label for="sobrenome-user">Sobrenome</label>
                                <div class="element-form">
                                    <svg width="31" height="30" viewBox="0 0 31 30" fill="none"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M30.3751 27.6407C28.1739 23.8351 24.7818 21.1064 20.8231 19.8128C22.7812 18.6471 24.3026 16.8709 25.1535 14.7568C26.0045 12.6428 
                                            26.1379 10.3079 25.5334 8.11066C24.9289 5.91343 23.6199 3.97538 21.8073 2.59414C19.9947 1.2129 17.7788 0.464844 15.5 0.464844C13.2211 
                                            0.464844 11.0052 1.2129 9.19267 2.59414C7.3801 3.97538 6.07104 5.91343 5.46653 8.11066C4.86202 10.3079 4.99549 12.6428 5.84643 
                                            14.7568C6.69737 16.8709 8.21874 18.6471 10.1769 19.8128C6.21818 21.1049 2.82603 23.8337 0.624823 27.6407C0.544101 27.7723 0.490558 
                                            27.9187 0.467355 28.0714C0.444151 28.224 0.451756 28.3798 0.489721 28.5294C0.527687 28.6791 0.595243 28.8197 0.688405 28.9428C0.781567 
                                            29.0659 0.898446 29.1691 1.03215 29.2464C1.16585 29.3236 1.31367 29.3733 1.46687 29.3924C1.62008 29.4116 1.77558 29.3999 1.92419 
                                            29.358C2.0728 29.3161 2.21152 29.2449 2.33215 29.1485C2.45279 29.0521 2.5529 28.9326 2.62658 28.7969C5.34955 24.091 10.1624 21.2813 
                                            15.5 21.2813C20.8375 21.2813 25.6504 24.091 28.3734 28.7969C28.4471 28.9326 28.5472 29.0521 28.6678 29.1485C28.7884 29.2449 28.9272 
                                            29.3161 29.0758 29.358C29.2244 29.3999 29.3799 29.4116 29.5331 29.3924C29.6863 29.3733 29.8341 29.3236 29.9678 29.2464C30.1015 29.1691 
                                            30.2184 29.0659 30.3116 28.9428C30.4047 28.8197 30.4723 28.6791 30.5102 28.5294C30.5482 28.3798 30.5558 28.224 30.5326 28.0714C30.5094 
                                            27.9187 30.4559 27.7723 30.3751 27.6407ZM7.40623 10.875C7.40623 9.27423 7.88092 7.70939 8.77027 6.37838C9.65962 5.04737 10.9237 4.00997 
                                            12.4026 3.39738C13.8816 2.78478 15.509 2.6245 17.079 2.93679C18.649 3.24909 20.0912 4.01995 21.2231 5.15188C22.3551 6.28381 23.1259 
                                            7.72598 23.4382 9.29601C23.7505 10.866 23.5902 12.4934 22.9776 13.9724C22.365 15.4513 21.3276 16.7154 19.9966 17.6047C18.6656 18.4941 
                                            17.1008 18.9688 15.5 18.9688C13.3541 18.9665 11.2967 18.113 9.77937 16.5956C8.26199 15.0783 7.40852 13.0209 7.40623 10.875Z"
                                            fill="#F2695C" />
                                    </svg>

                                    <input type="text" id="sobrenome-user" name="sobrenome-user"
                                        placeholder="Sobrenome">
                                </div>
                            </div>
                            <div class="div-form">
                                <label for="date-bday-user">Data de Nascimento</label>
                                <div class="element-form">
                                    <svg width="33" height="33" viewBox="0 0 33 33" fill="none"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M29 6.25H4.5C2.567 6.25 1 7.817 1 9.75V29C1 30.933 2.567 32.5 4.5 32.5H29C30.933 32.5 32.5 30.933 32.5 29V9.75C32.5 7.817 30.933 6.25 29 6.25Z"
                                            stroke="#F2695C" />
                                        <path
                                            d="M1 13.25C1 9.9495 1 8.301 2.0255 7.2755C3.051 6.25 4.6995 6.25 8 6.25H25.5C28.8005 6.25 30.449 6.25 31.4745 7.2755C32.5 8.301 32.5 9.9495 32.5 13.25H1Z"
                                            fill="#F2695C" />
                                        <path d="M8 1V6.25M25.5 1V6.25" stroke="#F2695C" stroke-linecap="round" />
                                        <path
                                            d="M14.125 16.75H8.875C8.39175 16.75 8 17.1418 8 17.625V19.375C8 19.8582 8.39175 20.25 8.875 20.25H14.125C14.6082 20.25 15 19.8582 15 19.375V17.625C15 17.1418 14.6082 16.75 14.125 16.75Z"
                                            fill="#F2695C" />
                                        <path
                                            d="M14.125 23.75H8.875C8.39175 23.75 8 24.1418 8 24.625V26.375C8 26.8582 8.39175 27.25 8.875 27.25H14.125C14.6082 27.25 15 26.8582 15 26.375V24.625C15 24.1418 14.6082 23.75 14.125 23.75Z"
                                            fill="#F2695C" />
                                        <path
                                            d="M24.625 16.75H19.375C18.8918 16.75 18.5 17.1418 18.5 17.625V19.375C18.5 19.8582 18.8918 20.25 19.375 20.25H24.625C25.1082 20.25 25.5 19.8582 25.5 19.375V17.625C25.5 17.1418 25.1082 16.75 24.625 16.75Z"
                                            fill="#F2695C" />
                                        <path
                                            d="M24.625 23.75H19.375C18.8918 23.75 18.5 24.1418 18.5 24.625V26.375C18.5 26.8582 18.8918 27.25 19.375 27.25H24.625C25.1082 27.25 25.5 26.8582 25.5 26.375V24.625C25.5 24.1418 25.1082 23.75 24.625 23.75Z"
                                            fill="#F2695C" />
                                    </svg>
                                    <input type="date" id="date-bday-user" name="data-nascimento-user"
                                        placeholder="DD/MM/AAAA">
                                </div>
                                <button type="submit" class="button-avancar">AVANÇAR</button>
                                <h1>Passo 2 - Informações Adicionais e Senha</h1>
                                <div class="div-form">
                                    <label for="id-aluno">ID Aluno</label>
                                    <div class="element-form">
                                        <svg width="24" height="30" viewBox="0 0 24 30" fill="none"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M14.6297 20.4492C15.5736 19.8754 16.3039 19.0086 16.7093 17.9811C17.1147 16.9535 17.1728 15.8215 16.8749 14.7578C16.5769 13.6941 15.9393 12.7571 15.0591 
                                                12.0896C14.179 11.4221 13.1046 11.0608 12 11.0608C10.8954 11.0608 9.82104 11.4221 8.94089 12.0896C8.06074 12.7571 7.42306 13.6941 7.12512 14.7578C6.82718 
                                                15.8215 6.88533 16.9535 7.29069 17.9811C7.69606 19.0086 8.4264 19.8754 9.37031 20.4492C7.54284 21.0048 5.94123 22.1309 4.8 23.6625C4.71049 23.7818 4.67206 
                                                23.9319 4.69315 24.0795C4.71425 24.2272 4.79315 24.3605 4.9125 24.45C5.03185 24.5395 5.18187 24.5779 5.32955 24.5568C5.47723 24.5357 5.61049 24.4568 5.7 
                                                24.3375C6.43353 23.3595 7.38471 22.5656 8.47819 22.0189C9.57168 21.4721 10.7774 21.1875 12 21.1875C13.2226 21.1875 14.4283 21.4721 15.5218 22.0189C16.6153 
                                                22.5656 17.5665 23.3595 18.3 24.3375C18.3443 24.3966 18.3998 24.4464 18.4634 24.484C18.527 24.5217 18.5973 24.5464 18.6705 24.5568C18.7436 24.5673 18.818 
                                                24.5632 18.8896 24.5449C18.9612 24.5266 19.0284 24.4943 19.0875 24.45C19.1466 24.4057 19.1964 24.3502 19.234 24.2866C19.2717 24.223 19.2964 24.1527 19.3068 
                                                24.0795C19.3173 24.0064 19.3132 23.932 19.2949 23.8604C19.2766 23.7888 19.2443 23.7216 19.2 23.6625C18.0584 22.1312 16.4569 21.0053 14.6297 20.4492ZM8.0625 
                                                16.125C8.0625 15.3462 8.29343 14.585 8.72609 13.9374C9.15875 13.2899 9.7737 12.7852 10.4932 12.4872C11.2127 12.1892 12.0044 12.1112 12.7682 12.2632C13.532 
                                                12.4151 14.2336 12.7901 14.7842 13.3408C15.3349 13.8914 15.7099 14.593 15.8618 15.3568C16.0138 16.1206 15.9358 16.9123 15.6378 17.6318C15.3398 18.3513 14.8351 
                                                18.9663 14.1876 19.3989C13.54 19.8316 12.7788 20.0625 12 20.0625C10.9557 20.0625 9.95419 19.6477 9.21577 18.9092C8.47734 18.1708 8.0625 17.1693 8.0625 
                                                16.125ZM22.125 0.9375H1.875C1.42745 0.9375 0.998225 1.11529 0.681757 1.43176C0.365289 1.74822 0.1875 2.17745 0.1875 2.625V27.375C0.1875 27.8226 0.365289 
                                                28.2518 0.681757 28.5682C0.998225 28.8847 1.42745 29.0625 1.875 29.0625H22.125C22.5726 29.0625 23.0018 28.8847 23.3182 28.5682C23.6347 28.2518 23.8125 27.8226 
                                                23.8125 27.375V2.625C23.8125 2.17745 23.6347 1.74822 23.3182 1.43176C23.0018 1.11529 22.5726 0.9375 22.125 0.9375ZM22.6875 27.375C22.6875 27.5242 22.6282 27.6673 
                                                22.5227 27.7727C22.4173 27.8782 22.2742 27.9375 22.125 27.9375H1.875C1.72582 27.9375 1.58274 27.8782 1.47725 27.7727C1.37176 27.6673 1.3125 27.5242 1.3125 
                                                27.375V2.625C1.3125 2.47582 1.37176 2.33274 1.47725 2.22725C1.58274 2.12176 1.72582 2.0625 1.875 2.0625H22.125C22.2742 2.0625 22.4173 2.12176 22.5227 
                                                2.22725C22.6282 2.33274 22.6875 2.47582 22.6875 2.625V27.375ZM6.9375 6C6.9375 5.85082 6.99676 5.70774 7.10225 5.60225C7.20774 5.49676 7.35082 5.4375 7.5 
                                                5.4375H16.5C16.6492 5.4375 16.7923 5.49676 16.8977 5.60225C17.0032 5.70774 17.0625 5.85082 17.0625 6C17.0625 6.14918 17.0032 6.29226 16.8977 6.39775C16.7923 
                                                6.50324 16.6492 6.5625 16.5 6.5625H7.5C7.35082 6.5625 7.20774 6.50324 7.10225 6.39775C6.99676 6.29226 6.9375 6.14918 6.9375 6Z"
                                                fill="#F2695C" />
                                        </svg>
                                        <input type="text" id="id-aluno" name="id-aluno"
                                            placeholder="Digite o ID do Aluno">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <label for="ID Aluno"></label>
                <div class="div-form">
                    <label for="senha">Senha</label>
                    <div class="element-form">
                        <svg width="29" height="34" viewBox="0 0 29 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M14.9393 22.5C14.9393 23.0967 14.7209 23.669 14.3321 24.091C13.9433 24.5129 13.416 24.75 12.8662 24.75C12.3164 24.75 11.7891 24.5129 11.4003 24.091C11.0115 23.669 10.7931 
                                    23.0967 10.7931 22.5C10.7931 21.9033 11.0115 21.331 11.4003 20.909C11.7891 20.4871 12.3164 20.25 12.8662 20.25C13.416 20.25 13.9433 20.4871 14.3321 20.909C14.7209 21.331 14.9393 
                                    21.9033 14.9393 22.5ZM18.049 6.1875C18.049 4.84484 18.5404 3.55717 19.4152 2.60777C20.2899 1.65837 21.4763 1.125 22.7134 1.125C23.9505 1.125 25.137 1.65837 26.0117 2.60777C26.8865 
                                    3.55717 27.3779 4.84484 27.3779 6.1875V8.4375C27.3779 8.58668 27.4325 8.72976 27.5297 8.83525C27.6269 8.94074 27.7587 9 27.8962 9C28.0337 9 28.1655 8.94074 28.2627 8.83525C28.3599 
                                    8.72976 28.4145 8.58668 28.4145 8.4375V6.1875C28.4145 4.54647 27.8138 2.97266 26.7447 1.81228C25.6755 0.651895 24.2255 0 22.7134 0C21.2014 0 19.7514 0.651895 18.6822 1.81228C17.6131 
                                    2.97266 17.0124 4.54647 17.0124 6.1875V10.125H5.09206C3.85497 10.125 2.66854 10.6584 1.79378 11.6078C0.919017 12.5572 0.427582 13.8448 0.427582 15.1875V28.6875C0.427582 30.0302 
                                    0.919017 31.3178 1.79378 32.2672C2.66854 33.2166 3.85497 33.75 5.09206 33.75H20.6403C21.8774 33.75 23.0639 33.2166 23.9386 32.2672C24.8134 31.3178 25.3048 30.0302 25.3048 
                                    28.6875V15.1875C25.3048 13.8448 24.8134 12.5572 23.9386 11.6078C23.0639 10.6584 21.8774 10.125 20.6403 10.125H18.049V6.1875ZM20.6403 11.25C21.6025 11.25 22.5253 11.6648 23.2057 
                                    12.4033C23.886 13.1417 24.2683 14.1432 24.2683 15.1875V28.6875C24.2683 29.7318 23.886 30.7333 23.2057 31.4717C22.5253 32.2102 21.6025 32.625 20.6403 32.625H5.09206C4.12988 32.625 
                                    3.2071 32.2102 2.52673 31.4717C1.84636 30.7333 1.46413 29.7318 1.46413 28.6875V15.1875C1.46413 14.1432 1.84636 13.1417 2.52673 12.4033C3.2071 11.6648 4.12988 11.25 5.09206 11.25H20.6403Z"
                                fill="#F2695C" />
                        </svg>
                        <input type="text" id="senha" name="senha-user" placeholder="Insira a senha">
                        <svg width="30" height="25" viewBox="0 0 30 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path
                                d="M4.79908 10.7016L1.41321 7.02211M11.2407 6.18768L9.8616 1.34375M25.7832 10.7016L29.1691 7.02446M19.3416 6.18768L20.7207 1.34375M15.2912 5.54418C6.19773 5.54418 2.37967 14.4212 
                                    2.37967 14.605C2.37967 14.7889 6.19773 23.6635 15.2912 23.6635C24.3846 23.6635 28.2026 14.7889 28.2026 14.605C28.2026 14.4212 24.3846 5.54418 15.2912 5.54418Z"
                                stroke="#F2695C" stroke-width="0.857143" stroke-linecap="round"
                                stroke-linejoin="round" />
                        </svg>
                    </div>
                </div>
                <label for="confirmar-senha">Conformar senha</label>
                <div class="element-form">
                    <svg width="27" height="32" viewBox="0 0 27 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13.5 22.5C14.0967 22.5 14.669 22.2629 15.091 21.841C15.5129 21.419 15.75 20.8467 15.75 20.25C15.75 19.6533 15.5129 19.081 15.091 18.659C14.669 18.2371 14.0967 18 13.5 18C12.9033 
                                18 12.331 18.2371 11.909 18.659C11.4871 19.081 11.25 19.6533 11.25 20.25C11.25 20.8467 11.4871 21.419 11.909 21.841C12.331 22.2629 12.9033 22.5 13.5 22.5ZM6.75 6.75C6.75 4.95979 
                                7.46116 3.2429 8.72703 1.97703C9.9929 0.711159 11.7098 0 13.5 0C15.2902 0 17.0071 0.711159 18.273 1.97703C19.5388 3.2429 20.25 4.95979 20.25 6.75V7.875H21.9375C23.2802 7.875 
                                24.5678 8.40837 25.5172 9.35777C26.4666 10.3072 27 11.5948 27 12.9375V26.4375C27 27.7802 26.4666 29.0678 25.5172 30.0172C24.5678 30.9666 23.2802 31.5 21.9375 31.5H5.0625C3.71984 
                                31.5 2.43217 30.9666 1.48277 30.0172C0.533369 29.0678 0 27.7802 0 26.4375V12.9375C0 11.5948 0.533369 10.3072 1.48277 9.35777C2.43217 8.40837 3.71984 7.875 5.0625 7.875H6.75V6.75ZM19.125 
                                6.75C19.125 5.25816 18.5324 3.82742 17.4775 2.77252C16.4226 1.71763 14.9918 1.125 13.5 1.125C12.0082 1.125 10.5774 1.71763 9.52252 2.77252C8.46763 3.82742 7.875 5.25816 7.875 
                                6.75V7.875H19.125V6.75ZM5.0625 9C4.01821 9 3.01669 9.41484 2.27827 10.1533C1.53984 10.8917 1.125 11.8932 1.125 12.9375V26.4375C1.125 27.4818 1.53984 28.4833 2.27827 29.2217C3.01669 29.9602 4.01821 
                                30.375 5.0625 30.375H21.9375C22.9818 30.375 23.9833 29.9602 24.7217 29.2217C25.4602 28.4833 25.875 27.4818 25.875 26.4375V12.9375C25.875 11.8932 25.4602 10.8917 24.7217 10.1533C23.9833 9.41484 
                                22.9818 9 21.9375 9H5.0625Z" fill="#F2695C" />
                    </svg>
                    <input type="text" id="confirmar-senha" name="confirmar-senha   " placeholder="Confirmar senha">
                    <svg width="30" height="15" viewBox="0 0 30 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M29.4166 10.6426C29.3265 10.6951 29.2239 10.7223 29.1197 10.7213C29.0153 10.7214 28.9128 10.6941 28.8223 10.6419C28.7319 10.5898 28.6568 10.5148 28.6046 10.4244L25.4652 4.93221C23.599 6.29268 
                                21.4862 7.27729 19.2442 7.8312L20.2135 13.5921C20.2392 13.7474 20.2022 13.9065 20.1106 14.0346C20.0191 14.1626 19.8804 14.249 19.7251 14.2749C19.6923 14.2806 19.659 14.2836 19.6256 14.2838C19.4853 
                                14.2836 19.3495 14.2337 19.2425 14.1429C19.1354 14.0522 19.064 13.9264 19.0408 13.788L18.0893 8.07315C15.9633 8.43724 13.7909 8.43724 11.6649 8.07315L10.7135 13.788C10.6901 13.9279 10.6173 14.0549 
                                10.5084 14.1458C10.3995 14.2368 10.2616 14.2857 10.1197 14.2838C10.0864 14.2836 10.0531 14.2806 10.0203 14.2749C9.86497 14.249 9.72629 14.1626 9.63471 14.0346C9.54313 13.9065 9.50615 13.7474 9.5319 
                                13.5921L10.4938 7.82823C8.25252 7.27504 6.14017 6.29146 4.27424 4.93221L1.13479 10.4244C1.0826 10.5148 1.00751 10.5898 0.917079 10.6419C0.82665 10.6941 0.72408 10.7214 0.619707 10.7213C0.51547 
                                10.7223 0.412902 10.6951 0.322832 10.6426C0.255117 10.6037 0.195744 10.5518 0.148114 10.4899C0.100485 10.428 0.0655345 10.3573 0.0452652 10.2819C0.0249959 10.2065 0.0198059 10.1278 0.0299925 10.0504C0.040179 
                                9.97293 0.0655422 9.89827 0.104629 9.83065L3.32275 4.19893C2.16122 3.24316 1.10077 2.17078 0.158066 0.998619C0.102722 0.938843 0.0602699 0.868318 0.0333517 0.791431C0.00643354 0.714544 -0.00437493 0.63294 
                                0.00159844 0.551697C0.00757181 0.470453 0.0301992 0.391309 0.0680732 0.319186C0.105947 0.247063 0.158258 0.183504 0.22175 0.132465C0.285242 0.0814269 0.358557 0.0439998 0.437135 0.0225121C0.515712 0.00102446 
                                0.597871 -0.00406326 0.678499 0.00756443C0.759128 0.0191921 0.836502 0.047286 0.905806 0.0901002C0.975111 0.132914 1.03486 0.189532 1.08135 0.256431C3.62557 3.40479 8.08463 7.15878 14.8697 7.15878C21.6548 
                                7.15878 26.1139 3.40479 28.6581 0.254946C28.7046 0.188048 28.7643 0.131431 28.8336 0.0886166C28.9029 0.0458024 28.9803 0.0177074 29.0609 0.00607974C29.1415 -0.00554795 29.2237 -0.00046023 29.3023 
                                0.0210274C29.3809 0.0425151 29.4542 0.0799433 29.5177 0.130982C29.5812 0.18202 29.6335 0.245578 29.6713 0.317701C29.7092 0.389824 29.7318 0.468969 29.7378 0.550212C29.7438 0.631455 29.733 0.713059 29.7061 
                                0.789946C29.6791 0.866833 29.6367 0.937358 29.5814 0.997134C28.6386 2.1693 27.5782 3.24168 26.4167 4.19745L29.6348 9.83065C29.6739 9.89827 29.6992 9.97293 29.7094 10.0504C29.7196 10.1278 29.7144 10.2065 
                                29.6942 10.2819C29.6739 10.3573 29.6389 10.428 29.5913 10.4899C29.5437 10.5518 29.4843 10.6037 29.4166 10.6426Z"
                            fill="#F2695C" />
                    </svg>
                </div>
        </form>
        <button type="button" class="button-voltar">VOLTAR</button>
        <button type="submit" class="button-concluir">CONCLUIR</button>

    </main>

    <footer></footer>

</body>

</html>