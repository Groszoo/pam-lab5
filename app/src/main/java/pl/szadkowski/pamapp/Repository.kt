package pl.szadkowski.pamapp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class Repository<T> {

    suspend fun <T> callApi(dispatcher: CoroutineDispatcher = Dispatchers.IO, apiCall: suspend () -> T): Resource<T> {
        return withContext(dispatcher) {
            try {
                Resource.success(apiCall.invoke())
            } catch (t: Throwable) {
                Timber.e(t)
                Resource.error(null, t.message)
            }
        }
    }

}