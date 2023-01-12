package com.mikirinkode.suitmediatest.data.source.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mikirinkode.suitmediatest.data.model.UserEntity
import com.mikirinkode.suitmediatest.utils.Constants.NETWORK_PAGE_SIZE
import com.mikirinkode.suitmediatest.utils.Constants.STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException


class UserPagingSource(
    private val service: ApiService
) : PagingSource<Int, UserEntity>() {

    override fun getRefreshKey(state: PagingState<Int, UserEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserEntity> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX
            val response = service.getUserList(position)
            val users = response.data

            LoadResult.Page(
                data = users,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position-1,
                nextKey = if(users.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}