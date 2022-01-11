package com.example.PerfLabEmulatorCRUD.controller;

import com.example.PerfLabEmulatorCRUD.model.Config;
import com.example.PerfLabEmulatorCRUD.service.ConfigService;
import com.example.PerfLabEmulatorCRUD.service.EmulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс - контроллер для Config.
 * Ловит все запросы от клиента связанные с Config, взаимодействует с ConfigService и EmulatorService.
 * По итогу возвращает ответ клиенту.
 */
@Controller
@RequestMapping("configs/")
public class ConfigController {
    private EmulatorService emulatorService;
    private ConfigService configService;

    @Autowired
    public ConfigController(EmulatorService emulatorService, ConfigService configService) {
        this.emulatorService = emulatorService;
        this.configService = configService;
    }

    /**
     * Запрос типа Get на добавление Конфига. Данный метод перебрасывает на страницу с формой.
     * @param id - получаем id объекта Emulator , что бы связать Config с нужным Emulator.
     * @param model - связавыем наш Config с Model и передаем ее на страничку config-add.html.
     * @return - переадресовываем на страничку config-add.html, на которой расположена форма.
     */
    @GetMapping("/add/{id}")
    public String addConfigForm(@PathVariable int id, Model model) {
        Config config = new Config();
        config.setEmulator(emulatorService.getEmulatorById(id));
        model.addAttribute("config", config);
        return "config-add";
    }

    /**
     * Запрос типа Post со странички config-add.html , который посылает наша форма.
     * Связываем полученный Config с нужным эмулятором и Сохраняем его в БД.
     * @param id - получаем id объекта Emulator , что бы связать Config с нужным Emulator.
     * @param config - получаем Config из формы.
     * @return - делаем редирект на /emulators/list
     */
    @PostMapping("/add/{id}")
    public String addConfig(@PathVariable int id, Config config) {
        config.setEmulator(emulatorService.getEmulatorById(id));
        configService.saveConfig(config);
        return "redirect:/emulators/list";
    }

    /**
     * Запрос типа Get для удаления Config.
     * @param id - получаем id и по нему находим нужный Config.
     * @return - делаем редирект на /emulators/list
     */
    @GetMapping("/delete/{id}")
    public String deleteConfig(@PathVariable int id) {
        configService.deleteConfigById(id);
        return "redirect:/emulators/list";
    }

    /**
     * Запрос типа Get на редактирование Конфига. Данный метод перебрасывает на страницу с формой.
     * @param id - получаем id и по нему находим нужный Config.
     * @param model - связавыем наш Config с Model и передаем ее на страничку config-edit.html.
     * @return - переадресовываем на страничку config-edit.html, на которой расположена форма.
     */
    @GetMapping("/edit/{id}")
    public String updateConfigForm(@PathVariable int id, Model model) {
        Config config = configService.getConfigById(id);
        model.addAttribute("config", config);
        return "config-edit";
    }

    /**
     * Запрос типа Post со странички config-edit.html , который посылает наша форма.
     * Связываем полученный Config с нужным эмулятором и Сохраняем его в БД.
     * @param id - получаем id объекта Emulator , что бы связать Config с нужным Emulator.
     * @param config - получаем Config из формы.
     * @return - делаем редирект на /emulators/list
     */
    @PostMapping("/edit/{id}")
    public String updateConfig(@PathVariable int id, Config config) {
        config.setEmulator(emulatorService.getEmulatorById(id));
        configService.saveConfig(config);
        return "redirect:/emulators/list";
    }
}

