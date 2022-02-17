package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.nwmodels.SupportCars
import org.springframework.stereotype.Service

@Service
class CarServiceImpl: CarsService {
    override fun getAllAvailableCars(): List<Car> {
        return mutableListOf(Car(SupportCars.LAZ, 1.2f,1500f))
    }
}