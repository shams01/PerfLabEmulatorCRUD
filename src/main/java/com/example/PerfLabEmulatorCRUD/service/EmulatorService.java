package com.example.PerfLabEmulatorCRUD.service;

import com.example.PerfLabEmulatorCRUD.model.Emulator;
import com.example.PerfLabEmulatorCRUD.repository.EmulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс- Сервис для Emulator. Промежуточный класс между Controller и Repository.
 * EmulatorController делегирует выполнение бизнес-логики в EmulatorService, который в свою очередь связывается с
 * EmulatorRepository.
 */
@Service
public class EmulatorService {
    private List<Emulator> emulators = new ArrayList<>();
    private EmulatorRepository emulatorRepository;

    @Autowired
    public EmulatorService(EmulatorRepository emulatorRepository) {
        this.emulatorRepository = emulatorRepository;
    }

    /**
     * Метод для получения ВСЕХ Emulator из БД.
     * @return - Список Emulator объектов.
     */
    public List<Emulator> getEmulatorsList() {
        return emulatorRepository.findAll();
    }

    /**
     * Метод для получения Emulator из БД.
     * @param id - получаем id и по нему достаем Emulator из БД.
     * @return - возвращаем в EmulatorController объект Emulator.
     */
    public Emulator getEmulatorById(int id) {
        return emulatorRepository.getOne(id);
    }

    /**
     * Метод для удаления Emulator из БД.
     * @param id - получаем id и по нему удаляем Emulator из БД.
     */
    public void deleteEmulatorById(int id) {
        emulatorRepository.deleteById(id);
    }

    /**
     * Метод для сохранения Emulator в БД.
     * @param emulator - получаем Emulator и сохраняем его в БД.
     */
    public void saveEmulator(Emulator emulator) {
        emulatorRepository.save(emulator);
    }
}

