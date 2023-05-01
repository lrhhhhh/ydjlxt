<template>
<div :style='{"width":"1100px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.302)","margin":"10px auto","position":"relative","background":"#fff"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="笔记名称" prop="bijimingcheng">
            <el-input v-model="ruleForm.bijimingcheng" 
                placeholder="笔记名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="图片信息" v-if="type!='cross' || (type=='cross' && !ro.tupianxinxi)" prop="tupianxinxi">
            <file-upload
            tip="点击上传图片信息"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.tupianxinxi?ruleForm.tupianxinxi:''"
            @change="tupianxinxiUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' class="upload" v-else label="图片信息" prop="tupianxinxi">
                <img v-if="ruleForm.tupianxinxi.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupianxinxi.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupianxinxi.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="笔记类型" prop="bijileixing">
            <el-select v-model="ruleForm.bijileixing" placeholder="请选择笔记类型"  >
              <el-option
                  v-for="(item,index) in bijileixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="笔记日期" prop="bijiriqi" disabled>
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.bijiriqi" 
                  type="date"
                  placeholder="笔记日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="笔记内容" prop="bijineirong">
            <editor 
                :style='{"padding":"0","margin":"0","borderColor":"#00B9EA","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","background":"#f6f6f6","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.bijineirong" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(252, 190, 75, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#00b9ea","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            bijimingcheng : false,
            tupianxinxi : false,
            bijineirong : false,
            bijileixing : false,
            bijiriqi : false,
            userid : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          bijimingcheng: '',
          tupianxinxi: '',
          bijineirong: '',
          bijileixing: '',
          bijiriqi: '',
          userid: '',
        },
        bijileixingOptions: [],
        rules: {
          bijimingcheng: [
          ],
          tupianxinxi: [
          ],
          bijineirong: [
          ],
          bijileixing: [
          ],
          bijiriqi: [
          ],
          userid: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.bijiriqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='bijimingcheng'){
              this.ruleForm.bijimingcheng = obj[o];
              this.ro.bijimingcheng = true;
              continue;
            }
            if(o=='tupianxinxi'){
              this.ruleForm.tupianxinxi = obj[o].split(",")[0];
              this.ro.tupianxinxi = true;
              continue;
            }
            if(o=='bijineirong'){
              this.ruleForm.bijineirong = obj[o];
              this.ro.bijineirong = true;
              continue;
            }
            if(o=='bijileixing'){
              this.ruleForm.bijileixing = obj[o];
              this.ro.bijileixing = true;
              continue;
            }
            if(o=='bijiriqi'){
              this.ruleForm.bijiriqi = obj[o];
              this.ro.bijiriqi = true;
              continue;
            }
            if(o=='userid'){
              this.ruleForm.userid = obj[o];
              this.ro.userid = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/bijileixing/bijileixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.bijileixingOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('yuedubiji/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('yuedubiji/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('yuedubiji/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('yuedubiji/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      tupianxinxiUploadChange(fileUrls) {
          this.ruleForm.tupianxinxi = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #00B9EA;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #000;
	  background: #f6f6f6;
	  width: 300px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #00B9EA;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #000;
	  background: #f6f6f6;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #00B9EA;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #000;
	  background: #f6f6f6;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #00B9EA;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00B9EA;
	  background: #f6f6f6;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #00B9EA;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00B9EA;
	  background: #f6f6f6;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #00B9EA;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #00B9EA;
	  background: #f6f6f6;
	  width: 80px;
	  font-size: 32px;
	  line-height: 80px;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #00B9EA;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #000;
	  background: #f6f6f6;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
