<template>
<div class="home-preview" :style='{"width":"100%","margin":"10px auto"}'>
	<el-row type="flex" :gutter="5" justify="center" style="width: 100%">
		<el-col :span="3" v-if="queryList.length>1">
			<el-select v-model="queryIndex">
				<el-option
				  v-for="(item,index) in queryList"
				  :key="index"
				  :label="item.queryName"
				  :value="index"
				></el-option>
			</el-select>
		</el-col>
		<el-col :span="3" v-if="queryIndex==0">
			<el-input v-model="rementushutushumingcheng" placeholder="图书名称"></el-input>
		</el-col>
		<el-col :span="3" v-if="queryIndex==0">
			<el-button type="primary" @click="search('rementushu')">搜索</el-button>
		</el-col>
	</el-row>



<div class="recommend" :style='{"width":"86%","margin":"0 auto 10px","background":"none"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"200px","margin":"40px auto","lineHeight":"54px","textAlign":"center"}'>
		<span :style='{"color":"rgba(0, 0, 0, 1)","fontSize":"28px"}'>热门图书推荐</span>
	</div>
	
	
	
	
	
	<!-- 样式四 -->
	<div class="list list4 index-pv1" :style='{"width":"100%","padding":"0px","position":"relative","flexWrap":"wrap","display":"flex","height":"auto"}'>
		<div v-if="rementushuRecommend.length>0" class="list-item animation-box" @click="toDetail('rementushuDetail', rementushuRecommend[0])" :style='{"border":"1px solid #707070","boxShadow":"50px -50px 0px -0px rgba(63,55,168,0.75)","margin":"0 0px 0 0","overflow":"hidden","borderRadius":"25px","width":"40%","position":"absolute","right":"0","height":"870px"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"810px"}' v-if="preHttp(rementushuRecommend[0].tushufengmian)" :src="rementushuRecommend[0].tushufengmian.split(',')[0]" alt="" />
			<img :style='{"objectFit":"cover","width":"100%","height":"810px"}' v-else :src="baseUrl + (rementushuRecommend[0].tushufengmian?rementushuRecommend[0].tushufengmian.split(',')[0]:'')" alt="" />
			<div class="title line1" :style='{"color":"rgba(0, 0, 0, 1)","textAlign":"center","background":"rgba(233, 242, 255, 1)","width":"100%","lineHeight":"60px","fontSize":"18px","height":"60px"}'>
                <div>{{rementushuRecommend[0].tushumingcheng}}</div>
            </div>
		</div>
		<div class="list-body" :style='{"width":"55%","margin":"0 5% 35px 0","background":"none","justifyContent":"space-between","display":"flex","height":"400px"}'>
			<div v-if="rementushuRecommend.length>1" @click="toDetail('rementushuDetail', rementushuRecommend[1])" class="list-item animation-box" :style='{"border":"1px solid #707070","margin":"0 0px","overflow":"hidden","borderRadius":"25px","width":"45%","position":"relative","height":"400px"}'>
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-if="preHttp(rementushuRecommend[1].tushufengmian)" :src="rementushuRecommend[1].tushufengmian.split(',')[0]" alt="" />
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-else :src="baseUrl + (rementushuRecommend[1].tushufengmian?rementushuRecommend[1].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"color":"rgba(0, 0, 0, 1)","textAlign":"center","background":"rgba(233, 242, 255, 1)","width":"100%","lineHeight":"60px","fontSize":"18px","height":"60px"}'>
                    <div>{{rementushuRecommend[1].tushumingcheng}}</div>
                </div>
			</div>
			<div v-if="rementushuRecommend.length>2" @click="toDetail('rementushuDetail', rementushuRecommend[2])" class="list-item animation-box" :style='{"border":"1px solid #707070","margin":"0 0px","overflow":"hidden","borderRadius":"25px","width":"45%","position":"relative","height":"400px"}'>
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-if="preHttp(rementushuRecommend[2].tushufengmian)" :src="rementushuRecommend[2].tushufengmian.split(',')[0]" alt="" />
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-else :src="baseUrl + (rementushuRecommend[2].tushufengmian?rementushuRecommend[2].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"color":"rgba(0, 0, 0, 1)","textAlign":"center","background":"rgba(233, 242, 255, 1)","width":"100%","lineHeight":"60px","fontSize":"18px","height":"60px"}'>
                    <div>{{rementushuRecommend[2].tushumingcheng}}</div>
                </div>
			</div>
		</div>
		<div class="list-body" :style='{"width":"55%","margin":"35px 5% 40px 0","justifyContent":"space-between","display":"flex","height":"400px"}'>
			<div v-if="rementushuRecommend.length>3" @click="toDetail('rementushuDetail', rementushuRecommend[3])" class="list-item animation-box" :style='{"border":"1px solid #707070","margin":"0 0px","overflow":"hidden","borderRadius":"25px","width":"45%","position":"relative","height":"400px"}'>
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-if="preHttp(rementushuRecommend[3].tushufengmian)" :src="rementushuRecommend[3].tushufengmian.split(',')[0]" alt="" />
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-else :src="baseUrl + (rementushuRecommend[3].tushufengmian?rementushuRecommend[3].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"color":"rgba(0, 0, 0, 1)","textAlign":"center","background":"rgba(233, 242, 255, 1)","width":"100%","lineHeight":"60px","fontSize":"18px","height":"60px"}'>
                    <div>{{rementushuRecommend[3].tushumingcheng}}</div>
                </div>
			</div>
			<div v-if="rementushuRecommend.length>4" @click="toDetail('rementushuDetail', rementushuRecommend[4])" class="list-item animation-box" :style='{"border":"1px solid #707070","margin":"0 0px","overflow":"hidden","borderRadius":"25px","width":"45%","position":"relative","height":"400px"}'>
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-if="preHttp(rementushuRecommend[4].tushufengmian)" :src="rementushuRecommend[4].tushufengmian.split(',')[0]" alt="" />
				<img :style='{"objectFit":"cover","width":"100%","height":"340px"}' v-else :src="baseUrl + (rementushuRecommend[4].tushufengmian?rementushuRecommend[4].tushufengmian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"color":"rgba(0, 0, 0, 1)","textAlign":"center","background":"rgba(233, 242, 255, 1)","width":"100%","lineHeight":"60px","fontSize":"18px","height":"60px"}'>
                    <div>{{rementushuRecommend[4].tushumingcheng}}</div>
                </div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	<div @click="moreBtn('rementushu')" :style='{"border":"0","margin":"10px auto 40px","borderRadius":"10px","textAlign":"center","background":"#6f69be","display":"block","width":"100px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

	<!-- 系统简介 -->
	<div :style='{"padding":"30px 7%","boxShadow":"0 1px 6px rgba(255, 255, 255, .3)","margin":"0 0 10px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
	  <div :style='{"width":"100%","lineHeight":"1.5","fontSize":"40px","color":"#333","textAlign":"center"}'>{{systemIntroductionDetail.title}}</div>
	  <div :style='{"width":"100%","margin":"10px 0 20px","lineHeight":"1.5","fontSize":"20px","color":"#999","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</div>
	  <div :style='{"width":"60%","padding":"0 10px","flexWrap":"wrap","flexDirection":"column","display":"flex","height":"auto"}'>
	    <img :style='{"border":"5px solid #FFFFFF","margin":"0 10px 0 0","objectFit":"cover","borderRadius":"25px","display":"block","width":"60%","height":"320px"}' :src="baseUrl + systemIntroductionDetail.picture1">
	    <img :style='{"border":"5px solid #FFFFFF","margin":"-150px 0 0 15%","objectFit":"cover","borderRadius":"25px","display":"block","width":"60%","height":"320px"}' :src="baseUrl + systemIntroductionDetail.picture2">
	    <img :style='{"border":"5px solid #FFFFFF","margin":"-150px 0 0 30%","objectFit":"cover","borderRadius":"25px","display":"block","width":"60%","height":"320px"}' :src="baseUrl + systemIntroductionDetail.picture3">
	  </div>
	  <div :style='{"padding":"30px","boxShadow":" 0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"0 0 10px 0","overflow":"hidden","color":"rgb(102, 102, 102)","width":"40%","lineHeight":"30px","fontSize":"16px","textIndent":"2em","height":"650px"}' v-html="systemIntroductionDetail.content"></div>
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	</div>
	
