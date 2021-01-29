import Vue from "vue";

// 설치한 fontawesome-svg-core & vue-fontawesome
import { library } from "@fortawesome/fontawesome-svg-core"
import { FontAwesomeIcon} from "@fortawesome/vue-fontawesome"

// 설치한 아이콘 파일에서 해당 아이콘만 불러오기
import { faFolder, faThList, faCommentAlt, faBookmark, faTimes, faStar } from "@fortawesome/free-solid-svg-icons"
import {  } from "@fortawesome/free-regular-svg-icons"

// 불러온 아이콘을 라이브러리에 담기

// 1. my page 아이콘들
library.add(faFolder, faThList, faCommentAlt, faBookmark, faTimes, faStar);

// Vue 템플릿에서 사용할 수 있게 등록
Vue.component("font-awesome-icon", FontAwesomeIcon);