<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/styles-home.css" rel="stylesheet">
  <script src="js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />  
  <meta charset="UTF-8">
  <title>Confirm Details</title>
</head>
<body style="background: url('img/img.jpeg');">
  <form id="confirmForm" action="reserve" method="POST" style="display: none;">
    <input type="hidden" name="hotelId" id="hotelId" value="${hotel.id}">
    <input type="hidden" name="date" id="date" value="${date}">
  </form>
  <div class="row">
    <div class="card card-block overflow-auto">
      <div class="card-header text-center">
        <h2>Confirm</h2>
      </div>
      <div class="card-body">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>RoomType</th>
              <th>Price</th>
              <th>GST</th>
              <th>Total</th>              
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${hotel.roomType.split("\\|")[0]}</td>
              <td>${hotel.price}</td>
              <td>${hotel.gst}</td>
              <td>${total}</td>
            </tr>
          </tbody>
          <tfoot>
            <tr id="tableFoot">

            </tr>
            <tr id="tableFootText"></tr>
          </tfoot>
        </table>
      </div>
      <div class="card-footer">
        <div class="text-center">
          <a href="home" style="margin-right: 12px;">
            <button class="btn btn-secondary">Back</button>
          </a>
          <button type="submit" form="confirmForm" style="margin-left: 12px;" class="btn btn-primary">Confirm</button>
        </div>
      </div>
    </div>
  </div>
  <script>
    (function() {
      const roomType = '${hotel.roomType}'
      let tokens = roomType.split('|')
      const parking = '<i class="fas fa-parking"></i>'
      const smoking = '<i class="fas fa-smoking"></i>'
      const smokBan = '<i class="fas fa-smoking-ban"></i>'
      const wifi = '<i class="fas fa-wifi"></i>'
      let el = document.getElementById('tableFoot')
      let appen = ""
      if(tokens[0].startsWith('D')) {
        appen += wifi
      }
      if(tokens[1].startsWith('P')) {
        appen += parking
      }
      if(tokens[2].startsWith('S')) {
        appen += smoking
      } else {
        appen += smokBan
      }
      el.innerHTML = appen
    })()
  </script>
</body>
</html>