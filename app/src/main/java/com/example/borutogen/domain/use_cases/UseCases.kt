package com.example.borutogen.domain.use_cases

import com.example.borutogen.data.paging_source.SearchHeroesSource
import com.example.borutogen.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.borutogen.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.borutogen.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.example.borutogen.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase
)
