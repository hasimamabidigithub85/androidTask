package medSpell.Activity.Repository


import Network.APIClient
import Network.APIInterface
import androidx.lifecycle.MutableLiveData
import com.example.androidtask.Model.LanguageModel
import com.example.androidtask.Utility.Resource


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SearchApiRepository {
        private val api: APIInterface

        var registerUsers: MutableLiveData<Resource<LanguageModel>>? = null

        fun getMovieListApi(title:String): MutableLiveData<Resource<LanguageModel>>? {

                if (registerUsers == null) {
                        registerUsers = MutableLiveData<Resource<LanguageModel>>()

                }

                GlobalScope.launch {
                        try {
                                coroutineScope {
//                                        val jsonObject = JSONObject()
//                                        jsonObject.put("Token", idToken)
//                                        jsonObject.put("Type", type)
//
//                                        val jsonBody: JsonObject = Gson().fromJson<JsonObject>(
//                                                jsonObject.toString(),
//                                                JsonObject::class.java
//                                        )
                                        val jsonObjectCall: Call<LanguageModel>
                                        try {
                                                jsonObjectCall = APIClient.getClient.getMovieListApi("b9bd48a6",title,"movie")

                                                jsonObjectCall.enqueue(object : Callback<LanguageModel> {
                                                        override fun onResponse(
                                                                call: Call<LanguageModel>,
                                                                response: Response<LanguageModel>) {
                                                                if (response.code() == 200) {
//                                                                        val allUsersFromApi = mutableListOf<LanguageModel>()
//                                                                        allUsersFromApi.add(response.body()!!)

                                                                        registerUsers!!.postValue(Resource.success(response.body()!!))
                                                                }
                                                                else{
//                                                                        val allUsersFromApi = mutableListOf<PrivacyPolicyModel>()
//                                                                        allUsersFromApi.add(response.body()!!)
//                                                                        registerUsers!!.postValue(Resource.success(allUsersFromApi))
//                                                                        assert(response.errorBody() != null)
                                                                        try {
                                                                                registerUsers!!.postValue(
                                                                                        Resource.error(
                                                                                                JSONObject(
                                                                                                        response.errorBody()!!.string())
                                                                                        )
                                                                                )
                                                                        } catch (e: java.lang.Exception) {
                                                                        }
                                                                }

                                                        }
                                                        override fun onFailure(call: Call<LanguageModel>, t: Throwable) {

                                                                t.printStackTrace()
                                                        }
                                                })
                                        }
                                        catch (ex: java.lang.Exception) {
                                                ex.printStackTrace()
                                        }
                                }
                        } catch (ex: java.lang.Exception) {
                                ex.printStackTrace()
                        }
                }

                return registerUsers;
        }

//        fun getPrivacyPolicy(strParameter:String): MutableLiveData<Resource<PrivacyPolicyModel>>? {
//          if(privacyPolicyVideos == null) {
//                  privacyPolicyVideos = MutableLiveData<Resource<PrivacyPolicyModel>>()
//          }
//
//        GlobalScope.launch {
//                try {
////                coroutineScope {
////                    val jsonObject = JSONObject()
////                    jsonObject.put("question_paper_id", "id")
////                    val jsonBody: JsonObject = Gson().fromJson<JsonObject>(
////                        jsonObject.toString(),
////                        JsonObject::class.java
////                    )
//                        val jsonObjectCall: Call<PrivacyPolicyModel>
//                        try {
//                                jsonObjectCall = api.getPrivacyPolicy(strParameter)
//                                jsonObjectCall.enqueue(object : Callback<PrivacyPolicyModel> {
//                                        override fun onResponse(
//                                                call: Call<PrivacyPolicyModel>,
//                                                response: Response<PrivacyPolicyModel>
//                                        ) {
//                                                if (response.code() == 200) {
////                                    val allUsersFromApi = mutableListOf<DictionaryModel?>()
////                                    allUsersFromApi.addAll(response.body())
//                                                        privacyPolicyVideos!!.postValue(
//                                                                Resource.success(
//                                                                        response.body()!!
//                                                                )
//                                                        )
////                                  users.postValue(response.body())
//                                                } else {
//
//                                                }
//                                        }
//
//                                        override fun onFailure(
//                                                call: Call<PrivacyPolicyModel>,
//                                                t: Throwable
//                                        ) {
//                                                t.printStackTrace()
//                                        }
//                                })
//                        } catch (ex: java.lang.Exception) {
//                                ex.printStackTrace()
//                        }
//                } catch (ex: Exception) {
//                }
//        }
//
//
//
//        return privacyPolicyVideos
//    }

        init {

            api= APIClient.getClient

        }

}