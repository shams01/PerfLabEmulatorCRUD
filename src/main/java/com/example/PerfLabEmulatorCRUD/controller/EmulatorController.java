package com.example.PerfLabEmulatorCRUD.controller;

import com.example.PerfLabEmulatorCRUD.model.Emulator;
import com.example.PerfLabEmulatorCRUD.service.EmulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Класс - контроллер для Emulator.
 * Ловит все запросы от клиента связанные с Emulator, взаимодействует с EmulatorService.
 * По итогу возвращает ответ клиенту.
 */
@Controller
@RequestMapping("/emulators")
public class EmulatorController {
    private EmulatorService emulatorService;

    @Autowired
    public void setConfigService(EmulatorService emulatorService) {
        this.emulatorService = emulatorService;
    }

    /**
     * Выводит на страницу emulator-list.html список всех эмуляторов, которые находятся в БД.
     * Получаем из EmulatorService список эмуляторов.
     * @param model - привязываем список эмуляторов к Model.
     * @return - переадресовываемся на страницу emulator-list.html, где будет выводится список эмуляторов.
     */
    @GetMapping("/list")
    public String getAllEmulatorConfig(Model model) {
        List<Emulator> emulators = emulatorService.getEmulatorsList();
        model.addAttribute("emulators", emulators);
        return "emulator-list";
    }

    /**
     * Запрос типа Get на добавление Emulator. Данный метод перебрасывает на страницу с формой.
     * @param emulator - объект Emulator неявно привязывается к Model и передается на страничку emulator-add.html.
     * @return - переадресовываем на страничку emulator-add.html, на которой расположена форма.
     */
    @GetMapping("/add")
    public String addEmulatorForm(Emulator emulator) {
        return "emulator-add";
    }

    /**
     * Запрос типа Post со странички emulator-add.html , который посылает наша форма.
     * Сохраняем полученный эмулятор в БД.
     * @param emulator - получаем Emulator из формы.
     * @return - делаем редирект на /emulators/list
     */
    @PostMapping("/add")
    public String addEmulator(Emulator emulator) {
        emulatorService.saveEmulator(emulator);
        return "redirect:/emulators/list";
    }

    /**
     * Запрос типа Get для удаления Emulator.
     * @param id - получаем id и по нему находим нужный Emulator.
     * @return - делаем редирект на /emulators/list
     */
    @GetMapping("/delete/{id}")
    public String deleteEmulator(@PathVariable int id) {
        emulatorService.deleteEmulatorById(id);
        return "redirect:/emulators/list";
    }

    /**
     * Запрос типа Get на редактирование Emulator. Данный метод перебрасывает на страницу с формой.
     * @param id - получаем id и по нему находим нужный Emulator.
     * @param model - связавыем наш Emulator с Model и передаем ее на страничку emulator-edit.html.
     * @return - переадресовываем на страничку emulator-edit.html, на которой расположена форма.
     */
    @GetMapping("/edit/{id}")
    public String editEmulatorForm(@PathVariable int id, Model model) {
        Emulator emulator = emulatorService.getEmulatorById(id);
        model.addAttribute("emulator", emulator);
        return "emulator-edit";
    }

    /**
     * Запрос типа Post со странички emulator-edit.html , который посылает наша форма.
     * Сохраняем полученный эмулятор в БД.
     * @param emulator - получаем Emulator из формы.
     * @return - делаем редирект на /emulators/list
     */
    @PostMapping("/edit")
    public String editEmulator(Emulator emulator) {
        emulatorService.saveEmulator(emulator);
        return "redirect:/emulators/list";
    }
}
