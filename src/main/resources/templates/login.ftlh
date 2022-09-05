<#import "main/main.ftlh" as main>

<@main.main user>

    <form action="/login" method="post" class="ui-form">
        <h3>Войти на сайт</h3>
        <div class="form-row <#if RequestParameters.error??>is-invalid</#if>">
            <input type="email" id="email" name="username"><label for="email">Email</label>
        </div>
        <div class="form-row <#if RequestParameters.error??>is-invalid</#if>">
            <input type="password" id="password" name="password"><label for="password">Пароль</label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><input type="submit" value="Войти"></p>
    </form>
    <hr>
    <div class="reg">
        <a class="registration" href="/registration">Зарегистрироваться</a>
    </div>

</@main.main>