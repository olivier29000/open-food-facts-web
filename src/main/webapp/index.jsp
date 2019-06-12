<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.List, fr.diginamic.models.Categorie, fr.diginamic.models.Marque, fr.diginamic.models.Grade"%>




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
	<div class="container">
		<div class="row"></div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10 mt-5">

				<form method="POST" action="http://localhost:8080/open-food-facts-web/init/">

					<div class="row">
						<div class="col-3">
							<div class="form-group">
								<label for="exampleFormControlSelect2">catégorie</label>
								<%
									List<Categorie> listeDeCategories = (List<Categorie>) request.getAttribute("categories");
									String idCategorie = (String) request.getAttribute("idCategorie");
								%>
								<select name="selectedCateg" class="form-control"
									id="exampleFormControlSelect1" onChange="trucJavaScript()">
									<%
										for (Categorie categ : listeDeCategories) {
									%>

									<option value="<%=categ.getId()%>"
										<%if (categ.getId() == Integer.parseInt(idCategorie)) {%>
										selected="selected" <%}%>><%=categ.getNom()%></option>

									<%
										}
									%>
								</select>
							</div>
						</div>
						<div class="col-3">
							<div class="form-group">
								<label for="exampleFormControlSelect2">marque</label>

								<%
									List<Marque> listeDeMarques = (List<Marque>) request.getAttribute("marques");
									String idMarque = (String) request.getAttribute("idMarque");
								%>
								<select name="selectedMarq" class="form-control"
									id="exampleFormControlSelect2" onChange="trucJavaScript()">
									<%
										for (Marque marq : listeDeMarques) {
									%>

									<option value="<%=marq.getId()%>"
										<%if (marq.getId() == Integer.parseInt(idMarque)) {%>
										selected="selected" <%}%>><%=marq.getNom()%></option>

									<%
										}
									%>
								</select>


							</div>
						</div>

						<div class="col-3">
							<div class="form-group">
								<label for="exampleFormControlSelect2">grade
									nutritionnel</label>

								<%
									List<Grade> listeDeGrades = (List<Grade>) request.getAttribute("grades");
									String grade = (String) request.getAttribute("grade");
								%>

								<select name="selectedGrad" class="form-control" onChange="trucJavaScript()" >
									<%
										for (Grade grad : listeDeGrades) {
									%>

									<option value="<%=grad.getGradeNutritionnel()%>"
									<%if (grade.equals(grad.getGradeNutritionnel())) {%>
										selected="selected" <%}%>><%=grad.getGradeNutritionnel()%></option>

									<%
										}
									%>
								</select>
							</div>
						</div>
					</div>
					<div class="center-block">


						<button type="submit" class="btn btn-primary center-block">Submit</button>
					</div>
				</form>

			</div>
			<div class="col-1"></div>
		</div>
	</div>


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
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Larry</td>
							<td>the Bird</td>
							<td>@twitter</td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="col-1"></div>
		</div>
	</div>
	<script type="text/javascript">
		function trucJavaScript() {
			idCategorie = -1;
			idMarque = -1;
			grade="";
			console.log(document.forms[0].selectedCateg.value);
			console.log(document.forms[0].selectedMarq.value);
			if (document.forms[0].selectedCateg.value == "") {
				idCategorie = -1;

			} else {
				idCategorie = document.forms[0].selectedCateg.value;
			}
			if (document.forms[0].selectedMarq.value == "") {
				idMarque = -1;
			} else {
				idMarque = document.forms[0].selectedMarq.value;
			}
			if (document.forms[0].selectedGrad.value == "") {
				grade = "indeterminé";

			} else {
				grade = document.forms[0].selectedGrad.value;
			}

			console.log(idCategorie);
			console.log(idMarque);
			document.location.href = "http://localhost:8080/open-food-facts-web/init2?idCategorie="
					+ idCategorie + "&idMarque=" + idMarque + "&grade=" + grade;

		}
	</script>


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