package com.oleg.el.auto.save.data.nwmodels

data class Car(val model: SupportCars, val age: Float, val price: Float)

enum class SupportCars{
    AUDI,
    RENO,
    ZAZ,
    LAZ,
    MAZ
}