<!DOCTYPE html>
<html>
<body>

<h1> Catalog items: </h1>
<p>
    <#list catalog as item>
        Id:"${item.id}", Title:"${item.title}", Location:"${item.location}", Year:"${item.year}", Author:"${item.autor}" </br>
    </#list>

</p>

</body>
</html>