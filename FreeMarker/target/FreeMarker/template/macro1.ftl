<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<#macro my name title>
我的名字是：${name},<br/>
我喜欢的书籍是： ${title} <br/>
</#macro>

<h1><@my "吴云明" "java编程思想" /></h1>
<h2><@my "吴云明" "疯狂java" /></h2>
<h3><@my "吴云明" "剑指offer" /></h3>
<h4><@my name="吴云明" title="MySQL"/></h4>

<#macro my1 sex email="939219009@qq.com" address="607"> <#--前面设默认值 后面必须也设-->
${sex}<br/>
${email}<br/>
${address}<br/>
</#macro>
<@my1 sex="男" address="哈尔滨 "/>

<#macro my2 title items >
${title?substring(0,4)}    <br/>
<ul>
  <#list items as it>
      <li> ${it?cap_first}</li><#--首字母大写-->
  </#list>
</ul>
</#macro>

<@my2 title="我是你不是不是你" items=["a","ab","abc"]/>
<#macro my3 title extra...>
${title}
  <#list extra?keys as key>
  ${key}--${extra[key]}
  </#list>
</#macro>
<@my3 title="吴云明" sex="男" addres="哈理工" email="939219009" />
<br/>
<#macro my301 src extra...>
  <img src="${src}"
  <#list extra?keys as key>
  ${key}="${extra[key]}"
  </#list>
  />
</#macro>
<@my301 src="image/1.GIF"/>
<@my301 src="image/2.GIF" height="100" width="200"/>
<@my301 src="image/3.JPEG" height="200" width="300"/>
<@my301 src="image/4.GIF" height="300" width="400" alt="格式不对"/>
</html>
