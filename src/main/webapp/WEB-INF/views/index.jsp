<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Email Validation</title>
  <title>The World Clock</title>
  <style type="text/css">
    select {
      width: 200px;
      height: 20px;
    }
  </style>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="validate" method="post">
  <input type="text" name="email"><br>
  <input type="submit" value="Validate">
</form>


<h2>Current Local Times Around the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="world-clock" method="get">
  <select name="city" onchange="document.getElementById('locale').submit()">
    <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
    <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
    <option value="Singapore">Singapore</option>
    <option value="Asia/Hong_Kong">Hong Kong</option>
    <option value="Asia/Tokyo">Tokyo</option>
    <option value="Asia/Seoul">Seoul</option>
    <option value="Europe/London">London</option>
    <option value="Europe/Madrid">Madrid</option>
    <option value="America/New_York">New York</option>
    <option value="Australia/Sydney">Sydney</option>
    <option value="Argentina/Buenos_Aires">Buenos Aires</option>
  </select>
</form>

<form action="/cal">
    <input type="text" name ="a1">
    <input type="text" name ="b2">
    <button name="cal" value="tong" >+</button>
    <button name="cal" value="tich">x</button>
    <button name="cal" value="hieu">-</button>
    <button name="cal" value="thuong">/</button>
</form>
</body>
</html>
