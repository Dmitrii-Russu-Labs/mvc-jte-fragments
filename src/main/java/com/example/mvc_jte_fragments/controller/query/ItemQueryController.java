package com.example.mvc_jte_fragments.controller.query;

import java.util.List;
import com.example.mvc_jte_fragments.entity.Item;
import com.example.mvc_jte_fragments.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"", "/", "/items"})
public class ItemQueryController {

    private final ItemService service;

    public ItemQueryController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public String processSearch(
            @RequestParam("id") Long id,
            Model model
    ) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "pages/item";
    }

    @GetMapping("/all")
    public String findAll(
            Model model,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            @RequestParam(name = "sortField", defaultValue = "id") String sortField,
            @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
            @ModelAttribute("message") String message
    ) {
        // В сервисе yourService.findAll() — PAGE-версия
        Page<Item> pageItems = service.findAll(page, size, sortField, sortDir);

        List<Item> items = pageItems.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageItems.getTotalPages());
        model.addAttribute("totalItems", pageItems.getTotalElements());
        model.addAttribute("size", size);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        // для переключения направления сортировки в шаблоне
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("items", items);
        model.addAttribute("message", message);

        return "pages/items";
    }

}
