@param String error
@param String message
@param com.example.mvc_jte_fragments.entity.Item item


@template.layout.main(content = @`
    <h2>Search Form</h2>

    <h2>Поиск задачи по ID</h2>
    <form action="/search" method="get">
        <label for="id">ID:</label>
        <input id="id" type="number" name="id" required />
        <button type="submit">Найти</button>
    </form>

    @if (error != null) <p style="color: red;">${error}</p> @endif
    @if (message != null)<p style="color: green;">${message}</p>@endif
`)