import axios from "axios";

export default async function api({
  method,
  url,
  data = null,
  isFormData = false,
}) {
  // TODO: 토큰을 저장하고 있는 곳에서 가져오기
  const accessToken = "";

  try {
    const response = await axios({
      data,
      method,
      baseURL: REACT_APP_API_URL + url,
      headers: {
        "Content-Type": isFormData
          ? 'multipart/form-data; boundary="boundary"'
          : "application/json",
        Authorization: accessToken ? `Bearer ${accessToken}` : "",
      },
    });

    return response.data;
  } catch (error) {
    console.error("[/api/src/api.js] API 요청 에러 발생:", error);
  }
}
