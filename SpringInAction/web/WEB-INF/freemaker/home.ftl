<html>
<head>
    <title>Rantz</title>
</head>
<body>
<h2>Rantz:</h2>
<a href="addRant.htm">Add rant</a><br/>
<a href="register.htm">Register now motorist</a><br/>
<ul>
    <!-- Итерации по элементам списка -->
    <#list rants as rant>
        <li>
            ${rant.vehicle.state}
            ${rant.vehicle.plateNumber}
            ${rant.rantText}
        </li>
    </#list>

</ul>
</body>
</html>