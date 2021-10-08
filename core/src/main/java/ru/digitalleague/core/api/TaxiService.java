package ru.digitalleague.core.api;

import org.springframework.stereotype.Service;
import ru.digitalleague.core.model.OrderDetails;

/**
 * Сервис отправки информации о заказе.
 */
@Service
public interface TaxiService {

    /**
     * Информируем такси о поступлении заказа.
     */
    String notifyTaxi(OrderDetails orderDetails);

}
