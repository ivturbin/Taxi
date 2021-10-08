package ru.digitalleague.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalleague.core.model.TaxiDriverInfoModel;

public interface TaxiDriverInfoRepo extends JpaRepository<TaxiDriverInfoModel, Long> {

}
