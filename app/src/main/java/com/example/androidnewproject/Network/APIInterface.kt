package Network

import com.example.androidtask.Model.LanguageModel
import retrofit2.Call
import retrofit2.http.*
interface APIInterface {

//    @GET("getAllVideoByUser")
//    fun getAllVideos(
//        @Header("Authorization") token: String?,
//        @Query("categoryId") categoryId: String?,
//        @Query("title") title: String?
//    ): Call<VideoModel>

//    @GET("getDictionarySearch")
//    fun getAllRecommendVideo(
//        @Query("searchName") searchName: String?,
//    ): Call<DictionaryModel>

//    "getPrivacyPolicy?termStatuse=1" for privacy policy
    @GET("/")
    fun getMovieListApi(
        @Query("apiKey") apiKey:String?,
        @Query("s") s:String?,
        @Query("type") type:String?
    ): Call<LanguageModel>

//    @Header("Authorization") token: String?,
//    @POST("deviceCredential")
//    fun getDeviceCredential(
//        @Body jsonObject: JsonObject?
//    ): Call<PrivacyPolicyModel>

//    http://www.omdbapi.com/?apikey=b9bd48a6&s=Marvel&type=movie

//    @Multipart
//    @POST("videoupload")
//    fun videoUpload(
//        @Header("Authorization") token: String?,
//        @Part file: Part?
//    ): Call<VideoUploadModel?>?

//    @POST("createChannelByUser")
//    fun getCreateChannelByUser(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<CreateChannelModel>
//
//
//    @POST("createPlayList")
//    fun getCreatePlayList(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<CreatePlayListModel>
//
//    @GET("getPlayList")
//    fun getPlayListApi(
//        @Header("Authorization") token: String?,
//    ): Call<PlayListModel>
//
//    @PUT("updatePlayList")
//    fun getUpdatePlayList(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<PlayListModel>
//
//
//    @PUT("updateLanguage")
//    fun getUpdateLanguage(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<CategoryByUserModel>
//
//
//    @Multipart
//    @POST("updateChannelByUser")
//    fun updateChannelByUser(
//        @Header("Authorization") token: String?,
//        @Part("id") title: RequestBody?,
//        @Part("channeldescription") description: RequestBody?,
//        @Part coverImage: MultipartBody.Part?,
//        @Part profilePic: MultipartBody.Part?,
//    ): Call<UpdateChannelModel>
//
//
//
//
//    @Multipart
//    @POST("uploadVideoByUser")
//    fun videoUpload(
//        @Header("Authorization") token: String?,
//        @Part file: MultipartBody.Part?,
//        @Part("title") title: RequestBody?,
//        @Part("description") description: RequestBody?,
//        @Part thumbnail: MultipartBody.Part?,
//        @Part("categoryId") categoryId: RequestBody?,
//        @Part("videocontent") videocontent: RequestBody?,
//        @Part("videotag") videotag: RequestBody?,
//        @Part("type") type: RequestBody?,
//        @Part("isPublished") isPublished: RequestBody?,
//    ): Call<VideoUploadModel>
//
//    @POST("addFavouriteVideo")
//    fun getAddFavouriteVideo(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<AddFavoriteVideosModel>
//
//    @POST("addVideoWatchHistory")
//    fun getAddToWatchHistory(
//        @Header("Authorization") token: String?,
//        @Query("video_id") videoId: String?
//    ): Call<AddHistoryModel>
//
//    @POST("videoreport")
//    fun getReportApi(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<VideoReportModel>
//
//
//    @POST("subcribeChannel")
//    fun getSubcribeChannel(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<AddFavoriteVideosModel>
//
//
//    @POST("addVideoToPlaylist")
//    fun getAddVideoToPlaylistApi(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<PlayListModel>
//
//    @POST("watchLater")
//    fun getAddVideoToWatchlistApi(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<AddToWatchListModel>
//
//
//
//
//    @POST("likeOrDislike")
//    fun getLikeOrDislike(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<LikeDisLikeModel>
//
//
//    @PUT("unlikeOrunDislike")
//    fun getUnlikeOrUnDislike(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<LikeDisLikeModel>
//
//
//    @PUT("unSubscribeChannel")
//    fun getUnSubscribeChannel(
//        @Header("Authorization") Authorization: String?,
//        @Query("channel_Id") channel_Id: String?
//    ): Call<UnsubscribeChannelModel>
//
//
//    @DELETE("deleteComment")
//    fun getDeleteApi(
//        @Header("Authorization") Authorization: String?,
//        @Query("commentId") commentId: String?
//    ): Call<DeleteCommentModel>
//
//    @DELETE("deletePlayList")
//    fun getDeletePlayListApi(
//        @Header("Authorization") Authorization: String?,
//        @Query("id") id: String?
//    ): Call<DeleteCommentModel>
//
//    @DELETE("removeVideoFromPlaylist")
//    fun getRemoveVideoFromPlaylistApi(
//        @Header("Authorization") Authorization: String?,
//        @Query("id") id: String?,
//        @Query("videoId") videoId: String?
//    ): Call<DeleteCommentModel>
//
//
//
////  @HTTP(method = "DELETE", path = "watchlaterDeleteByWatchId", hasBody = true)
//
//    @DELETE("watchLaterDeleteByWatchId")
//    fun getRemoveVideoFromWatchLaterlistApi(
//        @Header("Authorization") Authorization: String?,
//        @Query("watchId") watchId: String?
////      @Body jsonObject: JsonObject
//    ): Call<DeleteWatchLaterListModel>
//
//
//    @PUT("updateComment")
//    fun getUpdateComment(
//        @Header("Authorization") Authorization: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<UpdateCommentModel>
//
//
//    @POST("addVideoHistory")
//    fun getAddHistoryVideo(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<AddFavoriteVideosModel>
//
//
//
//
//    @POST("addComment")
//    fun getAddComments(
//        @Header("Authorization") token: String?,
//        @Body jsonObject: JsonObject?
//    ): Call<AddCommentsModel>
//
//
//    @GET("getVideoDetailsByIdUser")
//    fun getVideoDetailsByIdUser(
//        @Header("Authorization") token: String?,
//        @Query("id") id:String?,
//        @Query("userId") userId:String?
//    ): Call<GetVideoDetailsUserModel>
//
//
//    @GET("getComment")
//    fun getComment(
//        @Header("Authorization") token: String?,
//        @Query("videoId") id:String?,
//        @Query("userId") userId:String?
//    ): Call<GetCommentsModel>
//
//
//
//    @GET("getwatchlaterList")
//    fun getHistoryVideo(
//        @Header("Authorization") token: String?,
//    ): Call<GetHistoryModel>
//
//    @GET("getPlayListById")
//    fun getPlayListByIdApi(
//        @Header("Authorization") token: String?,
//        @Query("id") id:String?,
//    ): Call<GetPlayListByIdModel>
//
//    @GET("getWatchLaterList")
//    fun getWatchLaterListApi(
//        @Header("Authorization") token: String?,
//        @Query("id") id:String?,
//    ): Call<WatchLaterListModel>
//
//    @GET("getChannelUser")
//    fun getChannelUser(
//        @Header("Authorization") token: String?,
//    ): Call<ChannelUserModel>
//
//    @GET("getUserSubscribeDetails")
//    fun getUserSubscribeDetails(
//        @Header("Authorization") token: String?,
//    ): Call<UserSubscriptionModel>
//
//
//    @GET("getCategoryByUser")
//    fun getCategoryByUser(
//        @Header("Authorization") token: String?,
//    ): Call<CategoryByUserModel>
//
//
//
//    @GET("getAllNotification")
//    fun getAllNotification(
//        @Header("Authorization") token: String?,
//    ): Call<NotificationModel>
//
//
//    @GET("getVideoTypeContentList")
//    fun getVideoTypeContentlist(
//        @Header("Authorization") token: String?,
//    ): Call<VideoCategoryTypeModel>
//
//    @GET("getFavouriteVideo")
//    fun getFavoriteVideo(
//        @Header("Authorization") token: String?,
//    ): Call<FavoriteListModel>

}