<div class="news" :style='{"padding":"20px 7%","margin":"0 0 10px","background":"rgba(233, 242, 255, 1)"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"200px","margin":"10px auto 20px","lineHeight":"54px","textAlign":"center"}'>
		<span :style='{"color":"#000","fontSize":"28px"}'>公告信息</span>
	</div>
	
	
	
	
	
	<!-- 样式四 -->
	<div v-if="newsList.length" class="list list4 index-pv1" :style='{"width":"100%","padding":"0px","flexWrap":"wrap","justifyContent":"center","display":"flex","height":"auto"}'>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"width":"33%","padding":"20px","height":"300px"}'>
			<div :style='{"margin":"0 0 10px","overflow":"hidden","color":"rgba(0, 0, 0, 1)","textAlign":"center","fontSize":"16px","lineHeight":"25px","height":"50px"}' class="new-list-item-title line1">{{newsList[0].title}}</div>
			<div :style='{"padding":"0 20px","margin":"0 0 10px","overflow":"hidden","color":"#666","fontSize":"14px","lineHeight":"25px","height":"125px"}' class="descript  line3">{{newsList[0].introduction}}</div>
			<div :style='{"width":"100%","padding":"10px","fontSize":"12px","color":"#000","textAlign":"center","background":"rgba(252, 190, 75, 1)"}' class="time">{{newsList[0].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"width":"33%","background":"#fcbe4b","height":"300px"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[0].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"width":"33%","padding":"20px","height":"300px"}'>
			<div :style='{"margin":"0 0 10px","overflow":"hidden","color":"#000","textAlign":"center","fontSize":"16px","lineHeight":"25px","height":"50px"}' class="new-list-item-title line1">{{newsList[1].title}}</div>
			<div :style='{"margin":"0 0 10px","fontSize":"14px","lineHeight":"25px","overflow":"hidden","color":"#666","height":"125px"}' class="descript  line3">{{newsList[1].introduction}}</div>
			<div :style='{"padding":"10px","fontSize":"12px","color":"#000","textAlign":"center","background":"#fcbe4b"}' class="time">{{newsList[1].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"width":"33%","background":"#fcbe4b","height":"300px"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[1].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"width":"33%","padding":"20px","height":"300px"}'>
			<div :style='{"margin":"0 0 10px","overflow":"hidden","color":"#000","textAlign":"center","fontSize":"16px","lineHeight":"25px","height":"50px"}' class="new-list-item-title  line1">{{newsList[2].title}}</div>
			<div :style='{"margin":"0 0 10px","fontSize":"14px","lineHeight":"25px","overflow":"hidden","color":"#666","height":"125px"}' class="descript  line3">{{newsList[2].introduction}}</div>
			<div :style='{"padding":"10px","fontSize":"12px","color":"#000","textAlign":"center","background":"#fcbe4b"}' class="time">{{newsList[2].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"width":"33%","background":"#fcbe4b","height":"300px"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[2].picture" alt="">
	    </div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('news')" :style='{"border":"0","margin":"10px auto","borderRadius":"10px","textAlign":"center","background":"#fcbe4b","display":"block","width":"100px","lineHeight":"40px"}'>
		<span :style='{"color":"#000","fontSize":"16px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#000","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>


<div class="lists" :style='{"padding":"20px 0 10px","margin":"0 0 10px","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"200px","margin":"20px auto","lineHeight":"54px","textAlign":"center"}'>
	  <span :style='{"color":"#000","fontSize":"28px"}'>新书信息展示</span>
	</div>
	
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"width":"100%","padding":"0 7%","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
		<div :style='{"border":"1px solid #707070","margin":"0 0","background":"#f5f5f5","display":"inline-block","width":"18%","position":"relative","height":"auto"}' v-for="(item,index) in xinshuxinxiList" :key="index" @click="toDetail('xinshuxinxiDetail', item)" class="list-item animation-box">
			<img :style='{"width":"100%","objectFit":"cover","display":"block","height":"500px"}' v-if="preHttp(item.tushufengmian)" :src="item.tushufengmian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","display":"block","height":"500px"}' v-else :src="baseUrl + (item.tushufengmian?item.tushufengmian.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"padding":"10px","lineHeight":"32px","fontSize":"14px","color":"#000","textAlign":"center","background":"rgba(233, 242, 255, 1)"}'>{{item.tushumingcheng}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('xinshuxinxi')" :style='{"border":"0","margin":"30px auto 20px","borderRadius":"10px","textAlign":"center","background":"#00b9ea","display":"block","width":"100px","lineHeight":"40px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"16px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        systemIntroductionDetail: {},
        queryList:[
          {
              queryName:"图书名称",
          },
        ],
        queryIndex: 0,
        rementushutushumingcheng: '',
        newsList: [],
        rementushuRecommend: [],

        xinshuxinxiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getSystemIntroduction();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
      search(tablename) {
        if (this.queryIndex == 0 && this.rementushutushumingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.rementushutushumingcheng}});
        }
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 6,
                sort: 'addtime',
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "rementushu/autoSort";
          if(localStorage.getItem('Token')) {
              autoSortUrl = "rementushu/autoSort2";
          }
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.rementushuRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			this.$http.get('xinshuxinxi/list', {params: {
				sort : 'faburiqi',
				order: 'desc',
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.xinshuxinxiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(1.02) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: scale(0.9) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(1) skew(0deg, 0deg) translate3d(0px, -30px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
