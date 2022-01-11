package com.example.PerfLabEmulatorCRUD.service;

import com.example.PerfLabEmulatorCRUD.model.Config;
import com.example.PerfLabEmulatorCRUD.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс- Сервис для Config. Промежуточный класс между Controller и Repository.
 * ConfigController делегирует выполнение бизнес-логики в ConfigService, который в свою очередь связывается с
 * ConfigRepository.
 */
@Service
public class ConfigService {
    private ConfigRepository configRepository;

    @Autowired
    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    /**
     * Метод для сохранения Config в БД.
     * @param config - получаем Config и сохраняем его в БД.
     */
    public void saveConfig(Config config){
        configRepository.save(config);
    }

    /**
     * Метод для получения Config из БД.
     * @param id - получаем id и по нему достаем Config из БД.
     * @return - возвращаем в ConfigController объект Config.
     */
    public Config getConfigById(int id) {
        return configRepository.getOne(id);
    }

    /**
     * Метод для удаления Config из БД.
     * @param id - получаем id и по нему удаляем Config из БД.
     */
    public void deleteConfigById(int id){
        configRepository.deleteById(id);
    }
}

