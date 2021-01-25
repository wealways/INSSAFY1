//main
import Main from './views/main/Main.vue'


//로그인 영역
import Login from './views/user/Login.vue'
import Join from './views/user/Join.vue'
import FeedMain from './views/feed/IndexFeed.vue'
import Components from './views/Components.vue'

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
