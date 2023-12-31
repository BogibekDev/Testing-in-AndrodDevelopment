package dev.bogibek.testing.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dev.bogibek.testing.R
import dev.bogibek.testing.data.email
import dev.bogibek.testing.data.password
import org.hamcrest.Matchers.containsString
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loginWithValidCredentials() {
        //typing valid email to etEmail then close keyboard
        onView(withId(R.id.et_email)).perform(typeText(email), ViewActions.closeSoftKeyboard())

        //typing valid password to etPassword then close keyboard
        onView(withId(R.id.et_password)).perform(
            typeText(password),
            ViewActions.closeSoftKeyboard()
        )

        //clicking bLogin
        onView(withId(R.id.b_login)).perform(ViewActions.click())

        //checking contains my email into tvAbout
        onView(withId(R.id.tv_about)).check(matches(withText(containsString(email))))

    }

}