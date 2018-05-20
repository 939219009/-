<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<#macro  my1>
   1. <#nested> <br/>
   2. <#nested> <br/>
   3. <#nested> <br/>
   4. <#nested> <br/>
</#macro>
<@my1>大帅锅</@my1>

<#macro my2>
    <#nested 1,2,3>
    <#nested "a","b","c">
</#macro>
<@my2 ; x,y,z>
    ${x}--${y}--${z}<br/>
</@my2>

<#macro repeat count>
    <#list 1..count as x>
        <#nested x,x-1,x==count>
    </#list>
</#macro>
<@repeat 4 ;c,cc,ccc>
   ${c}--${cc}---<#if (ccc)>结束了</#if>
</@repeat>



</body>
</html>