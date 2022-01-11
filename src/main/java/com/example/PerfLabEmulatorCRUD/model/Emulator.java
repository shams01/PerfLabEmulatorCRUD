package com.example.PerfLabEmulatorCRUD.model;

import javax.persistence.*;
import java.util.List;

/**
 * Класс - сущность Emulator.
 * One-To-Many по отношению к Config. Каскадирование - Remove. То есть если удалим какой-то эмулятор , то удалятся и все конфиги
 * связанные с ним.
 */
@Entity
@Table(name = "emulators")
public class Emulator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emulator;

    @Column(name = "name_emulator")
    private String nameEmulator;

    @OneToMany(mappedBy = "emulator", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Config> configList;

    public Emulator() {
    }

    public Emulator(String nameEmulator, List<Config> configList) {
        this.nameEmulator = nameEmulator;
        this.configList = configList;
    }

    public void setId_emulator(int id_emulator) {
        this.id_emulator = id_emulator;
    }

    public int getId_emulator() {
        return id_emulator;
    }

    public String getNameEmulator() {
        return nameEmulator;
    }

    public void setNameEmulator(String nameEmulator) {
        this.nameEmulator = nameEmulator;
    }

    public List<Config> getConfigList() {
        return configList;
    }

    public void addConfig(Config config) {
        configList.add(config);
    }
}
