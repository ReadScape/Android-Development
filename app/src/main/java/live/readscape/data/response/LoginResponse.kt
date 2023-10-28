package live.readscape.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: DataLogin,

	@field:SerializedName("error")
	val error: Int,

	@field:SerializedName("message")
	val message: String
)

data class DataLogin(

	@field:SerializedName("token")
	val token: String
)
