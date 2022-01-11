package com.example.PerfLabEmulatorCRUD.model;

import javax.persistence.*;

/**
 * Класс - сущность Config.
 * Many-To-One по отношению к классу Emulator. Каскадирование не указано.
 */
@Entity
@Table(name = "configs")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int config_id;
    @Column(name = "name_config")
    private String nameConfig;
    @Column(name = "specification_config")
    private String specificationConfig;

    @ManyToOne(fetch = FetchType.LAZY)
    private Emulator emulator;

    public Config() {
    }

    public Config(String nameConfig, String specificationConfig, Emulator emulator) {
        this.nameConfig = nameConfig;
        this.specificationConfig = specificationConfig;
        this.emulator = emulator;
    }

    public int getConfig_id() {
        return config_id;
    }

    public void setConfig_id(int config_id){
        this.config_id = config_id;
    }

    public String getNameConfig() {
        return nameConfig;
    }

    public void setNameConfig(String nameConfig) {
        this.nameConfig = nameConfig;
    }

    public String getSpecificationConfig() {
        return specificationConfig;
    }

    public void setSpecificationConfig(String specificationConfig) {
        this.specificationConfig = specificationConfig;
    }

    public Emulator getEmulator() {
        return emulator;
    }

    public void setEmulator(Emulator emulators) {
        this.emulator = emulators;
    }

    @Override
    public String toString() {
        return "Config{" +
                "config_id=" + config_id +
                ", nameConfig='" + nameConfig + '\'' +
                ", specificationConfig='" + specificationConfig + '\'' +
                ", emulator=" + emulator +
                '}';
    }
}
