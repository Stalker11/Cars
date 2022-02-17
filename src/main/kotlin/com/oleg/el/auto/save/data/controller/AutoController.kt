package com.oleg.el.auto.save.data.controller

import com.oleg.el.auto.save.data.nwmodels.Car
import com.oleg.el.auto.save.data.services.CarsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cars")
class AutoController(private val carsService: CarsService) {
    @GetMapping("/all")
    fun getAllAvailableCars(): List<Car> = carsService.getAllAvailableCars()
}