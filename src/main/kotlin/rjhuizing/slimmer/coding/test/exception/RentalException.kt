package rjhuizing.slimmer.coding.test.exception

import java.lang.Exception

/**
 * Custom exception for rental-related errors
 */
class RentalException : Exception {

    constructor(message: String) : super(message) {}
    constructor(message: String, cause: Throwable) : super(message, cause) {}
}