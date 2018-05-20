<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>$Title$</title>
</head>
<body>
<#-- MX  小数部分做大X位  进位 四舍五入-->
<#-- mX  小数部分做小X位  进位 四舍五入-->
<#setting number_format="percent">
<#assign x=5.14157 y=4/>
#{x}<br/>
#{x;M3}<br/>
#{x;m3}<br/>
#{y;M3}<br/>
#{y;m3}<br/>
#{x;m2M4}

<#setting date_format="yyyy-MM-dd HH:mm:ss zzz">
现在的时间：${.now?string}<br/>
<#--setting 转换后-->
现在的时间: ${.now?date?string}<br/>

现在的短时间：${.now?datetime?string.short}<br/>
现在的长时间：${.now?datetime?string.long}<br/>

现在的时间为HH(24)小时：${.now?string("HH:mm:ss,E,W,MM,d,yyyy ")}<br/>

<#assign name="wuyunming">
${name[1]}  ${name[6]} <br/>
${name[0..6]}
<br/>
<#assign userlist={"username":"吴云明","sex": "男"}+{"age":"18"}/>
usrname: ${userlist.username}
sex:${userlist.sex}
age:${userlist.age}
<br/>

<#if userlist?exists>
    <#list userlist?keys as key>
         ${key_index+1}
         ${key}
         ${userlist[key]}
    </#list>
</#if>
</body>
</html>