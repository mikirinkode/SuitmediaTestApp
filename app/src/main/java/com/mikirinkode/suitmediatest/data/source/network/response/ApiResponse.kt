package com.mikirinkode.suitmediatest.data.source.network.response

import com.google.gson.annotations.SerializedName
import com.mikirinkode.suitmediatest.data.model.UserEntity

data class ApiResponse(

	@field:SerializedName("data")
	val data: List<UserEntity>,
)