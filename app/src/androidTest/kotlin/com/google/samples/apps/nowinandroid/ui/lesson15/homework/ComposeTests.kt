/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lesson15.homework

import com.google.samples.apps.nowinandroid.ui.lesson15.ConfiguredTest
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class ComposeTests : ConfiguredTest() {

    @Test
    fun elementsCheckTest() {
        run {
            step("Проверяет елементы экрана For You") {
                ForYouScreen {
                    toolbarSearchIcon.assertIsDisplayed()
                    toolbarTitle.assertTextEquals("Now in Android")
                    toolbarSettingsIcon.assertIsDisplayed()
                    titleText.assertTextEquals("What are you interested in?")
                    subtitleText.assertTextContains("Updates from topics you follow will appear here", ignoreCase = true, substring = true)
                    doneButton.assertIsDisplayed()
                    doneButtonText.assertTextEquals("Done")
                }
            }
            step("Переходит на экран поиска") {
                ForYouScreen.toolbarSearchIcon.performClick()
            }
            step("Проверяет елементы экрана Search") {
                SearchScreen {
                    backButton.assertIsDisplayed()
                    searchIcon.assertIsDisplayed()
                    searchTextField.assertIsDisplayed()
                    recentSearchesText.assertTextEquals("Recent searches")
                }
            }
        }
    }
}
