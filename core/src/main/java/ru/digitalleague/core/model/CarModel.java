package ru.digitalleague.core.model;

import java.time.OffsetDateTime;

public class CarModel {

    private Long carId;

    /**
     * Модель авто (должна быть ENUM).
     */
    private String carModel;

    /**
     * Дата создания.
     */
    private OffsetDateTime createDttm;

}
