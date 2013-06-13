 <!DOCTYPE html>
    <html>
      <head>
        <title>Caronas | Busca</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <script src="jquery.min.js"></script>
      </head>
      <body>
        <header class="container">
          <h1 id="logo"><a href="index.jsp">Caronas</a></h1>
          <nav id="menu">
            <ul>
              <li><a href="index.jsp" class="active">Inicio</a></li>
              <li><a href="cadastro.jsp">Cadastro</a></li>
            </ul>
          </nav>
        </header>
        <section class="container">
          <article id="form">
            <header>
              <h1>Busca</h1>
            </header>
              <form method="get" action="BuscaUsuarios">
              <p><label for="nomeCidade">Cidade</label><input type="text" id="nomeCidade" name="nomeCidade"></p>
              <p><input type="submit" id="busca"value="Buscar"></p>
            </form>
          </article>
        </section>
        <footer class="container">
          <p>Desenvolvimento Web - UFSCar Sorocaba - 2013</p>
        </footer>
        <script>
          $(document).ready(function(){
           
          });
        </script>
      </body>
    </html>