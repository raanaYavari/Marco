package com.raana.marco.util

import io.ktor.client.call.*
import io.ktor.client.plugins.*
import kotlinx.coroutines.runBlocking


sealed interface Failure {
    fun getErrorMessage(): String?

    object Unknown : Failure {
        override fun getErrorMessage(): String? {
            return "Unknown Error!"
        }
    }

    sealed class NetworkFailure(val exception: Exception) : Failure {

        override fun getErrorMessage(): String? {
            return exception.message
        }

        class RedirectException(
            exception: RedirectResponseException,
            private val localizedMessage: String? = null
        ) : NetworkFailure(exception) {

            override fun getErrorMessage(): String? {
                return localizedMessage ?: exception.message
            }
        }

        class ClientException(
            exception: ClientRequestException,
            private val localizedMessage: String? = null
        ) :
            NetworkFailure(exception) {

            override fun getErrorMessage(): String? {
                return localizedMessage ?: exception.message
            }
        }

        class ServerException(exception: ServerResponseException) : NetworkFailure(exception)

        class UnknownException(exception: Exception) :
            NetworkFailure(exception)
    }

    sealed interface DatabaseFailure : Failure {

        override fun getErrorMessage(): String? {
            return "Database Error!"
        }

        sealed interface FindFailure : DatabaseFailure {
            object ItemNotFoundInDb : FindFailure
        }

        sealed interface InsertFailure : DatabaseFailure {
            object ItemNotInserted : InsertFailure
        }

        sealed interface ReadFailure : DatabaseFailure {
            object EmptyList : ReadFailure
        }
    }

    sealed interface SettingsFailure : Failure {
        override fun getErrorMessage(): String? {
            return "Settings Error!"
        }

        class SettingsNotFound<T>(val initialData: T? = null) : SettingsFailure
    }

}