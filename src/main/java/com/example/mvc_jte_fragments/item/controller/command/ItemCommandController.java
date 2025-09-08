package com.example.mvc_jte_fragments.item.controller.command;

import com.example.mvc_jte_fragments.item.entity.Item;
import com.example.mvc_jte_fragments.item.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"", "/", "/items"})
public class ItemCommandController {

    private final ItemService service;

    public ItemCommandController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public String create(
            @Valid Item item,
            RedirectAttributes redirectAttributes
    ) {
        Item saved = service.saveOrUpdate(item);
        redirectAttributes.addFlashAttribute("message", "User information saved successfully!");
        return "redirect:/items/search?id=" + saved.getId();
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Задание # " + id + " - удалено!");
        return "redirect:/all";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute Item item,           // подхватит поля id и name
            RedirectAttributes redirectAttributes
    ) {
        item.setId(id);                        // на всякий случай
        service.saveOrUpdate(item);                    // или service.update(item)
        redirectAttributes.addFlashAttribute(
                "message", "Задача #" + id + " успешно обновлена"
        );
        // перенаправляем на страницу просмотра
        return "redirect:/items/search?id=" + id;
    }
}
