package com.example.architectcoderspracticauno

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasScrollToIndexAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import com.example.architectcoderspracticauno.data.server.MockWebServerRule
import com.example.architectcoderspracticauno.data.server.fromJson
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainInstrumentedTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val mockWebServerRule = MockWebServerRule()

    @get:Rule(order = 3)
    val androidComposeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        mockWebServerRule.server.enqueue(
            MockResponse().fromJson("wizards_gryffindor.json")
        )

        hiltRule.inject()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun click_a_wizard_navigates_to_detail(): Unit = with(androidComposeRule) {
        waitUntilAtLeastOneExists(hasParent(hasScrollToIndexAction()))
        onAllNodes(hasParent(hasScrollToIndexAction()))[0].performClick()

        onAllNodes(hasText("Harry Potter"))[0].assertIsDisplayed()
    }
}