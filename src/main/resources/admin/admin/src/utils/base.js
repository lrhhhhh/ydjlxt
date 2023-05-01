const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootr2ork/",
            name: "springbootr2ork",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootr2ork/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于web阅读管理系统"
        } 
    }
}
export default base
