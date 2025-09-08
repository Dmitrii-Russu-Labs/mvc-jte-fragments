package com.example.mvc_jte_fragments.item.controller.query;

import com.example.mvc_jte_fragments.item.entity.Item;
import com.example.mvc_jte_fragments.item.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"", "/", "/items"})
public class ItemViewController {

    private final ItemService service;

    public ItemViewController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public String maiPage() {
        return "item/layout/main";
    }

    @GetMapping("/search_form")
    public String showSearchForm(
            @ModelAttribute("error") String error,
            @ModelAttribute("message") String message,
            Model model
    ) {
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        return "item/pages/form/search-by-id-form";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/pages/form/create-form";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(
            Model model, @PathVariable( value = "id") long id
    ) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "item/pages/form/edit-form";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteConfirmationForm(@PathVariable Long id, Model model) {
        Item item = service.findById(id);
        model.addAttribute("item", item);
        return "item/pages/form/delete-confirm-form"; // JTE-шаблон подтверждения
    }

}
