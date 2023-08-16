package com.example.demo.service;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/12/10 15:47
 */
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
public class testemail {

    public void sample() {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("ap-southeast-1", "<your accessKey>", "<your accessSecret>");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("控制台创建的发信地址");
            request.setFromAlias("发信人昵称");//发信人昵称，长度小于15个字符。
            request.setAddressType(1);//0：为随机账号 1：为发信地址
            request.setTagName("控制台创建的标签");
            request.setReplyToAddress(true);// 是否启用管理控制台中配置好回信地址（状态须验证通过），取值范围是字符串true或者false
            request.setToAddress("目标地址");
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject("邮件主题");
            //如果采用byte[].toString的方式的话请确保最终转换成utf-8的格式再放入htmlbody和textbody，若编码不一致则会被当成垃圾邮件。
            //注意：文本邮件的大小限制为3M，过大的文本会导致连接超时或413错误
            request.setHtmlBody("邮件正文");
            //SDK 采用的是http协议的发信方式, 默认是GET方法，有一定的长度限制。
            //若textBody、htmlBody或content的大小不确定，建议采用POST方式提交，避免出现uri is not valid异常
            request.setMethod(MethodType.POST);
            //开启需要备案，0关闭，1开启
            //request.setClickTrace("0");
            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ServerException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
        }
        catch (ClientException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
        }
        String a="no-need-login.url = /gateway/api/user/login,/gateway/api/register/register,/gateway/api/fallback/test/method,user/userbase/money/getMup,/api/lang/refresData,/api/user/change,/gateway/api/tenant/register,/gateway/generator/getId,/api/user/code,/gateway/api/user/part/userInfo,/gateway/api/user/part/login,/gateway/api/user/connect,/gateway/api/setting/get/sellingInfo,/gateway/api/setting/get/locInfo,/gateway/api/setting/get/busAreaInfo,/gateway/api/tenant/sendCode,/gateway/api/tenant/verifyCode,/gateway/api/tenant/regist,/gateway/api/tenant/getAddressInfo,/gateway/api/user/line/bind,/gateway/api/tenant/complete/info,/gateway/api/user/parseToken,/gateway/api/role/initAllTenantRoleAndRoleResource,/gateway/api/resource/refreshResourceAndRoleResourceCache,/gateway/api/channelshop/shopee/token/authorizationRedirect,/gateway/api/tenant/tenantMessageExport,/gateway/api/channelshop/lazada/token/authorizationRedirect,/gateway/api/dfs/dfsUplocadClient/upload,/gateway/api/channelshop/tiktok/token/tikTokCallback,/gateway/api/user/checkToken,/gateway/api/user/updatePasswordForUser,/gateway/api/channelManage/cacheAllChannelManageTokenFromRedis,/gateway/redirect/fb";
    }
}
