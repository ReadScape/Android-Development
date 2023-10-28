package live.readscape.data.response

import com.google.gson.annotations.SerializedName

data class AkunResponse(

	@field:SerializedName("data")
	val data: DataAkun,

	@field:SerializedName("error")
	val error: Int,

	@field:SerializedName("message")
	val message: String
)

data class DataAkun(

	@field:SerializedName("privacy")
	val privacy: String,

	@field:SerializedName("share")
	val share: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)
