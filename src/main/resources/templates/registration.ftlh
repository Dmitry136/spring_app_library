<#import "main/main.ftlh" as main>

<@main.main user>

    <form action="/registration" method="post" class="ui-form">
        <h3>Регистрация</h3>
        <div class="form-row">
            <input type="text" required id="name" name="name"><label for="name">Username</label>
        </div>
        <div class="form-row">
            <input type="email" id="email" required name="email"><label for="email">Email</label>
        </div>
        <div class="form-row">
            <input type="password" id="password" required name="password"><label for="password">Пароль</label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><input type="submit" value="Зарегистрироваться"></p>
    </form>
    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>

</@main.main>