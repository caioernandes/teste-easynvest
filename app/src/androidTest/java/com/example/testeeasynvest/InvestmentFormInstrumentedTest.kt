package com.example.testeeasynvest

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.example.testeeasynvest.ui.investment_form.InvestmentFormActivity
import com.example.testeeasynvest.ui.result_investment.ResultInvestmentActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class InvestmentFormInstrumentedTest {

    @Rule
    @JvmField
    val rule = IntentsTestRule(InvestmentFormActivity::class.java)

    @Test
    fun useAppContext() {
        Espresso.onView(ViewMatchers.withId(R.id.value_investment))
            .perform(ViewActions.typeText("1000"),
                ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.due_date))
            .perform(ViewActions.typeText("11022023"),
                ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.investment_percentage))
            .perform(ViewActions.typeText("90"),
                ViewActions.closeSoftKeyboard())

        Thread.sleep(250)

        Espresso.onView(ViewMatchers.withId(R.id.btn_simulator))
            .perform(ViewActions.click())

        Thread.sleep(8000)

        intended(hasComponent(ResultInvestmentActivity::class.java.name))
    }
}