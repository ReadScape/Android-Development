package live.readscape.data.response

import com.google.gson.annotations.SerializedName

data class SignupResponse(

	@field:SerializedName("error")
	val error: Int,

	@field:SerializedName("message")
	val message: String
)
