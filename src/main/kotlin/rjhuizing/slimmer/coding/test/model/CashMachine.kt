package rjhuizing.slimmer.coding.test.model

import rjhuizing.slimmer.coding.test.exception.RentalException
import kotlin.math.round

/**
 * Owns the cashmashine functionality
 * todo test methods
 */
object CashMachine {

    /**
     * Calculate which notes and coins should be returned to customer.
     * Throws exception in customer did not enter enough money.
     */
    fun calculateCashback(
        paymentAmount: Double, enteredAmounts: Array<AcceptedNotesAndCoins>
    ): ArrayList<AcceptedNotesAndCoins> {
        val moneyEntered = enteredAmounts.sumOf { it.worth }
        if (moneyEntered < paymentAmount) {
            throw RentalException("Entered total is $$moneyEntered. Please enter at least $$paymentAmount.")
        }
        var moneyBack = moneyEntered - paymentAmount
        moneyBack = roundMoneyBack(moneyBack)
        return getReturnCoinsAndNotes(moneyBack)
    }

    /**
     * round the change to specified value
     */
    fun roundMoneyBack(moneyBack: Double): Double {
        var centsBack = moneyBack % round(moneyBack - 0.5)
        if (centsBack.isNaN()) centsBack = 0.0
        return round(moneyBack - 0.5) + when (centsBack) {
            in 0.0..0.20 -> 0.20
            in 0.21..0.40 -> 0.40
            in 0.4..0.5 -> 0.5
            in 0.5..0.6 -> 0.6
            in 0.6..0.7 -> 0.7
            in 0.7..0.8 -> 0.8
            in 0.8..0.9 -> 0.9
            in 0.9..1.0 -> 1.0
            else -> 0.0
        }
    }

    /**
     * Calculate optimal returns of coins and bank-notes
     */
    fun getReturnCoinsAndNotes(moneyBack: Double): ArrayList<AcceptedNotesAndCoins> {
        val toReturn = arrayListOf<AcceptedNotesAndCoins>()
        var remainder = moneyBack
        while (remainder > 0) {
            val biggestSubtract = AcceptedNotesAndCoins.values().find { remainder - it.worth >= 0 } ?: break
            toReturn.add(biggestSubtract)
            remainder -= biggestSubtract.worth
        }
        return toReturn
    }

    enum class AcceptedNotesAndCoins(var worth: Double) {
        FIFTY(50.0),
        TWENTY(20.0),
        TEN(10.0),
        FIVE(5.0),
        TWO(2.0),
        ONE(1.0),
        FIFTY_C(0.50),
        TWENTY_C(0.20),
    }
}