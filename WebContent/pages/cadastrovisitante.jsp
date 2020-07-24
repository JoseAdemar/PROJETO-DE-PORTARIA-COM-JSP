<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CADASTRO DE VISITANTES</title>
    <!-- INICIO DO LINK JQUERY PARA UPLOAD DE IMAGEM -->
    <script type="text/javascript"
            src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <!-- FIM DO LINK JQUERY PARA UPLOAD DE IMAGEM -->
</head>
<body>

<!-- AQUI COMEÇA O CÓDIGO PARA REALIZAR PESQUISA DE VISITANTES NO SISTEMA -->

<div>
    <form class="search" action="PesquisarVisitante" method="POST">

        <input id="txbusca" name="pesquisa" type="text" value=""
               placeholder="Digite o que você procura"/> <input id="btnBusca"
                                                                type="submit" value="Pesquisar"/> <input type="submit"
                                                                                                         value="Voltar"/>
        <input TYPE="button" VALUE="Home"
               onclick="window.location.href='menu.jsp'">


    </form>

</div>
<!-- AQUI TERMINA O CÓDIGO PARA REALIZAR PESQUISA DE VISITANTES NO SISTEMA -->


<h1>BEM VINDOS A TELA DE CADASTRO DE VISITANTES</h1>

<!-- AQUI COMEÇA O CÓDIGO DO FORMULARIO PARA CADASTRO DE VISITANTES -->
<form action="VisitanteServlet" method="post">

    <table>

        <tr>

            <td><input type="text" id="id" name="id" hidden=""
                       value="${usuario.id }"/></td>
        </tr>

        <tr>
            <td>Nome</td>
            <td><input type="text" required id="nome" name="nome"
                       value="${usuario.nome }"/></td>
        </tr>

        <tr>
            <td>CPF</td>
            <td><input type="text" required id="cpf" name="cpf"
                       value="${usuario.cpf }"/></td>
        </tr>

        <tr>
            <td>RG</td>
            <td><input type="text" required id="rg" name="rg"
                       value="${usuario.rg }"/></td>
        </tr>


        <tr>
            <td>FONE</td>
            <td><input type="text" required id="telefone" name="telefone"
                       value="${usuario.telefone }"/></td>
        </tr>


        <tr>
            <td>DataHora</td>
            <td><input type="datetime-local" required id="datetime"
                       name="datetime" value="${usuario.datetime }"/></td>
        </tr>


        <tr>
            <td>Destino</td>
            <td><input type="text" required id="destino" name="destino"
                       value="${usuario.destino }"/></td>
        </tr>

        <tr>
            <td>Motivo</td>
            <td><input type="text" required id="motivo" name="motivo"
                       value="${usuario.motivo }"/></td>
        </tr>

       
        <tr>

            <td><input type="submit" value="Salvar"/></td>
            <td><input type="reset" value="Cancelar"/></td>
        </tr>

    </table>

</form>

<!-- AQUI TERMINA O CÓDIGO DO FORMULARIO PARA CADASTRO DE VISITANTES -->

<br/>
<br/>

<!-- AQUI COMEÇA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE VISITANTES -->


<table border="1">

    <tr>

        <th>ID</th>
        <th>Nome</th>
        <th>CPF</th>
        <th>RG</th>
        <th>FONE</th>
        <th>DataHora</th>
        <th>Destino</th>
        <th>Motivo</th>
        <th>Foto</th>

        <th>Excluir</th>
        <th>Editar</th>
        <th>Upload de imagem</th>


    </tr>

    <c:forEach items="${visitantes}" var="usuario">


        <tr>

            <td><c:out value="${usuario.id }"></c:out></td>
            <td><c:out value="${usuario.nome }"></c:out></td>
            <td><c:out value="${usuario.cpf}"></c:out></td>
            <td><c:out value="${usuario.rg}"></c:out></td>
            <td><c:out value="${usuario.telefone}"></c:out></td>
            <td><c:out value="${usuario.datetime}"></c:out></td>
            <td><c:out value="${usuario.destino}"></c:out></td>
            <td><c:out value="${usuario.motivo}"></c:out></td>
            <td><img width="200" height="200" src='<c:out value="${usuario.foto}"/>'></td>


            <!-- AQUI COMEÇA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->

            <td><a
                    href="VisitanteServlet?acao=deletar&usuario=${usuario.id}">Excluir</a></td>
            <td><a
                    href="VisitanteServlet?acao=editar&usuario=${usuario.id}">Editar</a></td>

            <td><input type="file" id="foto${usuario.id}" name="foto" style="display: none"
                       onchange="uploadFile(${usuario.id });"/>
                <button type="button" onclick="triggerUpload(${usuario.id })"> Upload de imagem</button>
            </td>

            <!--  <td><a href="VisitanteServlet"></a></td> -->


            <!-- AQUI TERMINA O COMANDO PARA DELETAR LOGIN E ATUALIZAR LOGIN -->


        </tr>


    </c:forEach>


</table>

<!-- AQUI TERMINA O CÓDIGO PARA VISUALIZAR OS CADASTRO DE LOGINS -->


</body>


<!--  AQUI COMEÇA O CÓDIGO DO JAVASCRIPT  -->

<script type="text/javascript">
    function triggerUpload(id) {
        document.getElementById('foto' + id).click();
    }

    function uploadFile(id) {
        var file = document.getElementById('foto' + id).files[0];

        var reader = new FileReader();

        reader.onloadend = function () {


            // Upload Ajax
            $.ajax({
                method: "POST",
                url: "VisitanteServlet",
                data: {
                    foto: reader.result,
                    id: id
                }
            }).done(function (response) {
                //alert("Sucesso: " + response);
            }).fail(function (xhr, status, errorThrown) {
                //alert("Error: " + xhr.responseText);
            });
        };

        if (file) {
            reader.readAsDataURL(file);
        } else {
        }
    }
</script>

<!--  AQUI TERMINA O CÓDIGO DO JAVASCRIPT  -->


</html>