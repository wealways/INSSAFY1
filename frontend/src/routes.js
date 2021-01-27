//main
import Main from './views/main/Main.vue'


//로그인 영역
import Login from './views/user/Login.vue'
import Join from './views/user/Join.vue'
import Mypage from '@/views/user/Mypage.vue'


// curation board
import BambooForest from '@/views/curation/bamboo/BambooForest'
import LearnShare from '@/views/curation/learningshare/LearnShare'
import StudyMain from '@/views/curation/study/StudyMain'
import Study from '@/views/curation/study/Study'
import Market from '@/views/curation/market/Market'
import Recruitment from '@/views/curation/recruitment/Recruitment'

//board
import Board from './views/boards/Board.vue'
import PostDetail from './views/boards/PostDetail.vue'
import BoardForm from './views/boards/BoardForm.vue'


//search
import SearchPost from './views/search/SearchPost.vue'
import SearchBoard from './views/search/SearchBoard.vue'


// Chat
import ChatPage from './views/openchat/ChatPage.vue'


//redirect vue
import PageNotFound from './views/redirect/PageNotFound'
import Errors from './views/redirect/Errors'
import JoinSuccess from './views/redirect/JoinSuccess'


import Temp from './views/Main'
import Modify from './views/user/Modify'


export default [

    //main 영역
    {
        path : '/main',
        name : 'Main',
        component : Main
    },
    
    // 사용자 관련 영역    
    {
        path : '/',
        name : 'Login',
        component : Login
    },
    {
        path : '/user/join',
        name : 'Join',
        component : Join
    },
    {
        path : '/user/mypage',
        name : 'Mypage',
        component : Mypage
    },
    
    // Curation board
    {
        path: '/curation/bamboo',
        name: 'BambooForest',
        component: BambooForest
    },
    {
        path: '/curation/learningshare',
        name: 'LearnShare',
        component: LearnShare
    },
    {
        path: '/curation/main/study',
        name: 'StudyMain',
        component: StudyMain
    },
    {
        path: '/curation/study/part',
        name: 'Study',
        component: Study
    },
    {
        path: '/curation/market',
        name: 'Market',
        component: Market
    },
    {
        path: '/curation/recruitment',
        name: 'Recruitment',
        component: Recruitment
    },

    // board
    {
        path : '/boards',
        name : 'Board',
        component : Board
    },
    {
        path: '/boards/post',
        name : 'Post',
        component : PostDetail
    },
    {
        path:'/boards/create',
        name:'BoardForm',
        component: BoardForm
    },

    // 검색 관련 영역
    {
        path : '/post/search',
        name : 'SearchPost',
        component : SearchPost
    },
    {
        path : '/board/search',
        name : 'SearchBoard',
        component : SearchBoard
    },

    // 채팅 관련 영역
    {
        path : '/chat',
        name : 'ChatPage',
        component : ChatPage,
    },

    //redirect 영역
    {
        path: '*',
        redirect: "/404"
    },
    {
        path : "/404",
        name : 'PageNotFound',
        component : PageNotFound
    },
    {
        path : "/errors",
        name : 'Errors',
        component : Errors
    },
    {
        path : "/success/join",
        name : 'JoinSuccess',
        component : JoinSuccess 
    },


    {
        path: "/temp",
        name: "Temp",
        component : Temp,
        props: true
    },
    {
        path : "/user/modify",
        name : "Modify",
        component : Modify
    }
    
]
