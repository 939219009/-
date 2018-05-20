<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<#list user1 as user>
  <#-- ${user.username}  ${user.age}<br/>-->
  ${user_index}.${user.username}
   <#if (user_has_next)>
       ,
   </#if>
</#list>
</body>
</html>