package com.belajar.materialjetpackcompose.data

import com.belajar.materialjetpackcompose.R
import com.belajar.materialjetpackcompose.model.DogModel

class DataSource {
    fun loadData() : List<DogModel> {
        return listOf(
            DogModel(R.drawable.koda,R.string.dog_name_1,2,R.string.dog_description_1),
            DogModel(R.drawable.lola,R.string.dog_name_2,2,R.string.dog_description_2),
            DogModel(R.drawable.frankie,R.string.dog_name_3,2,R.string.dog_description_3),
            DogModel(R.drawable.nox,R.string.dog_name_4,2,R.string.dog_description_4),
            DogModel(R.drawable.faye,R.string.dog_name_5,2,R.string.dog_description_5),
            DogModel(R.drawable.bella,R.string.dog_name_6,2,R.string.dog_description_6),
            DogModel(R.drawable.moana,R.string.dog_name_7,2,R.string.dog_description_7),
            DogModel(R.drawable.tzeitel,R.string.dog_name_8,2,R.string.dog_description_8),
            DogModel(R.drawable.leroy,R.string.dog_name_9,2,R.string.dog_description_9),


            )
    }
}