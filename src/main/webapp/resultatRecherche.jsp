<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.models.Produit"%>




<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<div class="container mt-5">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">



				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">nom</th>
							<th scope="col">marque</th>
							<th scope="col">catégorie</th>
							<th scope="col">grade nutritionnel</th>

						</tr>
					</thead>
					<tbody>

						

						<%
							List<Produit> listeDeProduits = (List<Produit>) request.getAttribute("produits");
						
								for (Produit prod : listeDeProduits) {
							%>
							<tr>
								
								<td><%=prod.getNom()%></td>
								<td><%=prod.getMarque()%></td>
								<td><%=prod.getCategorie()%></td>
								<td><%=prod.getGrade()%></td>
							</tr>
							<%
								}
							%>
						
					</tbody>
				</table>

			</div>
			<div class="col-1"></div>
		</div>
	</div>



	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
</body>

</html>