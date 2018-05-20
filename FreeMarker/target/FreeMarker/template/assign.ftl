<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
  <#assign text=1 sex=["female","male"]/>
  ${text}<br>
  <#list sex as s>
      ${s}
  </#list>
  <br/>
<#assign value="对面是傻逼"/>
  <#global value="对面绝对是傻逼"/>
${.globals.value}
<br/>
<#assign money=0.5/>
  ${money}
  <#setting number_format="percent"/>
  ${money}
  <#setting number_format="currency"/>
  ${money}
</body>
</html>