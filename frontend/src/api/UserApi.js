/*
 User API 예시
 */
import http from './http'
import axios from "axios";


const requestLogin = (data,callback,errorCallback) => {
    //백앤드와 로그인 통신하는 부분
    var result = null;

    axios
        .get('http://localhost:8080/account/login?email='+data.email+'&password='+data.password)
        .then((response) => {
            console.log(response);
            result = response;
        });
    
    callback(
        result
    );

}

const UserApi = {
    requestLogin:(data,callback,errorCallback)=>requestLogin(data,callback,errorCallback)
}

export default UserApi
