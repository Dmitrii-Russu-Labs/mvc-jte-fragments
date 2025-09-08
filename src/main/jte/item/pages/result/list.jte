@import com.example.mvc_jte_fragments.item.entity.Item

@import java.util.List
@param List<Item> items
@param String message
@param int currentPage
@param int totalPages
@param  int size
@param String sortField
@param String sortDir
@param String reverseSortDir

@template.item.layout.main(content = @`

    <h2>Все задачи</h2>
    @if (message != null)<p style="color: green;">${message}</p>@endif

    <ul>
        @for(Item i : items)
            <li>
                ${i.getId()} — ${i.getName()}
            </li>
        @endfor
    </ul>

    <hr>
    <p>Страница ${currentPage} из ${totalPages}</p>

    <!-- Форма выбора размера страницы -->
    <form method="get" style="margin-bottom: 1em;">
        <input type="hidden" name="page" value="${currentPage}">
        <input type="hidden" name="sortField" value="${sortField}">
        <input type="hidden" name="sortDir" value="${sortDir}">

        <label for="size">Показать по:</label>
        <select name="size" id="size" onchange="this.form.submit()">
            @for (int option : new int[]{2, 5, 10, 25, 50})
                <option value="${option}" selected?="${option == size}">${option}</option>
            @endfor
        </select>
    </form>


    <hr>
    @for (int i = 1; i <= totalPages; i++)
        <a href="?page=${i}&size=${size}&sortField=${sortField}&sortDir=${sortDir}">${i}</a>
    @endfor

    <hr>

    <div>
        @if (currentPage > 1)
            <a href="?page=${currentPage - 1}&size=${size}&sortField=${sortField}&sortDir=${sortDir}">← Назад</a>
        @endif

        @if (currentPage < totalPages)
            <a href="?page=${currentPage + 1}&size=${size}&sortField=${sortField}&sortDir=${sortDir}">Вперёд →</a>
        @endif
    </div>


    <hr>

    <a href="?page=${currentPage}&size=${size}&sortField=id&sortDir=${sortField.equals("id") ? reverseSortDir : "asc"}">
        ID
        @if (sortField.equals("id"))
            (${sortDir})
        @endif
    </a>

    <hr>
    <a href="?page=${currentPage}&size=${size}&sortField=name&sortDir=${sortField.equals("name") ? reverseSortDir : "asc"}">
        Name
        @if (sortField.equals("name"))
            (${sortDir})
        @endif
    </a>
    <hr>
`)