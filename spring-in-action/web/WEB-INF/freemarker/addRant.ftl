<#-- импортирование макроопределений-->
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title><@spring.message "title.addRant"/></title>
    <style>
        .error {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>

<body>
<h2>
    @spring.message "title.addRant"
</h2>
<form method="post" action="addRant.ftl"
      <b><@spring.message "field.state"/></b>
      <b><@spring.message "field.plateNumber"/></b>
      <@spring.formInput "rant.vehicle.plateNumber", ""/><br/>
      <@spring.message "field.rantText"/>
      <@spring.formTextarea "rant.vehicle.plateNumber", "rows='5', cols='50'"/><br/>
      <input type="submit">
</body>
</html>