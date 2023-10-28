package live.readscape.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("error")
	val error: Int,

	@field:SerializedName("message")
	val message: String
)

data class Data(

	@field:SerializedName("token")
	val token: String
)
