//package com.mikirinkode.suitmediatest.data.source.network
//
//import android.view.View
//import androidx.paging.CombinedLoadStates
//import androidx.paging.PagingData
//import com.mikirinkode.suitmediatest.data.model.UserEntity
//
//data class ListViewState(
//    val page: PagingData<UserEntity>? = null,
//    val adapterList: List<UserEntity> = emptyList(),
//    val errorMessageResource: Int? = null,
//    val errorMessage: String? = null,
//    val loadingStateVisibility: Int? = View.GONE,
//    val errorVisibility: Int? = View.GONE
//): BaseViewState
//
//sealed class ViewEffect: BaseViewEffect {
//    data class TransitionToScreen(val photo: UserEntity) : ViewEffect()
//}
//
//sealed class Event: BaseEvent {
//    object SwipeToRefreshEvent: Event()
//    data class LoadState(val state: CombinedLoadStates): Event()
//    data class ListItemClicked(val item: UserEntity): Event()
//    // Suspended
//    object ScreenLoad: Event()
//}
//
//sealed class Result: BaseResult {
//    data class Error(val errorMessage: String?): Result()
//    data class Content(val content: PagingData<UserEntity>): Result()
//    //data class ItemClickedResult(val item: UserEntity, val sharedElement: View) : Result()
//}
