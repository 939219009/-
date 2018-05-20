<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<#escape e1 as e1?html><#--不解析 必须是 e1-->
    ${user2}
    <#noescape>
     ${user2}
    </#noescape>
</#escape>
</body>
</html>