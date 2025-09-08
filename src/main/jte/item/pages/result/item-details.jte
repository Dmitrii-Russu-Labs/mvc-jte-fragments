@param String message
@param com.example.mvc_jte_fragments.item.entity.Item item

@template.item.layout.main(content = @`

    <h2>Item</h2>

    @if (message != null)<p style="color: green;">${message}</p>@endif

    <div style="white-space: nowrap; font-family: sans-serif;">
        <strong>ID: ${item.getId()}&nbsp;&nbsp;Name: ${item.getName()}</strong>
        <!-- Одна форма с двумя кнопками и атрибутом formaction -->
        <form method="get" style="display: inline; margin: 0; padding: 0;">
            <button type="submit" formaction="/items/${item.getId()}/edit" style="margin-left: .5rem;">
                Обновить
            </button>
            <button type="submit" formaction="/items/${item.getId()}/delete" style="margin-left: .25rem;">
                Удалить!
            </button>
        </form>
    </div>

`)