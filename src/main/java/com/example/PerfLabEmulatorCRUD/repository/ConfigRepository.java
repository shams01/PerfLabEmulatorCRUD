package com.example.PerfLabEmulatorCRUD.repository;

import com.example.PerfLabEmulatorCRUD.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс - репозиторий для Config. Расширяет интерфейс JpaRepository
 * который в данном случае дает дефолтные API для работы с БД.
 */
@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {
}

