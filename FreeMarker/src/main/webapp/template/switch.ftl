<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<#assign sex="r"/>
   <#switch sex>
       <#case "f">
          女孩
         <#break />
       <#case "m">
          男孩
         <#break />
       <#default>
          不男不女
   </#switch>

</body>
</html>