package com.example.architectcoders.domain.wizard.usecases

import com.example.architectcoders.domain.wizard.data.HogwartsRepository
import com.example.architectcoders.domain.wizard.entities.WizardModel

class ToggleFavoriteUseCase(private val hogwartsRepository: HogwartsRepository) {
    suspend operator fun invoke(wizard: WizardModel) = hogwartsRepository.toggleFavourite(wizard)
}