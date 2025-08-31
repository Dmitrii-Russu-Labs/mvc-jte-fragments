@param String error
@param com.example.mvc_jte_fragments.entity.Item item


@template.layout.main(content = @`

    <h2>Обновить задачу</h2>

    @if (error != null) ${error}@endif

    <form action="/items/${item.getId()}" method="post">
        <input type="hidden" name="id" value="${item.getId()}"/>
        <label for="content">Name:</label>
        <input id="content" type="text" name="name" value="${item.getName()}"/>
        <button type="submit">Обновить</button>
    </form>

`)