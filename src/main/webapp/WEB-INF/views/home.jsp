<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/styles-home.css" rel="stylesheet">
		<script src="js/bootstrap.min.js"></script>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body style="background: url('img/img.jpeg');">
		<div class="row">
			<div class="card overflow-auto">
				<div class="card-header text-center">
					<h2>Hotel Reservation System</h2>
				</div>
				<div class="card-body">
					<form id="homeForm" action="check" method="POST">
						<div class="form-group">
							<label for="city">City</label>
							<select name="city" id="city" class="form-control">
								<c:forEach var="hotel" items="${allHotel}">
									<option value="${hotel}">${hotel}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="name">Hotel</label>
							<select name="name" id="name" class="form-control">
							</select>
						</div>
						<div class="form-group">
							<label for="date">Date</label>
							<input id="date" name="date" type="date" class="form-control" min="2020-01-01" max="2020-12-31">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="text-center">
						<button type="submit" form="homeForm" class="btn btn-primary w-50">Submit</button>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		const modelAttrVal = `${cityMap}`
		const ne = JSON.parse(modelAttrVal)
		function select(selectId, cityName) {
			let selectElem = document.getElementById(selectId)
			let listItems = ""
			for(x in ne[cityName]) {
				listItems += "<option value='" + ne[cityName][x].id+"'>" + ne[cityName][x].name + "</option>"
			}
			selectElem.innerHTML = listItems
		}
		let el = document.getElementById('city')
		select('name', el.value)
		el.addEventListener('change', function() {
			let ele = document.getElementById('city')
			select('name', ele.value)
		})
	</script>
</html>