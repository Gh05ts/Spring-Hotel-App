<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/styles.css" rel="stylesheet">
  <script src="js/bootstrap.min.js"></script>
  <title>Reservation Form</title>
</head>
<body style="background: url('img/img.jpeg');">
  <div class="row">
    <div class="card overflow-auto">
      <div class="card-header text-center">
        <h2>Reservation Form</h2>
      </div>
      <div class="card-body">
        <form id="finalForm" action="final" method="POST">
          <input id="id" name="id" type="hidden" value="${id}">
          <input id="date" name="date" type="hidden" value="${date}">
          <div class="form-group">
            <label for="name">Name</label>
            <input class="form-control" name="name" id="name" type="text">
          </div>
          <div class="form-group">
            <label for="gender">Gender</label>
            <select class="form-control" id="gender" name="gender">
              <option>Male</option>
              <option>Female</option>
              <option>Other</option>
            </select>
          </div>
          <div class="form-group">
            <label for="age">Age</label>
            <input class="form-control" name="age" id="age" type="number">
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" name="email" id="email" type="text">
          </div>
          <div class="form-group">
            <label for="mobileNo">Mobile No.</label>
            <input class="form-control" id="mobileNo" name="mobileNo" type="text">
          </div>                 
        </form>
      </div>
      <div class="card-footer">
        <div class="text-center">
          <button type="submit" form="finalForm" class="btn btn-primary w-50">Reserve</button>
        </div>
      </div>
    </div>
  </div>
</body>
</html>