import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import tushufenleiList from '../pages/tushufenlei/list'
import tushufenleiDetail from '../pages/tushufenlei/detail'
import tushufenleiAdd from '../pages/tushufenlei/add'
import bijileixingList from '../pages/bijileixing/list'
import bijileixingDetail from '../pages/bijileixing/detail'
import bijileixingAdd from '../pages/bijileixing/add'
import rementushuList from '../pages/rementushu/list'
import rementushuDetail from '../pages/rementushu/detail'
import rementushuAdd from '../pages/rementushu/add'
import xinshuxinxiList from '../pages/xinshuxinxi/list'
import xinshuxinxiDetail from '../pages/xinshuxinxi/detail'
import xinshuxinxiAdd from '../pages/xinshuxinxi/add'
import yuedubijiList from '../pages/yuedubiji/list'
import yuedubijiDetail from '../pages/yuedubiji/detail'
import yuedubijiAdd from '../pages/yuedubiji/add'
import rementushuChapter from '../pages/rementushu/chapter'
import xinshuxinxiChapter from '../pages/xinshuxinxi/chapter'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'tushufenlei',
					component: tushufenleiList
				},
				{
					path: 'tushufenleiDetail',
					component: tushufenleiDetail
				},
				{
					path: 'tushufenleiAdd',
					component: tushufenleiAdd
				},
				{
					path: 'bijileixing',
					component: bijileixingList
				},
				{
					path: 'bijileixingDetail',
					component: bijileixingDetail
				},
				{
					path: 'bijileixingAdd',
					component: bijileixingAdd
				},
				{
					path: 'rementushu',
					component: rementushuList
				},
				{
					path: 'rementushuDetail',
					component: rementushuDetail
				},
				{
					path: 'rementushuAdd',
					component: rementushuAdd
				},
				{
					path: 'xinshuxinxi',
					component: xinshuxinxiList
				},
				{
					path: 'xinshuxinxiDetail',
					component: xinshuxinxiDetail
				},
				{
					path: 'xinshuxinxiAdd',
					component: xinshuxinxiAdd
				},
				{
					path: 'yuedubiji',
					component: yuedubijiList
				},
				{
					path: 'yuedubijiDetail',
					component: yuedubijiDetail
				},
				{
					path: 'yuedubijiAdd',
					component: yuedubijiAdd
				},
				{
					path: 'rementushuChapter',
					component: rementushuChapter
				},
				{
					path: 'xinshuxinxiChapter',
					component: xinshuxinxiChapter
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
