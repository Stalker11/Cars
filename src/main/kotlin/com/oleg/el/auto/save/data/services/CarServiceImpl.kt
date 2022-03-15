package com.oleg.el.auto.save.data.services

import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.repository.CarsRepository
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(private val carsRepository: CarsRepository): CarsService {
    override fun getAllAvailableCars(): List<Car> {
        return carsRepository.getAll()//mutableListOf(Car(SupportCars.LAZ, 1.2f,1500f))
    }

    override fun createCar(car: Car) {
        carsRepository.create(car)//CarDb(model = car.model, age = car.age, price = car.price))
    }

    override fun updateCar(id: Long, car: Car) {
        carsRepository.update(id, car)
    }

    override fun getCarById(id: Long): Car? {
       return carsRepository.getById(id)
    }
}