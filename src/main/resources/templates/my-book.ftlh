<#import "main/main.ftlh" as main>

<@main.main user>

    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" class="btn_delete" value="Выйти из аккаунта"/>
    </form>
    <hr>
    <#if user.email??>
        <div id="contact-form">
        <h3>Добавить новую книгу</h3>
        <form action="/book/add" method="post" enctype="multipart/form-data">

            Название : <input type="text" required="required" name="title"/><br><br>
            Автор: <input type="text" required="required" name="author"/><br><br>
            Описание: <textarea required="required" placeholder="Описание книги" name="description"></textarea><br><br>
            Обложка книги 1: <input type="file" required="required" name="file1"/><br>
            Обложка книги 2: <input type="file" name="file2"/><br>
            Обложка книги 3: <input type="file" name="file3"/><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" class="imp_add" value="Добавить книгу"/>
        </form>
        </div>
    </#if>

</@main.main>