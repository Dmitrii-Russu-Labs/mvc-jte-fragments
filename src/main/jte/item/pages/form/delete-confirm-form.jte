@param com.example.mvc_jte_fragments.item.entity.Item item


@template.item.layout.main(content = @`

    <h1>Подтвердите удаление</h1>

    <div style="display: flex; align-items: center; font-family: sans-serif; gap: 1rem;">

        <div style="font-size: 1rem;">
            Удалить Задание — «${item.getId()}. ${item.getName()}»?
        </div>

        <form action="/search" method="get" style="margin: 0;">
            <input type="hidden" name="id" value="${item.getId()}" />
            <button type="submit" style="padding: 0.3rem 0.6rem;">Вернуться к заданию</button>
        </form>

        <form action="/items/${item.getId()}/delete" method="post" style="margin: 0;">
            <button type="submit" style="padding: 0.3rem 0.6rem;">Удалить</button>
        </form>

    </div>

`)