<#import "main/main.ftlh" as main>

<@main.main user>
    <div class="carousel">
        <#list images as image>
            <input type="checkbox" class="faux-ui-facia">

            <div class="slide" slide="">
                <a href="/images/${image.id}">
                    <img class="imagecentr" src="/images/${image.id}" alt="">
                </a>
            </div>
        </#list>
    </div>
    <hr>
    <div class="intro">
        <p class="intro__title">${book.title}</p>
        <p class="intro__title">${book.author}</p>
        <p class="intro__body">${book.description}.</p>
        <hr>
        <a href="https://www.litmir.me/">Читать сейчас</a>
    </div>
    <form action="/book/delete/${book.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit"class="btn_delete">
            Удалить книгу
        </button>
        <p class="info_del">Книгу может удалить только администратор сайта</p>
    </form>

</@main.main>