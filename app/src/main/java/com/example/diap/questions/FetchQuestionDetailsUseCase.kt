package com.example.diap.questions

import com.example.diap.Constants
import com.example.diap.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchQuestionDetailsUseCase {

    sealed class Result {
        class Success(val question: QuestionWithBody) : Result()
        object Failure: Result()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    suspend fun fetchQuestion(questionId: String): Result {
        return withContext(Dispatchers.IO){
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    val question = response.body()!!.question
                    return@withContext Result.Success(question)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }

}