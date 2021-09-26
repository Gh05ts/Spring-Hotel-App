<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles-home.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<title>Booked</title>
</head>
<body style="background: url('img/img.jpeg');">
  <div class="row">
    <div class="card text-white bg-success overflow-auto">
      <div class="card-header text-center">
        <h2>Booked</h2>
      </div>
      <div class="card-body">
        <h5 class="card-title text-center">${hotelName}</h5>
        <br>
        <p class="card-text text-center ">
          Dear ${name}, Thank you for choosing ${hotelName}.
          It is our pleasure to confirm your reservation.          
        </p>
      </div>
    </div>
  </div>
</body>
</html>