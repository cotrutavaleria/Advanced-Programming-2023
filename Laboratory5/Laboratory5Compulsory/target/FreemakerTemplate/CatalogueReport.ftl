<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title> Catalog Report </title>
</head>
<body>
<h1>Catalogue name: ${name}</h1>
<#list docs as document>
    Document id: ${document.id},
    name: ${document.name},
    path: ${document.path},
    tags:
    <#assign myTags = document.tags>
    <#list myTags?keys as otherInfoKey>
    <#list myTags?values as otherInfoValue>
        ${otherInfoKey} = ${otherInfoValue}
    </#list>
    </#list>
</#list>
</body>
</html>