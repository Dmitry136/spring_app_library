<#import "main/main.ftlh" as main>

<@main.main user>
    <hr>
    <ul class="cards">
        <#list books as book>
            <li class="cards__item">
                <div class="card">
                <a href="/book/${book.id}" class="product-link">
                    <div class="card__image">
                        <img src="/images/${book.previewImageId}">
                    </div>
                    <div class="card__content">
                            <div class="card-title">${book.title}</div>
                            <p class="card-text">${book.author} </p>
                        <button  class="btn btn--block card__btn"><a href="https://www.litmir.me/">Читать онлайн</a></button>
                    </div>
                </a>
        <#else>
                <h1 style="text-align: center">Не найдено</h1>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
</@main.main>



