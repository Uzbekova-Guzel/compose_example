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

package com.google.samples.apps.nowinandroid.ui.lesson16.homework

import androidx.compose.ui.test.ExperimentalTestApi
import com.google.samples.apps.nowinandroid.ui.lesson15.ConfiguredTest
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@OptIn(ExperimentalTestApi::class)
@HiltAndroidTest
class ListsTest : ConfiguredTest() {

    @Test
    fun listsCheckTest() {
        run {
            step("Проверяет первый элемент списка экрана For You") {
                MainScreen.topicsList.childAt<TopicsItem>(0) {
                    image.assertIsDisplayed()
                    title.assertTextEquals("Headlines")
                    plusIcon.assertIsDisplayed()
                }
            }
            step("Включает фильтр по Headlines") {
                MainScreen.topicsList.childAt<TopicsItem>(0) {
                    plusIcon.performClick()
                }
            }
            step("Проверяет что отображается кнопка Checked в Headlines") {
                MainScreen.topicsList.childAt<TopicsItem>(0) {
                    plusIcon.assertIsNotDisplayed()
                    checkedIcon.assertIsDisplayed()
                }
            }
            step("Проверяет первую статью по фильтру Headlines") {
                MainScreen.newsList.childAt<NewsItem>(0) {
                    newsImage.assertIsDisplayed()
                    newsTitle.assertIsDisplayed()
                    newsDate.assertIsDisplayed()
                    newsDescText.assertIsDisplayed()
                    topicsRow.assertIsDisplayed()
                }
            }
        }
    }
}

//tep("Проверка эементов в горизоонтальном списке") {
//    LazyHomeScreen.topicList.childAt<TopicsItem>(0){
//        image.assertIsDisplayed()
//        title.assertIsDisplayed()
//        iconPlus.assertIsDisplayed()
//    }
//    LazyHomeScreen.topicList.childAt<TopicsItem>(1){
//        assertIsDisplayed()
//    }
//    LazyHomeScreen.topicList.childAt<TopicsItem>(2){
//        assertIsDisplayed()
//    }
//}
//step("Клик по топику Compose") {
//    LazyHomeScreen.topicList.childAt<TopicsItem>(2){
//        iconPlus.performClick()
//        checkedIcon.assertIsDisplayed()
//    }
//}
//step("Проверяем что новости подтянулись") {
//    LazyHomeScreen.newsList.childAt<NewsItems>(0){
//        assertIsDisplayed()
//    }
//}