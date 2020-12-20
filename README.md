# api

<div>
 <b>Inicialização do projeto</b>
  <p>Necessário criar o <strong>schema</strong> com o nome <b>api</b>.<br>
  Foi criado um arquivo data.sql com dados iniciais. Este arquivo é executado assim que o projeto é executado.</p>
</div>
<br>
<div>
  <b>Rotas</b>
  <p>
    <br>
    <b>POST:</b> http://localhost:8080/pessoas<br>
    <b>JSON:</b>
    {
      "nome": "Joao da Silva",
      "nascimento": "07/12/1986",
      "estadoCivil": "CASADO",
      "nomeParceiro": "Ana Catarina",
      "nascimentoParceiro": "10/12/2010"
    }<br><br>
    <b>DELETE:</b> http://localhost:8080/pessoas/1<br><br>
    <b>PUT:</b> http://localhost:8080/pessoas/1<br>
    <b>JSON</b>
    {
      "nome": "Pedro da Silva",
      "estadoCivil": "SOLTEIRO",
      "nascimento": "12/12/2012",
      "nomeParceiro": "Ana Paula",
      "nascimentoParceiro": "10/12/2000"
    }<br><br>
    <b>GET</b>
    URL:http://localhost:8080/pessoas<br>
    URL:http://localhost:8080/pessoas?nome=joao
   </p>
</div>

<br>
<div>
 <b>Bibliotecas e tecnologias</b>
  <p>
    Foram utilizadas as tecnologias: 
    <ul>
      <li>Java 8</li>
      <li>SpringBoot 2.2.6.RELEASE</li>
      <li>lombok 1.18.12</li>
      <li>Hibernate 5.4.12</li>
      <li>MySQL</li>
    </ul>
   </p>
</div>
<br>
<div>
<b>Arquitetura</b>
<p>
  Foi dividida em config, controller, dto, form, model, repository e service.<br>
  Sendo delegada cada responsabilidade para um pacote especifico. Por exemplo:
  O <b>service</b> cuidando da regra de negócio, o <b>contoller</b> consumindo o <b>service</b>.
  DTO sendo usado em vez de mandar a entidade, entre outras.
  </p>
</div>
