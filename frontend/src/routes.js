import Login from './views/user/Login.vue'
import Join from './views/user/Join.vue'
import FeedMain from './views/feed/IndexFeed.vue'
import Components from './views/Components.vue'

//board
import Board from './views/boards/Board.vue'
import PostDetail from './views/boards/PostDetail.vue'

//redirect vue
import PageNotFound from './views/redirect/PageNotFound'
import Errors from './views/redirect/Errors'
import JoinSuccess from './views/redirect/JoinSuccess'

import Main from './views/Main'
import Modify from './views/user/Modify'

export default [


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
        path : '/feed/main',
        name : 'FeedMain',
        component : FeedMain
    },
    {
        path : '/components',
        name : 'Components',
        component : Components
    },
    //board
    {
        path : '/boards',
        name : 'Baord',
        component : Board
    },
    {
        path: '/boards/post',
        name : 'Post',
        component : PostDetail
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
        path: "/main",
        name: "Main",
        component : Main,
        props: true
    },
    {
        path : "/user/modify",
        name : "Modify",
        component : Modify
    }
    
]
