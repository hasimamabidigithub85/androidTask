package com.example.androidtask.Utility
import org.json.JSONObject

class Resource<T> private constructor(
    status: Status, data: T?,
    message: String?, jsonObject: JSONObject?
) {
    var status: Status
    val data: T?
    val message: String?
    val jsonObject: JSONObject?

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource<T>(
                Status.SUCCESS,
                data,
                null,
                null
            )
        }

        fun <T> error(data: JSONObject?): Resource<T> {
            return Resource<T>(
                Status.ERROR,
                data as T?,
                null,
                data
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource<T>(
                Status.LOADING,
                data,
                null,
                null
            )
        }
    }

    init {
        this.status = status
        this.data = data as T?
        this.message = message
        this.jsonObject = jsonObject
    }
}