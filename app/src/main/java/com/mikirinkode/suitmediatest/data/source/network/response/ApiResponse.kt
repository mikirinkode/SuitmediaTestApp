package com.mikirinkode.suitmediatest.data.source.network.response

import com.google.gson.annotations.SerializedName
import com.mikirinkode.suitmediatest.data.model.UserEntity

data class ApiResponse(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("data")
	val data: List<UserEntity>,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

)