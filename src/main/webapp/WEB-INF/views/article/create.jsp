<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 01.03.2016
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new article</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.8.2.min.js"></script>
    <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
    <script>tinymce.init({
        selector: 'textarea',
        height: 500,
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste imagetools"
        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
        imagetools_cors_hosts: ['www.tinymce.com', 'codepen.io']
    });</script>
</head>
<body>
${status}
<form action="/article/create" method="post">
    <input type="hidden" name="id" value="${article.id}">
    Title: <input type="text" name="title" placeholder="title"value="${article.title}"/>
    Text: <textarea name="content">${article.content}</textarea>
    Tags:  <input type="text" name="tags" value="${tags}" id="articleTags"/>
    <input type="submit" value="create"/>
    <div id="message"></div>
</form>
</body>

</html>
<script>
    $('#articleTags').on('input paste', function() {

        var uniqueTags = [];
        $.each($(this).val().split(','), function(i, el){
            if($.inArray(el, uniqueTags) === -1) uniqueTags.push(el);
        });
        var tagsLength = uniqueTags.length;
        var maxTagsSize = 5;
        if ((maxTagsSize - tagsLength) >= 0) {
            $('#message').text(maxTagsSize - tagsLength);
            $(this).parent().find("[type=submit]").removeAttr("disabled");
        } else {
            $(this).parent().find("[type=submit]").attr("disabled", "disabled");
            $('#message').text("Only 5 tags  allowed!")
        }
        if ($(this).val().indexOf(" ") >= 0) {
            $('#message').text("white space not allowed!");
            $(this).parent().find("[type=submit]").attr("disabled", "disabled");
        } else {
            $(this).parent().find("[type=submit]").removeAttr("disabled");
        }
        $(this).val(uniqueTags);
    })
</script>
