<#macro main user>
    <!doctype html>
    <html lang="ru">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="/static/css/custom.css" />
        <title>MY Library</title>
    </head>
    <body>
    <header>
        <nav class="top-menu">
            <a href="/"><p class="logo">Library</p></a>
            <#if user.email??>
            <a href="/my/book" class="open">
                <img src="/static/avatar/avatar.png" alt="mdo"
                     width="40" height="32" class="circle">
                    </a>
            <#else>
                <button class="open" type="button"
                        onclick="window.location.href = '/login'">
                    Войти
                </button>
            </#if>
            <ul class="menu-main">
                <li><a href="/" class="current">Поиск</a></li>
                <li><a href="">Жанр</a></li>
                <li><a href="">Жанр</a></li>
                <li><a href="">Жанр</a></li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <#nested/>
    </div>

    </body>
    </html>
</#macro>