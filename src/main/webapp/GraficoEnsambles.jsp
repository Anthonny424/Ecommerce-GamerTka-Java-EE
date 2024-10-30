<%@page import="modelo.Ensamble"%>
<%@page import="dao.Negocio"%>
<html>
  <link
    rel=
"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
    type="text/css"
  />
  <script src=
"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script
    src=
"https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
    type="text/javascript"
  ></script>
  <script src=
"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  <script src=
"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.2.2/Chart.min.js"></script>
  <style>
    .container {
      width: 70%;
      margin: 15px auto;
    }
    body {
      text-align: center;
      color: black;
    }
    h2 {
      text-align: center;
      font-family: "Verdana", sans-serif;
      font-size: 30px;
    }
  </style>
  <body>
      <%
      Negocio obj = new Negocio();
      String label="", data="";
      
      for(Ensamble x: obj.GraficoEnsambles()){
      label+="'"+x.getNomEnsamble()+"',";
      data+=x.getStock()+",";
      }
      
      label=label.substring(0, label.length()-1);
      data=data.substring(0, data.length()-1);
      %>
   
    <div class="container">
      <h2 style="font-size: 20px;">Gráfico de stock por ensamble</h2>
      <div>
        <canvas id="myChart"></canvas>
      </div>
    </div>
  </body>
  <script>
    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "polarArea",
      data: {
        labels: [<%=label%>],
        datasets: [
          {
            label: "Stock",
            data: [<%=data%>],
            backgroundColor: ["#F10101", "#F18001", "#F2E10C", "#A9F20C", "#0CF2CC", "#0CC8F2", "#0C86F2", "#A20CF2", "#F20C7C"],
          },
        ],
      },
    });
  </script>
</html>